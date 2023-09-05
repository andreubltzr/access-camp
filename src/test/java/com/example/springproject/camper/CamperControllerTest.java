package com.example.springproject.camper;

import com.example.springproject.activity.dto.ActivityDTO;
import com.example.springproject.camper.dto.CamperActivityDTO;
import com.example.springproject.camper.dto.CamperDTO;
import com.example.springproject.camper.dto.CamperResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CamperControllerTest {

    @InjectMocks
    private CamperController camperController;

    @Mock
    private CamperService camperService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("getAllCampers should return the list of campers")
    public void getAllCampers() throws Exception {
        List<CamperResponseDTO> mockCampers = Arrays.asList(
                new CamperResponseDTO(1, "John Doe", 14),
                new CamperResponseDTO(2, "Jane Doe", 11)
        );

        when(camperService.getAllCampers()).thenReturn(CompletableFuture.completedFuture(mockCampers));

        CompletableFuture<List<CamperResponseDTO>> res = camperController.getAllCampers();

        List<CamperResponseDTO> campers = res.get();

        assertNotNull(campers);
        assertEquals(mockCampers, campers);
    }

    @Test
    @DisplayName("createCamper should return a new camper")
    public void createCamper() throws Exception {
        CamperDTO mockCamperDTO = new CamperDTO();
        mockCamperDTO.setAge(11);
        mockCamperDTO.setName("John Doe");
        mockCamperDTO.setUsername("johndoe1999");
        mockCamperDTO.setPassword("johndoesecret");

        BindingResult mockBindingResult = mock(BindingResult.class);

        CamperResponseDTO mockCamper = new CamperResponseDTO(1, "John Doe", 11);

        when(camperService.createCamper(mockCamperDTO)).thenReturn(CompletableFuture.completedFuture(mockCamper));

        CompletableFuture<CamperResponseDTO> res = camperController.createCamper(mockCamperDTO, mockBindingResult);

        CamperResponseDTO camperResponse = res.get();

        assertNotNull(camperResponse);
        assertEquals(mockCamper, camperResponse);
    }

    @Test
    @DisplayName("getCamperActivity should return a camper with associated activities")
    public void getCamperActivity() {
        int camperId = 1;

        CamperActivityDTO mockCamperActivityDTO = new CamperActivityDTO(
                camperId,
                "Camper Name",
                11,
                Arrays.asList(
                        new ActivityDTO(1, "Activity 1", 1),
                        new ActivityDTO(2, "Activity 2", 2)
                )
        );

        when(camperService.getCamperActivity(camperId)).thenReturn(mockCamperActivityDTO);

        CamperActivityDTO res = camperController.getCamperActivity(camperId);

        assertNotNull(res);
        assertEquals(camperId, res.getId());
        assertEquals("Camper Name", res.getName());
        assertEquals(11, res.getAge());
        assertNotNull(res.getActivityList());
        assertEquals(2, res.getActivityList().size());
    }

}
