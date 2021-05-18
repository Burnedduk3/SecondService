package com.secondservice.secondservice.services;

import com.secondservice.secondservice.models.Joiner;
import com.secondservice.secondservice.repositories.JoinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class JoinerService {

    @Autowired
    JoinerRepository joinerRepository;

    public Joiner getJoinerById(Integer id) {
        return joinerRepository.getOne(id);
    }

    public boolean joinerExistsById(Integer joinerId){
        return joinerRepository.existsById(joinerId);
    }

    public List<Joiner> getAllJoiners() {
        return joinerRepository.findAll();
    }

    public Joiner createJoiner(Joiner joiner){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8080/role/exists/" + joiner.getRoleId();
        boolean roleExists = restTemplate.getForObject(uri, Boolean.class);

        if (!roleExists){
            throw new EntityNotFoundException();
        }

        return joinerRepository.saveAndFlush(joiner);
    }

}