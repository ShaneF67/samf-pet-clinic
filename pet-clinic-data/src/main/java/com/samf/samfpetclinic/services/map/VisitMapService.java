package com.samf.samfpetclinic.services.map;

import com.samf.samfpetclinic.model.Visit;
import com.samf.samfpetclinic.repositories.VisitRepository;
import com.samf.samfpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private VisitRepository visitRepository;

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
