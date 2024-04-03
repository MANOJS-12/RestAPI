package com.java.sports.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.java.sports.model.Sport;
import com.java.sports.service.SportService;

@RestController
@RequestMapping("/api")
public class SportController {
    @Autowired
    private SportService sportService;
    
    @PostMapping("/sport")
    public ResponseEntity<Sport> createSport(@RequestBody Sport sport){
        Sport createdSport = sportService.createSport(sport);
        if (createdSport != null) {
            return new ResponseEntity<>(createdSport, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sport")
    public ResponseEntity<List<Sport>> getAllSports(){
        List<Sport> sports = sportService.getAllSports();
        if (!sports.isEmpty()) {
            return new ResponseEntity<>(sports, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sport/{sportId}")
    public ResponseEntity<Sport> getSportById(@PathVariable int sportId){
        Optional<Sport> sport = sportService.getSportById(sportId);
        if (sport.isPresent()) {
            return new ResponseEntity<>(sport.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/sport/{sportId}")
    public ResponseEntity<Sport> updateSport(@PathVariable int sportId, @RequestBody Sport updatedSport) {
        Optional<Sport> optionalSport = sportService.getSportById(sportId);
        if (optionalSport.isPresent()) {
            Sport existingSport = optionalSport.get();
            existingSport.setName(updatedSport.getName());
            existingSport.setEmail(updatedSport.getEmail());
            existingSport.setAge(updatedSport.getAge());
            Sport updatedUser = sportService.updateSport(existingSport);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
