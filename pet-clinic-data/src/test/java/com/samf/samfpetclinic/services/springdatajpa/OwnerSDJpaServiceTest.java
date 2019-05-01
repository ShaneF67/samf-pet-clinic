package com.samf.samfpetclinic.services.springdatajpa;

import com.samf.samfpetclinic.model.Owner;
import com.samf.samfpetclinic.repositories.OwnerRepository;
import com.samf.samfpetclinic.repositories.PetRepository;
import com.samf.samfpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private final String LAST_NAME = "Smith";
    private final Long ownerId = 1L;
    private Owner builtOwner;

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        builtOwner = Owner.builder().id(ownerId).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(builtOwner);
        Owner smith = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwnersSet = new HashSet<>();
        returnedOwnersSet.add(Owner.builder().id(1L).build());
        returnedOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnedOwnersSet);

        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(builtOwner));
        Owner owner = service.findById(ownerId);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(ownerId);
        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(builtOwner)).thenReturn(builtOwner);
        Owner savedOwner = service.save(builtOwner);
        assertNotNull(savedOwner);
        assertEquals(ownerId, savedOwner.getId());
        assertEquals(LAST_NAME, savedOwner.getLastName());
        verify(ownerRepository).save(any(Owner.class));
    }

    @Test
    void delete() {
        service.delete(builtOwner);
        verify(ownerRepository, times(1)).delete(any(Owner.class));
    }

    @Test
    void deleteById() {
        service.deleteById(ownerId);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}