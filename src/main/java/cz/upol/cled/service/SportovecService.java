package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.Sportovec;
import cz.upol.cled.repository.SportovecRepository;

@Service
public class SportovecService {

    private final SportovecRepository sportovecRepository;

    public SportovecService(SportovecRepository sportovecRepository) {
        this.sportovecRepository = sportovecRepository;
    }

    public Sportovec uloz(Sportovec sportovec) {
        return sportovecRepository.save(sportovec);
    }

    public void smaz(Long id) {
        sportovecRepository.deleteById(id);
    }
}
