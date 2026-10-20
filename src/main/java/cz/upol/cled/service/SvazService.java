package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.Svaz;
import cz.upol.cled.repository.SvazRepository;

@Service
public class SvazService {

    private final SvazRepository svazRepository;

    public SvazService(SvazRepository svazRepository) {
        this.svazRepository = svazRepository;
    }

    public Svaz uloz(Svaz svaz) {
        return svazRepository.save(svaz);
    }

    public void smaz(Long id) {
        svazRepository.deleteById(id);
    }
}
