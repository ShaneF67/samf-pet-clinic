package com.samf.samfpetclinic.repositories;

import com.samf.samfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
