package com.java.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.sports.model.Sport;

@Repository
public interface SportRepo extends JpaRepository<Sport, Integer> {
}
