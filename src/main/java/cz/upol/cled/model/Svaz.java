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
 * Entita představující sportovní svaz v systému CLED.
 *
 * <p>Svaz může zastřešovat jeden nebo více krajských svazů.
 * Vztah mezi svazem a krajskými svazy je typu 1:N.</p>
 */
@Entity
@Table(name = "svaz")
public class Svaz {

    /**
     * Jedinečný identifikátor svazu.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Název svazu.
     */
    @Column(nullable = false)
    private String nazev;

    /**
     * Kontaktní e-mail svazu.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Určuje, zda je svaz aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Seznam krajských svazů, které spadají pod tento svaz.
     */
    @OneToMany(mappedBy = "svaz", cascade = CascadeType.ALL)
    private List<KrajskySvaz> krajskeSvazy = new ArrayList<>();

    /**
     * Výchozí konstruktor požadovaný JPA.
     */
    public Svaz() {
    }

    /**
     * Vrátí identifikátor svazu.
     *
     * @return identifikátor svazu
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor svazu.
     *
     * @param id identifikátor svazu
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí název svazu.
     *
     * @return název svazu
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Nastaví název svazu.
     *
     * @param nazev název svazu
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Vrátí kontaktní e-mail svazu.
     *
     * @return e-mail svazu
     */
    public String getEmail() {
        return email;
    }

    /**
     * Nastaví kontaktní e-mail svazu.
     *
     * @param email e-mail svazu
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Vrátí informaci, zda je svaz aktivní.
     *
     * @return {@code true}, pokud je svaz aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví aktivitu svazu.
     *
     * @param aktivni {@code true}, pokud má být svaz aktivní
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí seznam krajských svazů patřících pod tento svaz.
     *
     * @return seznam krajských svazů
     */
    public List<KrajskySvaz> getKrajskeSvazy() {
        return krajskeSvazy;
    }

    /**
     * Nastaví seznam krajských svazů.
     *
     * @param krajskeSvazy seznam krajských svazů
     */
    public void setKrajskeSvazy(List<KrajskySvaz> krajskeSvazy) {
        this.krajskeSvazy = krajskeSvazy;
    }
}