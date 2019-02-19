package com.samf.samfpetclinic.bootstrap;

import com.samf.samfpetclinic.model.Owner;
import com.samf.samfpetclinic.model.Pet;
import com.samf.samfpetclinic.model.PetType;
import com.samf.samfpetclinic.model.Vet;
import com.samf.samfpetclinic.services.OwnerService;
import com.samf.samfpetclinic.services.PetTypeService;
import com.samf.samfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

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

        System.out.println("Set owners......");


        Vet vet1 = new Vet();
        vet1.setFirstName("David");
        vet1.setLastName("McGurrin");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Patters");
        vet2.setLastName("Maguire");

        vetService.save(vet2);

        System.out.println("Saved vets.......");

    }
}
