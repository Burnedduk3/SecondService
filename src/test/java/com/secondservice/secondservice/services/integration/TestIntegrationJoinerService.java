package com.secondservice.secondservice.services.integration;

import com.github.javafaker.Faker;
import com.secondservice.secondservice.models.Joiner;
import com.secondservice.secondservice.repositories.JoinerRepository;
import com.secondservice.secondservice.services.JoinerService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
class TestIntegrationJoinerService {
    private Faker fakeValuesService;
    private List<Integer> idList = new ArrayList<>();

    @Autowired
    JoinerService joinerService;

    @Autowired
    JoinerRepository joinerRepository;

    @BeforeAll
    protected void initializeTests(){
        fakeValuesService = new Faker();
        for (int i = 0; i < 10; i++) {
            Joiner createdJoiner = joinerRepository.saveAndFlush(new Joiner(fakeValuesService.idNumber().hashCode(), fakeValuesService.code().hashCode(), fakeValuesService.name().firstName(), fakeValuesService.name().lastName(), "C1", "Kubernetes",fakeValuesService.number().randomDigit()));
            idList.add(createdJoiner.getId());
        }
    }

    @AfterAll
    protected void afterTests(){
        joinerRepository.deleteAll();
    }

    @Test
    void createJoinerWithService(){
        Joiner joiner = new Joiner(fakeValuesService.idNumber().hashCode(), fakeValuesService.code().hashCode(), fakeValuesService.name().firstName(), fakeValuesService.name().lastName(), "C1", "Kubernetes",fakeValuesService.number().randomDigit());
        Joiner savedJoiner = joinerService.createJoiner(joiner);

        assertNotNull(savedJoiner);
        assertSame(savedJoiner.getName(), joiner.getName());
    }

    @Test
    void getJoinerByIdWithService(){
        Integer numberToSearch = idList.get(fakeValuesService.number().numberBetween(1,10));
        Joiner joinerServiceJoinerById = joinerService.getJoinerById(numberToSearch);
        Joiner joinerRepositoryById = joinerRepository.getOne(numberToSearch);

        assertNotNull(joinerServiceJoinerById);
        assertEquals(joinerServiceJoinerById.getName(), joinerRepositoryById.getName());
    }

    @Test
    void getAllJoinersWithService(){
        List<Joiner> savedJoiner = joinerService.getAllJoiners();

        assertNotNull(savedJoiner);
        assertTrue(savedJoiner.size() >9);
    }

}
