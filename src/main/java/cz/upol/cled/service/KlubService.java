package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.Klub;
import cz.upol.cled.repository.KlubRepository;

@Service
public class KlubService {

    private final KlubRepository klubRepository;

    public KlubService(KlubRepository klubRepository) {
        this.klubRepository = klubRepository;
    }

    public Klub uloz(Klub klub) {
        return klubRepository.save(klub);
    }

    public void smaz(Long id) {
        klubRepository.deleteById(id);
    }
}
