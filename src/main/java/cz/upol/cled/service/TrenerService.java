package cz.upol.cled.service;

import org.springframework.stereotype.Service;

import cz.upol.cled.model.Trener;
import cz.upol.cled.repository.TrenerRepository;

@Service
public class TrenerService {

    private final TrenerRepository trenerRepository;

    public TrenerService(TrenerRepository trenerRepository) {
        this.trenerRepository = trenerRepository;
    }

    public Trener uloz(Trener trener) {
        return trenerRepository.save(trener);
    }

    public void smaz(Long id) {
        trenerRepository.deleteById(id);
    }
}
