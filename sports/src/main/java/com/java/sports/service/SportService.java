package com.java.sports.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.sports.model.Sport;
import com.java.sports.repository.SportRepo;

@Service
public class SportService {
    @Autowired
    private SportRepo sportRepo;

    public Sport createSport(Sport sport){
        return sportRepo.save(sport);
    }

    public List<Sport> getAllSports(){
        return sportRepo.findAll();
    }

    public Optional<Sport> getSportById(Integer sportId){
        return sportRepo.findById(sportId);
    }

    public Sport updateSport(Sport sport){
        return sportRepo.save(sport);
    }
}
