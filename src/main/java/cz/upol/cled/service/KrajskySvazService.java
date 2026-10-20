package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.KrajskySvaz;
import cz.upol.cled.repository.KrajskySvazRepository;

@Service
public class KrajskySvazService {

    private final KrajskySvazRepository krajskySvazRepository;

    public KrajskySvazService(KrajskySvazRepository krajskySvazRepository) {
        this.krajskySvazRepository = krajskySvazRepository;
    }

    public KrajskySvaz uloz(KrajskySvaz krajskySvaz) {
        return krajskySvazRepository.save(krajskySvaz);
    }

    public void smaz(Long id) {
        krajskySvazRepository.deleteById(id);
    }
}
