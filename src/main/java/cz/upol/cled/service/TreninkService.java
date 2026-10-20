package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.Trenink;
import cz.upol.cled.repository.TreninkRepository;

@Service
public class TreninkService {

    private final TreninkRepository treninkRepository;

    public TreninkService(TreninkRepository treninkRepository) {
        this.treninkRepository = treninkRepository;
    }

    public Trenink uloz(Trenink trenink) {
        return treninkRepository.save(trenink);
    }

    public void smaz(Long id) {
        treninkRepository.deleteById(id);
    }
}
