package cz.upol.cled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hlavní třída aplikace CLED.
 *
 * <p>Spouští Spring Boot aplikaci a inicializuje aplikační kontext
 * včetně jednotlivých komponent, konfigurace a dalších částí aplikace.</p>
 */
@SpringBootApplication
public class CledApplication {

    /**
     * Vstupní bod aplikace.
     *
     * @param args argumenty předané při spuštění aplikace
     */
    public static void main(String[] args) {
        SpringApplication.run(CledApplication.class, args);
    }
}
