package com.samf.samfpetclinic.bootstrap;

import com.samf.samfpetclinic.model.Owner;
import com.samf.samfpetclinic.model.PetType;
import com.samf.samfpetclinic.model.Vet;
import com.samf.samfpetclinic.services.OwnerService;
import com.samf.samfpetclinic.services.PetTypeService;
import com.samf.samfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ian");
        owner2.setLastName("Smith");

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
