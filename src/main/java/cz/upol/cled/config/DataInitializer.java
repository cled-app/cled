
package cz.upol.cled.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.upol.cled.model.Role;
import cz.upol.cled.model.Uzivatel;
import cz.upol.cled.repository.UzivatelRepository;
import cz.upol.cled.service.UzivatelService;

/**
 * Inicializace základních údajů aplikace CLED.
 *
 * <p>Při prvním spuštění vytvoří administrátorský účet,
 * pokud v databázi ještě neexistuje.</p>
 */
@Configuration
public class DataInitializer {

    /**
     * Vytvoří výchozího administrátora systému CLED.
     *
     * <p>Pokud účet s daným e-mailem již existuje,
     * nebude vytvořen znovu.</p>
     *
     * @param uzivatelRepository repository uživatelů
     * @param uzivatelService služba pro uložení uživatele
     * @return inicializační běh při spuštění aplikace
     */
    @Bean
    public CommandLineRunner inicializaceAdmina(
            UzivatelRepository uzivatelRepository,
            UzivatelService uzivatelService) {

        return args -> {

            String email = "admin@cled-app.cz";

            if (uzivatelRepository.findByEmail(email).isEmpty()) {

                String heslo = System.getenv("ADMIN_PASSWORD");

                if (heslo == null || heslo.isBlank()) {
                    throw new IllegalStateException(
                            "Chybi promenna prostredi ADMIN_PASSWORD."
                    );
                }

                Uzivatel admin = new Uzivatel();

                admin.setJmeno("Admin");
                admin.setPrijmeni("CLED");
                admin.setEmail(email);
                admin.setHeslo(heslo);
                admin.setRole(Set.of(Role.ADMIN));
                admin.setAktivni(true);
                admin.setDemoUcet(true);

                uzivatelService.uloz(admin);

                System.out.println(
                        "Výchozí administrátor CLED byl vytvořen: "
                                + email
                );
            }
        };
    }
}
