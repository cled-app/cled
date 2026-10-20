package cz.upol.cled.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
 * Entita představující sportovce registrovaného ve sportovním klubu.
 *
 * Sportovec je přiřazen ke klubu a může mít přiřazeného rodiče nebo
 * zákonného zástupce. Systém u něj eviduje zdravotní prohlídky,
 * účast na trénincích a přihlášení na sportovní akce.
 */
@Entity
@Table(name = "sportovec")
public class Sportovec {

    /**
     * Jedinečný identifikátor sportovce.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Jméno sportovce.
     */
    @Column(nullable = false)
    private String jmeno;

    /**
     * Příjmení sportovce.
     */
    @Column(nullable = false)
    private String prijmeni;

    /**
     * Rodné číslo sportovce.
     */
    @Column(nullable = false, unique = true)
    private String rodneCislo;

    /**
     * Státní příslušnost sportovce.
     */
    @Column(nullable = false)
    private String statniPrislusnost;

    /**
     * Datum narození sportovce.
     */
    @Column(nullable = false)
    private LocalDate datumNarozeni;

    /**
     * Určuje, zda je sportovec v systému aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Určuje, zda byl udělen souhlas se zpracováním osobních údajů.
     */
    @Column(nullable = false)
    private boolean gdprSouhlas = false;

    /**
     * Datum a čas udělení souhlasu se zpracováním osobních údajů.
     */
    private LocalDateTime gdprSouhlasDatum;

    /**
     * Klub, ve kterém je sportovec registrován.
     */
    @ManyToOne
    @JoinColumn(name = "klub_id", nullable = false)
    private Klub klub;

    /**
     * Rodič nebo zákonný zástupce sportovce.
     */
    @ManyToOne
    @JoinColumn(name = "rodic_id")
    private Rodic rodic;

    /**
     * Seznam zdravotních prohlídek sportovce.
     */
    @OneToMany(mappedBy = "sportovec", cascade = CascadeType.ALL)
    private List<ZdravotniProhlidka> zdravotniProhlidky = new ArrayList<>();

    /**
     * Seznam účastí sportovce na trénincích.
     */
    @OneToMany(mappedBy = "sportovec", cascade = CascadeType.ALL)
    private List<UcastNaTreninku> ucastiNaTreninku = new ArrayList<>();

    /**
     * Seznam přihlášení sportovce na sportovní akce.
     */
    @OneToMany(mappedBy = "sportovec", cascade = CascadeType.ALL)
    private List<PrihlaseniNaAkci> prihlaseniNaAkce = new ArrayList<>();

    /**
     * Vytvoří nového sportovce.
     */
    public Sportovec() {
    }

    /**
     * Vrátí identifikátor sportovce.
     *
     * @return identifikátor sportovce
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor sportovce.
     *
     * @param id identifikátor sportovce
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí jméno sportovce.
     *
     * @return jméno sportovce
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Nastaví jméno sportovce.
     *
     * @param jmeno jméno sportovce
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Vrátí příjmení sportovce.
     *
     * @return příjmení sportovce
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Nastaví příjmení sportovce.
     *
     * @param prijmeni příjmení sportovce
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * Vrátí rodné číslo sportovce.
     *
     * @return rodné číslo
     */
    public String getRodneCislo() {
        return rodneCislo;
    }

    /**
     * Nastaví rodné číslo sportovce.
     *
     * @param rodneCislo rodné číslo sportovce
     */
    public void setRodneCislo(String rodneCislo) {
        this.rodneCislo = rodneCislo;
    }

    /**
     * Vrátí státní příslušnost sportovce.
     *
     * @return státní příslušnost
     */
    public String getStatniPrislusnost() {
        return statniPrislusnost;
    }

    /**
     * Nastaví státní příslušnost sportovce.
     *
     * @param statniPrislusnost státní příslušnost sportovce
     */
    public void setStatniPrislusnost(String statniPrislusnost) {
        this.statniPrislusnost = statniPrislusnost;
    }

    /**
     * Vrátí datum narození sportovce.
     *
     * @return datum narození
     */
    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    /**
     * Nastaví datum narození sportovce.
     *
     * @param datumNarozeni datum narození sportovce
     */
    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    /**
     * Zjistí, zda je sportovec aktivní.
     *
     * @return true, pokud je sportovec aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví stav aktivity sportovce.
     *
     * @param aktivni true pro aktivního sportovce
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Zjistí, zda sportovec udělil souhlas se zpracováním osobních údajů.
     *
     * @return true, pokud byl souhlas udělen
     */
    public boolean isGdprSouhlas() {
        return gdprSouhlas;
    }

    /**
     * Nastaví souhlas se zpracováním osobních údajů.
     *
     * @param gdprSouhlas true, pokud byl souhlas udělen
     */
    public void setGdprSouhlas(boolean gdprSouhlas) {
        this.gdprSouhlas = gdprSouhlas;
    }

    /**
     * Vrátí datum a čas udělení souhlasu se zpracováním osobních údajů.
     *
     * @return datum a čas souhlasu
     */
    public LocalDateTime getGdprSouhlasDatum() {
        return gdprSouhlasDatum;
    }

    /**
     * Nastaví datum a čas udělení souhlasu.
     *
     * @param gdprSouhlasDatum datum a čas souhlasu
     */
    public void setGdprSouhlasDatum(LocalDateTime gdprSouhlasDatum) {
        this.gdprSouhlasDatum = gdprSouhlasDatum;
    }

    /**
     * Vrátí klub, ve kterém je sportovec registrován.
     *
     * @return klub sportovce
     */
    public Klub getKlub() {
        return klub;
    }

    /**
     * Nastaví klub sportovce.
     *
     * @param klub klub sportovce
     */
    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    /**
     * Vrátí rodiče nebo zákonného zástupce sportovce.
     *
     * @return rodič sportovce
     */
    public Rodic getRodic() {
        return rodic;
    }

    /**
     * Nastaví rodiče nebo zákonného zástupce sportovce.
     *
     * @param rodic rodič sportovce
     */
    public void setRodic(Rodic rodic) {
        this.rodic = rodic;
    }

    /**
     * Vrátí seznam zdravotních prohlídek sportovce.
     *
     * @return seznam zdravotních prohlídek
     */
    public List<ZdravotniProhlidka> getZdravotniProhlidky() {
        return zdravotniProhlidky;
    }

    /**
     * Nastaví seznam zdravotních prohlídek.
     *
     * @param zdravotniProhlidky seznam zdravotních prohlídek
     */
    public void setZdravotniProhlidky(
            List<ZdravotniProhlidka> zdravotniProhlidky) {
        this.zdravotniProhlidky = zdravotniProhlidky;
    }

    /**
     * Vrátí seznam účastí sportovce na trénincích.
     *
     * @return seznam účastí
     */
    public List<UcastNaTreninku> getUcastiNaTreninku() {
        return ucastiNaTreninku;
    }

    /**
     * Nastaví seznam účastí sportovce na trénincích.
     *
     * @param ucastiNaTreninku seznam účastí
     */
    public void setUcastiNaTreninku(
            List<UcastNaTreninku> ucastiNaTreninku) {
        this.ucastiNaTreninku = ucastiNaTreninku;
    }

    /**
     * Vrátí seznam přihlášení sportovce na sportovní akce.
     *
     * @return seznam přihlášení
     */
    public List<PrihlaseniNaAkci> getPrihlaseniNaAkce() {
        return prihlaseniNaAkce;
    }

    /**
     * Nastaví seznam přihlášení sportovce na sportovní akce.
     *
     * @param prihlaseniNaAkce seznam přihlášení
     */
    public void setPrihlaseniNaAkce(
            List<PrihlaseniNaAkci> prihlaseniNaAkce) {
        this.prihlaseniNaAkce = prihlaseniNaAkce;
    }
}