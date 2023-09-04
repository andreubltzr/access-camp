package com.example.springproject.signup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignupRepository extends JpaRepository<Signup, Integer> {

    List<Signup> findByCamperId(int camperId);
}
