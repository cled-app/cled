package cz.upol.cled.model;

import java.time.LocalDate;
import java.time.LocalTime;
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
 * Entita představující trénink sportovního klubu v systému CLED.
 *
 * <p>Trénink je přiřazen ke konkrétnímu klubu a trenérovi.
 * Zároveň může mít více záznamů o účasti sportovců.</p>
 */
@Entity
@Table(name = "trenink")
public class Trenink {

    /**
     * Jedinečný identifikátor tréninku.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Datum konání tréninku.
     */
    @Column(nullable = false)
    private LocalDate datum;

    /**
     * Čas začátku tréninku.
     */
    @Column(nullable = false)
    private LocalTime casOd;

    /**
     * Čas konce tréninku.
     */
    @Column(nullable = false)
    private LocalTime casDo;

    /**
     * Místo konání tréninku.
     */
    @Column(nullable = false)
    private String misto;

    /**
     * Popis nebo náplň tréninku.
     */
    @Column(nullable = false)
    private String popis;

    /**
     * Určuje, zda je trénink aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Klub, kterému trénink patří.
     *
     * <p>Každý trénink musí být přiřazen právě k jednomu klubu.</p>
     */
    @ManyToOne
    @JoinColumn(name = "klub_id", nullable = false)
    private Klub klub;

    /**
     * Trenér, který je k tréninku přiřazen.
     *
     * <p>Každý trénink musí mít právě jednoho trenéra.</p>
     */
    @ManyToOne
    @JoinColumn(name = "trener_id", nullable = false)
    private Trener trener;

    /**
     * Seznam záznamů o účasti sportovců na tomto tréninku.
     */
    @OneToMany(mappedBy = "trenink", cascade = CascadeType.ALL)
    private List<UcastNaTreninku> ucasti = new ArrayList<>();

    /**
     * Výchozí konstruktor požadovaný JPA.
     */
    public Trenink() {
    }

    /**
     * Vrátí identifikátor tréninku.
     *
     * @return identifikátor tréninku
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor tréninku.
     *
     * @param id identifikátor tréninku
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí datum tréninku.
     *
     * @return datum tréninku
     */
    public LocalDate getDatum() {
        return datum;
    }

    /**
     * Nastaví datum tréninku.
     *
     * @param datum datum tréninku
     */
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    /**
     * Vrátí čas začátku tréninku.
     *
     * @return čas začátku
     */
    public LocalTime getCasOd() {
        return casOd;
    }

    /**
     * Nastaví čas začátku tréninku.
     *
     * @param casOd čas začátku
     */
    public void setCasOd(LocalTime casOd) {
        this.casOd = casOd;
    }

    /**
     * Vrátí čas konce tréninku.
     *
     * @return čas konce
     */
    public LocalTime getCasDo() {
        return casDo;
    }

    /**
     * Nastaví čas konce tréninku.
     *
     * @param casDo čas konce
     */
    public void setCasDo(LocalTime casDo) {
        this.casDo = casDo;
    }

    /**
     * Vrátí místo konání tréninku.
     *
     * @return místo konání
     */
    public String getMisto() {
        return misto;
    }

    /**
     * Nastaví místo konání tréninku.
     *
     * @param misto místo konání
     */
    public void setMisto(String misto) {
        this.misto = misto;
    }

    /**
     * Vrátí popis tréninku.
     *
     * @return popis tréninku
     */
    public String getPopis() {
        return popis;
    }

    /**
     * Nastaví popis tréninku.
     *
     * @param popis popis tréninku
     */
    public void setPopis(String popis) {
        this.popis = popis;
    }

    /**
     * Vrátí informaci, zda je trénink aktivní.
     *
     * @return {@code true}, pokud je trénink aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví aktivitu tréninku.
     *
     * @param aktivni {@code true}, pokud má být trénink aktivní
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí klub, kterému trénink patří.
     *
     * @return klub tréninku
     */
    public Klub getKlub() {
        return klub;
    }

    /**
     * Nastaví klub tréninku.
     *
     * @param klub klub, kterému má být trénink přiřazen
     */
    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    /**
     * Vrátí trenéra přiřazeného k tréninku.
     *
     * @return trenér tréninku
     */
    public Trener getTrener() {
        return trener;
    }

    /**
     * Nastaví trenéra tréninku.
     *
     * @param trener trenér, který má být k tréninku přiřazen
     */
    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    /**
     * Vrátí seznam účastí na tréninku.
     *
     * @return seznam účastí
     */
    public List<UcastNaTreninku> getUcasti() {
        return ucasti;
    }

    /**
     * Nastaví seznam účastí na tréninku.
     *
     * @param ucasti seznam účastí
     */
    public void setUcasti(List<UcastNaTreninku> ucasti) {
        this.ucasti = ucasti;
    }
}
