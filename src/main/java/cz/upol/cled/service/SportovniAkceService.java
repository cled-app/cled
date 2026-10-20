package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.SportovniAkce;
import cz.upol.cled.repository.SportovniAkceRepository;

@Service
public class SportovniAkceService {

    private final SportovniAkceRepository sportovniAkceRepository;

    public SportovniAkceService(SportovniAkceRepository sportovniAkceRepository) {
        this.sportovniAkceRepository = sportovniAkceRepository;
    }

    public SportovniAkce uloz(SportovniAkce sportovniAkce) {
        return sportovniAkceRepository.save(sportovniAkce);
    }

    public void smaz(Long id) {
        sportovniAkceRepository.deleteById(id);
    }
}
