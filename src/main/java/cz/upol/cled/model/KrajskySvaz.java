package cz.upol.cled.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entita představující krajský svaz v systému CLED.
 *
 * Krajský svaz je součástí svazu a sdružuje jednotlivé sportovní kluby
 * působící v daném kraji.
 */
@Entity
@Table(name = "krajsky_svaz")
public class KrajskySvaz {

    /**
     * Jedinečný identifikátor krajského svazu.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Název krajského svazu.
     */
    @Column(nullable = false)
    private String nazev;

    /**
     * Kontaktní e-mail krajského svazu.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Určuje, zda je krajský svaz v systému aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Svaz, pod který krajský svaz patří.
     */
    @ManyToOne
    @JoinColumn(name = "svaz_id", nullable = false)
    private Svaz svaz;

    /**
     * Seznam klubů patřících pod krajský svaz.
     */
    @OneToMany(mappedBy = "krajskySvaz", cascade = CascadeType.ALL)
    private List<Klub> kluby = new ArrayList<>();

    /**
     * Vytvoří nový krajský svaz.
     */
    public KrajskySvaz() {
    }

    /**
     * Vrátí identifikátor krajského svazu.
     *
     * @return identifikátor krajského svazu
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor krajského svazu.
     *
     * @param id identifikátor krajského svazu
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí název krajského svazu.
     *
     * @return název krajského svazu
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Nastaví název krajského svazu.
     *
     * @param nazev název krajského svazu
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Vrátí kontaktní e-mail krajského svazu.
     *
     * @return e-mail krajského svazu
     */
    public String getEmail() {
        return email;
    }

    /**
     * Nastaví kontaktní e-mail krajského svazu.
     *
     * @param email e-mail krajského svazu
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Zjistí, zda je krajský svaz aktivní.
     *
     * @return true, pokud je krajský svaz aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví stav aktivity krajského svazu.
     *
     * @param aktivni true pro aktivní krajský svaz
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí svaz, pod který krajský svaz patří.
     *
     * @return svaz
     */
    public Svaz getSvaz() {
        return svaz;
    }

    /**
     * Nastaví svaz, pod který krajský svaz patří.
     *
     * @param svaz svaz
     */
    public void setSvaz(Svaz svaz) {
        this.svaz = svaz;
    }

    /**
     * Vrátí seznam klubů krajského svazu.
     *
     * @return seznam klubů
     */
    public List<Klub> getKluby() {
        return kluby;
    }

    /**
     * Nastaví seznam klubů krajského svazu.
     *
     * @param kluby seznam klubů
     */
    public void setKluby(List<Klub> kluby) {
        this.kluby = kluby;
    }
}