package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.UcastNaTreninku;
import cz.upol.cled.repository.UcastNaTreninkuRepository;

@Service
public class UcastNaTreninkuService {

    private final UcastNaTreninkuRepository ucastNaTreninkuRepository;

    public UcastNaTreninkuService(
            UcastNaTreninkuRepository ucastNaTreninkuRepository) {
        this.ucastNaTreninkuRepository = ucastNaTreninkuRepository;
    }

    public UcastNaTreninku uloz(UcastNaTreninku ucastNaTreninku) {
        return ucastNaTreninkuRepository.save(ucastNaTreninku);
    }

    public void smaz(Long id) {
        ucastNaTreninkuRepository.deleteById(id);
    }
}
