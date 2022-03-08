package com.ethanedmond.spring.controller;

import com.ethanedmond.spring.model.Artist;
import com.ethanedmond.spring.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {
    ArtistService service;

    @Autowired
    public ArtistController(ArtistService service) {
        this.service = service;
    }

    @PostMapping
    public Artist addUser(@RequestBody Artist user) {
        return this.service.save(user);
    }

    @GetMapping
    public List<Artist> findAll() {
        return this.service.findAll();
    }

    @GetMapping("username/{username}")
    public Artist findByUsername(@RequestBody String username) { return this.service.findByUsername(username); }
}
