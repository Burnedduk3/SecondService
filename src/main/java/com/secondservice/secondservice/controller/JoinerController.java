package com.secondservice.secondservice.controller;

import com.secondservice.secondservice.models.Joiner;
import com.secondservice.secondservice.services.JoinerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "JoinerControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class JoinerController {

    @Autowired
    private JoinerService joinerService;

    @GetMapping("/get-all")
    public List<Joiner> joinerList(){
        return joinerService.getAllJoiners();
    }

    @GetMapping("/{joinerId}")
    public ResponseEntity<Joiner> getJoinerById(@PathVariable Integer joinerId){
        return ResponseEntity.ok(joinerService.getJoinerById(joinerId));
    }

    @GetMapping("/exists/{joinerId}")
    public boolean JoinerExistsById(@PathVariable Integer joinerId){
        return joinerService.joinerExistsById(joinerId);
    }

    @PostMapping("/joiner")
    public Joiner createJoiner(@RequestBody Joiner joiner) {
        return joinerService.createJoiner(joiner);
    }

}
