package com.samf.samfpetclinic.bootstrap;

import com.samf.samfpetclinic.model.Owner;
import com.samf.samfpetclinic.model.Vet;
import com.samf.samfpetclinic.services.OwnerService;
import com.samf.samfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;

        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
        vet1.setFirstName("Ingrid");
        vet1.setLastName("Sierra");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Patters");
        vet2.setLastName("Maguire");

        vetService.save(vet2);

        System.out.println("Saved vets.......");

    }
}
