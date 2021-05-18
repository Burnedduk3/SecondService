package com.secondservice.secondservice.repositories;

import com.github.javafaker.Faker;
import com.secondservice.secondservice.models.Joiner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
class TestJoinersRepository {

    private Faker fakeValuesService;

    @Autowired
    JoinerRepository joinerRepository;

    @BeforeAll
    public void initializeTests(){
        fakeValuesService = new Faker();
    }

    @AfterAll
    public void afterTests(){
        joinerRepository.deleteAll();
    }


    @Test
    void createJoiner () {
        Joiner joiner = new Joiner(fakeValuesService.idNumber().hashCode(), fakeValuesService.code().hashCode(), fakeValuesService.name().firstName(), fakeValuesService.name().lastName(), "C1", "Kubernetes",fakeValuesService.number().randomDigit());
        Joiner savedJoiner = joinerRepository.saveAndFlush(joiner);
        assertEquals(savedJoiner.getName(), joiner.getName());
    }

    @Test
    void deleteJoinerById () {
        Joiner joiner = new Joiner(fakeValuesService.idNumber().hashCode(), fakeValuesService.code().hashCode(), fakeValuesService.name().firstName(), fakeValuesService.name().lastName(), "C1", "Kubernetes",fakeValuesService.number().randomDigit());
        Joiner savedJoiner = joinerRepository.saveAndFlush(joiner);
        joinerRepository.deleteById(savedJoiner.getId());
        assertFalse(joinerRepository.existsById(savedJoiner.getId()));
    }

    @Test
    void getJoinerByID() {
        Joiner joiner = new Joiner(fakeValuesService.idNumber().hashCode(), fakeValuesService.code().hashCode(), fakeValuesService.name().firstName(), fakeValuesService.name().lastName(), "C1", "Kubernetes",fakeValuesService.number().randomDigit());
        Joiner savedJoiner = joinerRepository.saveAndFlush(joiner);
        assertEquals(savedJoiner.getName(),savedJoiner.getName());
    }
}
