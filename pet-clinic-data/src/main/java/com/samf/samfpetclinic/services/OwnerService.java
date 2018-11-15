package com.samf.samfpetclinic.services;

import com.samf.samfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
