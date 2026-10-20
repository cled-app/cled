package cz.upol.cled.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cz.upol.cled.model.Uzivatel;
import cz.upol.cled.repository.UzivatelRepository;

@Service
public class CledUserDetailsService implements UserDetailsService {

    private final UzivatelRepository uzivatelRepository;

    public CledUserDetailsService(UzivatelRepository uzivatelRepository) {
        this.uzivatelRepository = uzivatelRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Uzivatel uzivatel = uzivatelRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Uživatel s e-mailem " + email + " nebyl nalezen."
                ));

        if (!uzivatel.isAktivni()) {
            throw new UsernameNotFoundException(
                    "Uživatelský účet je deaktivovaný."
            );
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(uzivatel.getEmail())
                .password(uzivatel.getHeslo())
                .roles(
                        uzivatel.getRole()
                                .stream()
                                .map(Enum::name)
                                .toArray(String[]::new)
                )
                .disabled(!uzivatel.isAktivni())
                .build();
    }
}