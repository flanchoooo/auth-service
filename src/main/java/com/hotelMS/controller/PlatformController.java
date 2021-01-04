package com.hotelMS.controller;

import com.hotelMS.domain.Platform;
import com.hotelMS.repository.PlatformRepository;
import com.hotelMS.service.impl.PlatformServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

@RestController
@CrossOrigin
@RequestMapping(value = "/platform")
public class PlatformController {

    @Autowired
    PlatformServiceImpl platformService;

    @Resource
    PlatformRepository platformRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> save(@PathVariable int id) throws Exception {
        return platformService.findById(id);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Platform platform) throws Exception {
        return platformService.save(platform);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Platform findById(@PathVariable String id) throws EntityNotFoundException {
        return platformRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Platform> findAll(final Pageable pageable) throws EntityNotFoundException {
        return platformRepository.findAll(pageable);
    }

}
