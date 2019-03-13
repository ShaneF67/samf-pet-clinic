package com.samf.samfpetclinic.bootstrap;

import com.samf.samfpetclinic.model.*;
import com.samf.samfpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Shane");
        owner1.setLastName("Feehily");
        owner1.setAddress("Kevinsfort");
        owner1.setCity("Sligo");
        owner1.setTelephone("235345345");

        Pet shanesPet = new Pet();
        shanesPet.setName("Mimzy");
        shanesPet.setPetType(savedDogType);
        shanesPet.setBirthDate(LocalDate.now());
        shanesPet.setOwner(owner1);
        owner1.getPets().add(shanesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ian");
        owner2.setLastName("Smith");
        owner2.setAddress("Laureles");
        owner2.setCity("Medellin");
        owner2.setTelephone("8763876");

        Pet iansPet = new Pet();
        iansPet.setName("Anna");
        iansPet.setPetType(savedCatType);
        iansPet.setBirthDate(LocalDate.now());
        iansPet.setOwner(owner2);
        owner2.getPets().add(iansPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(iansPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sick Cat");

        System.out.println("Set owners......");


        Vet vet1 = new Vet();
        vet1.setFirstName("David");
        vet1.setLastName("McGurrin");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Patters");
        vet2.setLastName("Maguire");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Saved vets.......");
    }
}
