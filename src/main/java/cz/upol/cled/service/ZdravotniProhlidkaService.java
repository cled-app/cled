package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.ZdravotniProhlidka;
import cz.upol.cled.repository.ZdravotniProhlidkaRepository;

@Service
public class ZdravotniProhlidkaService {

    private final ZdravotniProhlidkaRepository zdravotniProhlidkaRepository;

    public ZdravotniProhlidkaService(
            ZdravotniProhlidkaRepository zdravotniProhlidkaRepository) {
        this.zdravotniProhlidkaRepository = zdravotniProhlidkaRepository;
    }

    public ZdravotniProhlidka uloz(ZdravotniProhlidka zdravotniProhlidka) {
        return zdravotniProhlidkaRepository.save(zdravotniProhlidka);
    }

    public void smaz(Long id) {
        zdravotniProhlidkaRepository.deleteById(id);
    }
}
