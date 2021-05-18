package com.secondservice.secondservice.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class JoinerTest {

    @Test
    void testCreateJoinerEmptyConstructor() throws Exception {
        Joiner joiner = new Joiner();
        assertNull(joiner.getId());
    }

    @Test
    void testCreateJoinerAllParamsConstructor() throws Exception {
        Joiner joiner = new Joiner(0, 10, "juan", "perez", "C1", "Kubernetes",1);

        assertEquals(0, (int) joiner.getId());
        assertEquals(10, (int) joiner.getIdentificationNumber());
        assertSame("juan", joiner.getName());
        assertSame("perez", joiner.getLastname());
        assertSame("C1", joiner.getEnglishLevel());
        assertSame("Kubernetes", joiner.getDomainExperience());
        assertSame("DevOps", joiner.getRoleId());
    }

    @Test
    void testJoinerSetters() throws Exception{
        Joiner joiner = new Joiner();

        joiner.setId(120);

        assertEquals(120, (int) joiner.getId());

        joiner.setName("Juanita");

        assertSame("Juanita", joiner.getName());

        joiner.setLastname("Perez");

        assertSame("Perez", joiner.getLastname());

        joiner.setEnglishLevel("B2");

        assertSame("B2", joiner.getEnglishLevel());

        joiner.setDomainExperience("C++");

        assertSame("C++", joiner.getDomainExperience());

        joiner.setRoleId(1);

        assertSame(1, joiner.getRoleId());
    }
}
