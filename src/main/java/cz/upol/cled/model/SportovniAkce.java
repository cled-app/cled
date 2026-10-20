package cz.upol.cled.model;

import java.time.LocalDate;
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
 * Entita představující sportovní akci v systému CLED.
 *
 * Sportovní akcí může být například závod, turnaj nebo jiná
 * sportovní událost, na kterou se mohou sportovci přihlašovat.
 */
@Entity
@Table(name = "sportovni_akce")
public class SportovniAkce {

    /**
     * Jedinečný identifikátor sportovní akce.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Název sportovní akce.
     */
    @Column(nullable = false)
    private String nazev;

    /**
     * Datum konání sportovní akce.
     */
    @Column(nullable = false)
    private LocalDate datum;

    /**
     * Místo konání sportovní akce.
     */
    @Column(nullable = false)
    private String misto;

    /**
     * Určuje, zda je sportovní akce v systému aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Seznam přihlášení sportovců na tuto sportovní akci.
     */
    @OneToMany(mappedBy = "sportovniAkce", cascade = CascadeType.ALL)
    private List<PrihlaseniNaAkci> prihlaseni = new ArrayList<>();

    /**
     * Vytvoří novou sportovní akci.
     */
    public SportovniAkce() {
    }

    /**
     * Vrátí identifikátor sportovní akce.
     *
     * @return identifikátor sportovní akce
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor sportovní akce.
     *
     * @param id identifikátor sportovní akce
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí název sportovní akce.
     *
     * @return název akce
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Nastaví název sportovní akce.
     *
     * @param nazev název akce
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Vrátí datum konání sportovní akce.
     *
     * @return datum konání
     */
    public LocalDate getDatum() {
        return datum;
    }

    /**
     * Nastaví datum konání sportovní akce.
     *
     * @param datum datum konání
     */
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    /**
     * Vrátí místo konání sportovní akce.
     *
     * @return místo konání
     */
    public String getMisto() {
        return misto;
    }

    /**
     * Nastaví místo konání sportovní akce.
     *
     * @param misto místo konání
     */
    public void setMisto(String misto) {
        this.misto = misto;
    }

    /**
     * Zjistí, zda je sportovní akce aktivní.
     *
     * @return true, pokud je akce aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví stav aktivity sportovní akce.
     *
     * @param aktivni true pro aktivní akci
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí seznam přihlášení na sportovní akci.
     *
     * @return seznam přihlášení
     */
    public List<PrihlaseniNaAkci> getPrihlaseni() {
        return prihlaseni;
    }

    /**
     * Nastaví seznam přihlášení na sportovní akci.
     *
     * @param prihlaseni seznam přihlášení
     */
    public void setPrihlaseni(List<PrihlaseniNaAkci> prihlaseni) {
        this.prihlaseni = prihlaseni;
    }
}
