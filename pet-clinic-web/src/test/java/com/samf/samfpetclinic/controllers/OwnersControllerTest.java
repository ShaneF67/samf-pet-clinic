package com.samf.samfpetclinic.controllers;

import com.samf.samfpetclinic.model.Owner;
import com.samf.samfpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnersController controller;

    private Set<Owner> owners;
    private MockMvc mockMvc;
    private final String LAST_NAME1 = "Smith";
    private final String LAST_NAME2 = "Feehily";
    private final Long firstOwnerId = 1L;
    private final Long secondOwnerId = 2L;
    private Owner firstOwner;
    private Owner secondOwner;


    @BeforeEach
    void setUp() {
        firstOwner = Owner.builder().id(firstOwnerId).lastName(LAST_NAME1).build();
        secondOwner = Owner.builder().id(secondOwnerId).lastName(LAST_NAME2).build();
        owners = new HashSet<>();
        owners.add(firstOwner);
        owners.add(secondOwner);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void getOwners() throws Exception {

        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attributeExists("owners"));

        verifyZeroInteractions(ownerService);
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyZeroInteractions(ownerService);
    }
}