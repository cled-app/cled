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
 * Entita představující trenéra sportovního klubu v systému CLED.
 *
 * <p>Každý trenér patří právě do jednoho klubu.
 * Vztah mezi klubem a trenérem je typu 1:N.</p>
 */
@Entity
@Table(name = "trener")
public class Trener {

    /**
     * Jedinečný identifikátor trenéra.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Křestní jméno trenéra.
     */
    @Column(nullable = false)
    private String jmeno;

    /**
     * Příjmení trenéra.
     */
    @Column(nullable = false)
    private String prijmeni;

    /**
     * Kontaktní e-mail trenéra.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Určuje, zda je trenér aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Klub, do kterého trenér patří.
     *
     * <p>Každý trenér musí být přiřazen právě k jednomu klubu.</p>
     */
    @ManyToOne
    @JoinColumn(name = "klub_id", nullable = false)
    private Klub klub;

    /**
     * Výchozí konstruktor požadovaný JPA.
     */
    public Trener() {
    }

    /**
     * Vrátí identifikátor trenéra.
     *
     * @return identifikátor trenéra
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor trenéra.
     *
     * @param id identifikátor trenéra
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí křestní jméno trenéra.
     *
     * @return křestní jméno trenéra
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Nastaví křestní jméno trenéra.
     *
     * @param jmeno křestní jméno trenéra
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Vrátí příjmení trenéra.
     *
     * @return příjmení trenéra
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Nastaví příjmení trenéra.
     *
     * @param prijmeni příjmení trenéra
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * Vrátí kontaktní e-mail trenéra.
     *
     * @return e-mail trenéra
     */
    public String getEmail() {
        return email;
    }

    /**
     * Nastaví kontaktní e-mail trenéra.
     *
     * @param email e-mail trenéra
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Vrátí informaci, zda je trenér aktivní.
     *
     * @return {@code true}, pokud je trenér aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví aktivitu trenéra.
     *
     * @param aktivni {@code true}, pokud má být trenér aktivní
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí klub, do kterého trenér patří.
     *
     * @return klub trenéra
     */
    public Klub getKlub() {
        return klub;
    }

    /**
     * Nastaví klub trenéra.
     *
     * @param klub klub, do kterého má být trenér přiřazen
     */
    public void setKlub(Klub klub) {
        this.klub = klub;
    }
}
