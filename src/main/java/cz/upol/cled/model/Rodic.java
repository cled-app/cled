package cz.upol.cled.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entita představující rodiče nebo zákonného zástupce sportovce.
 *
 * Rodič může být v systému propojen s jedním nebo více sportovci.
 */
@Entity
@Table(name = "rodic")
public class Rodic {

    /**
     * Jedinečný identifikátor rodiče.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Jméno rodiče.
     */
    @Column(nullable = false)
    private String jmeno;

    /**
     * Příjmení rodiče.
     */
    @Column(nullable = false)
    private String prijmeni;

    /**
     * Kontaktní e-mail rodiče.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Určuje, zda je účet rodiče v systému aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Seznam sportovců, ke kterým je rodič přiřazen.
     */
    @OneToMany(mappedBy = "rodic", cascade = CascadeType.ALL)
    private List<Sportovec> sportovci = new ArrayList<>();

    /**
     * Vytvoří nového rodiče.
     */
    public Rodic() {
    }

    /**
     * Vrátí identifikátor rodiče.
     *
     * @return identifikátor rodiče
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor rodiče.
     *
     * @param id identifikátor rodiče
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí jméno rodiče.
     *
     * @return jméno rodiče
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Nastaví jméno rodiče.
     *
     * @param jmeno jméno rodiče
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Vrátí příjmení rodiče.
     *
     * @return příjmení rodiče
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Nastaví příjmení rodiče.
     *
     * @param prijmeni příjmení rodiče
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * Vrátí kontaktní e-mail rodiče.
     *
     * @return e-mail rodiče
     */
    public String getEmail() {
        return email;
    }

    /**
     * Nastaví kontaktní e-mail rodiče.
     *
     * @param email e-mail rodiče
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Zjistí, zda je rodič aktivní.
     *
     * @return true, pokud je rodič aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví stav aktivity rodiče.
     *
     * @param aktivni true pro aktivního rodiče
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí seznam sportovců přiřazených k rodiči.
     *
     * @return seznam sportovců
     */
    public List<Sportovec> getSportovci() {
        return sportovci;
    }

    /**
     * Nastaví seznam sportovců přiřazených k rodiči.
     *
     * @param sportovci seznam sportovců
     */
    public void setSportovci(List<Sportovec> sportovci) {
        this.sportovci = sportovci;
    }
}
