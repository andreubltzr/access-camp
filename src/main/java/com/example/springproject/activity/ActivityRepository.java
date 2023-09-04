package com.example.springproject.activity;

import com.example.springproject.camper.Camper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
