package cz.upol.cled.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cz.upol.cled.dto.UzivatelPrehledDto;
import cz.upol.cled.model.Uzivatel;
import cz.upol.cled.repository.UzivatelRepository;

@Service
public class UzivatelService {

    private final UzivatelRepository uzivatelRepository;
    private final PasswordEncoder passwordEncoder;

    public UzivatelService(
            UzivatelRepository uzivatelRepository,
            PasswordEncoder passwordEncoder) {

        this.uzivatelRepository = uzivatelRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Vyhledá uživatele podle e-mailové adresy.
     *
     * @param email e-mail uživatele
     * @return nalezený uživatel
     */
    public Optional<Uzivatel> najdiPodleEmailu(String email) {
        return uzivatelRepository.findByEmail(email);
    }

    /**
     * Uloží uživatele do databáze.
     * Heslo před uložením zahashuje pomocí BCrypt.
     *
     * @param uzivatel uživatel, který se má uložit
     * @return uložený uživatel
     */
    public Uzivatel uloz(Uzivatel uzivatel) {

        if (uzivatel.getHeslo() != null
                && !uzivatel.getHeslo().isBlank()) {

            uzivatel.setHeslo(
                    passwordEncoder.encode(uzivatel.getHeslo())
            );
        }

        return uzivatelRepository.save(uzivatel);
    }

    /**
     * Smaže uživatele podle jeho ID.
     *
     * @param id ID uživatele
     */
    public void smaz(Long id) {
        uzivatelRepository.deleteById(id);
    }

    /**
     * Vrátí seznam uživatelských účtů pro administraci.
     * Hesla ani jejich hashe se do výsledku nepředávají.
     *
     * @return seznam uživatelů pro administrátorský přehled
     */
    public List<UzivatelPrehledDto> najdiVsechnyProAdministraci() {
        return uzivatelRepository.findAll()
                .stream()
                .map(uzivatel -> new UzivatelPrehledDto(
                        uzivatel.getId(),
                        uzivatel.getJmeno(),
                        uzivatel.getPrijmeni(),
                        uzivatel.getEmail(),
                        Set.copyOf(uzivatel.getRole()),
                        uzivatel.isAktivni()
                ))
                .toList();
    }
}