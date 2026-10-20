package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.Rodic;
import cz.upol.cled.repository.RodicRepository;

@Service
public class RodicService {

    private final RodicRepository rodicRepository;

    public RodicService(RodicRepository rodicRepository) {
        this.rodicRepository = rodicRepository;
    }

    public Rodic uloz(Rodic rodic) {
        return rodicRepository.save(rodic);
    }

    public void smaz(Long id) {
        rodicRepository.deleteById(id);
    }
}
