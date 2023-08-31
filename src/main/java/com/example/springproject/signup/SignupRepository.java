package com.example.springproject.signup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<Signup, Integer> {
}
