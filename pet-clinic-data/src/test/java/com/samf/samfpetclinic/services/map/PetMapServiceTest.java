package com.samf.samfpetclinic.services.map;

import com.samf.samfpetclinic.model.Pet;
import com.samf.samfpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    private PetMapService petMapService;
    private Long id = 1L;
    private String petName = "Mimzy";
    private LocalDate dateOfBirth = LocalDate.now();
    private PetType petType = new PetType("Dog");
    private Pet petUnderTest;


    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petUnderTest = Pet.builder().id(id).name(petName).birthDate(dateOfBirth).petType(petType).build();
        petMapService.save(petUnderTest);
    }

    @Test
    void findAll() {
        Set<Pet> findAllResult = petMapService.findAll();
        assertEquals(1, findAllResult.size());
        assertTrue(findAllResult.contains(petUnderTest));
    }

    @Test
    void save() {
        Pet secondPet = Pet.builder().id(2L).name("Shane").birthDate(LocalDate.now())
                .petType(petType).build();
        petMapService.save(secondPet);
        Set<Pet> findAllResult = petMapService.findAll();
        assertEquals(2, findAllResult.size());
        assertTrue(findAllResult.contains(petUnderTest));
        assertTrue(findAllResult.contains(secondPet));
    }

    @Test
    void findById() {
        Pet petById = petMapService.findById(id);
        assertNotNull(petById);
        assertEquals(petName, petById.getName());
        assertEquals(dateOfBirth, petById.getBirthDate());
    }

    @Test
    void delete() {
        Set<Pet> findAllResult = petMapService.findAll();
        assertEquals(1, findAllResult.size());
        petMapService.delete(petUnderTest);

        Set<Pet> findAllResultAfterDelete = petMapService.findAll();
        assertEquals(0, findAllResultAfterDelete.size());
    }

    @Test
    void deleteById() {

        Set<Pet> findAllResult = petMapService.findAll();
        assertEquals(1, findAllResult.size());
        petMapService.deleteById(id);

        Set<Pet> findAllResultAfterDelete = petMapService.findAll();
        assertEquals(0, findAllResultAfterDelete.size());
    }
}