package cz.upol.cled.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entita představující přihlášení sportovce na sportovní akci.
 *
 * Přihlášení propojuje konkrétního sportovce s konkrétní sportovní akcí
 * a uchovává stav jeho přihlášení.
 */
@Entity
@Table(name = "prihlaseni_na_akci")
public class PrihlaseniNaAkci {

    /**
     * Jedinečný identifikátor přihlášení.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Stav přihlášení sportovce na akci.
     *
     * Například přihlášen, odhlášen nebo omluven.
     */
    @Column(nullable = false)
    private String stav;

    /**
     * Určuje, zda je přihlášení aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Sportovec, kterého se přihlášení týká.
     */
    @ManyToOne
    @JoinColumn(name = "sportovec_id", nullable = false)
    private Sportovec sportovec;

    /**
     * Sportovní akce, na kterou je sportovec přihlášen.
     */
    @ManyToOne
    @JoinColumn(name = "sportovni_akce_id", nullable = false)
    private SportovniAkce sportovniAkce;

    /**
     * Vytvoří nové přihlášení na sportovní akci.
     */
    public PrihlaseniNaAkci() {
    }

    /**
     * Vrátí identifikátor přihlášení.
     *
     * @return identifikátor přihlášení
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor přihlášení.
     *
     * @param id identifikátor přihlášení
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí stav přihlášení.
     *
     * @return stav přihlášení
     */
    public String getStav() {
        return stav;
    }

    /**
     * Nastaví stav přihlášení.
     *
     * @param stav nový stav přihlášení
     */
    public void setStav(String stav) {
        this.stav = stav;
    }

    /**
     * Zjistí, zda je přihlášení aktivní.
     *
     * @return true, pokud je přihlášení aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví stav aktivity přihlášení.
     *
     * @param aktivni true pro aktivní přihlášení
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí sportovce, kterého se přihlášení týká.
     *
     * @return sportovec
     */
    public Sportovec getSportovec() {
        return sportovec;
    }

    /**
     * Nastaví sportovce, kterého se přihlášení týká.
     *
     * @param sportovec sportovec
     */
    public void setSportovec(Sportovec sportovec) {
        this.sportovec = sportovec;
    }

    /**
     * Vrátí sportovní akci, na kterou je sportovec přihlášen.
     *
     * @return sportovní akce
     */
    public SportovniAkce getSportovniAkce() {
        return sportovniAkce;
    }

    /**
     * Nastaví sportovní akci, na kterou je sportovec přihlášen.
     *
     * @param sportovniAkce sportovní akce
     */
    public void setSportovniAkce(SportovniAkce sportovniAkce) {
        this.sportovniAkce = sportovniAkce;
    }
}
