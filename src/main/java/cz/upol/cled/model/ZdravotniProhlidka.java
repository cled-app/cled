package cz.upol.cled.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entita představující zdravotní prohlídku sportovce v systému CLED.
 *
 * <p>Každá zdravotní prohlídka je přiřazena právě jednomu sportovci.
 * Jeden sportovec může mít více zdravotních prohlídek.</p>
 */
@Entity
@Table(name = "zdravotni_prohlidka")
public class ZdravotniProhlidka {

    /**
     * Jedinečný identifikátor zdravotní prohlídky.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Datum provedení zdravotní prohlídky.
     */
    @Column(nullable = false)
    private LocalDate datum;

    /**
     * Datum, do kterého je zdravotní prohlídka platná.
     */
    @Column(nullable = false)
    private LocalDate platnostDo;

    /**
     * Určuje, zda je zdravotní prohlídka aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Sportovec, kterému zdravotní prohlídka patří.
     */
    @ManyToOne
    @JoinColumn(name = "sportovec_id", nullable = false)
    private Sportovec sportovec;

    /**
     * Výchozí konstruktor požadovaný JPA.
     */
    public ZdravotniProhlidka() {
    }

    /**
     * Vrátí identifikátor zdravotní prohlídky.
     *
     * @return identifikátor zdravotní prohlídky
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor zdravotní prohlídky.
     *
     * @param id identifikátor zdravotní prohlídky
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí datum zdravotní prohlídky.
     *
     * @return datum prohlídky
     */
    public LocalDate getDatum() {
        return datum;
    }

    /**
     * Nastaví datum zdravotní prohlídky.
     *
     * @param datum datum prohlídky
     */
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    /**
     * Vrátí datum konce platnosti zdravotní prohlídky.
     *
     * @return datum konce platnosti
     */
    public LocalDate getPlatnostDo() {
        return platnostDo;
    }

    /**
     * Nastaví datum konce platnosti zdravotní prohlídky.
     *
     * @param platnostDo datum konce platnosti
     */
    public void setPlatnostDo(LocalDate platnostDo) {
        this.platnostDo = platnostDo;
    }

    /**
     * Vrátí informaci, zda je zdravotní prohlídka aktivní.
     *
     * @return {@code true}, pokud je prohlídka aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví aktivitu zdravotní prohlídky.
     *
     * @param aktivni {@code true}, pokud má být prohlídka aktivní
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí sportovce, kterému zdravotní prohlídka patří.
     *
     * @return sportovec
     */
    public Sportovec getSportovec() {
        return sportovec;
    }

    /**
     * Nastaví sportovce, kterému zdravotní prohlídka patří.
     *
     * @param sportovec sportovec zdravotní prohlídky
     */
    public void setSportovec(Sportovec sportovec) {
        this.sportovec = sportovec;
    }
}
