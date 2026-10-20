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
 * Entita představující účast sportovce na konkrétním tréninku.
 *
 * <p>Entita propojuje trénink a sportovce a zároveň uchovává stav
 * účasti a případnou poznámku.</p>
 *
 * <p>Vztah je mezi tréninkem a sportovcem realizován pomocí této
 * vazební entity typu:</p>
 *
 * <ul>
 *     <li>Trenink 1:N UcastNaTreninku</li>
 *     <li>Sportovec 1:N UcastNaTreninku</li>
 * </ul>
 */
@Entity
@Table(name = "ucast_na_treninku")
public class UcastNaTreninku {

    /**
     * Jedinečný identifikátor záznamu účasti.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Stav účasti sportovce na tréninku.
     *
     * <p>Například může obsahovat hodnoty jako přítomen,
     * omluven nebo odhlášen.</p>
     */
    @Column(nullable = false)
    private String stav;

    /**
     * Volitelná poznámka k účasti.
     */
    @Column
    private String poznamka;

    /**
     * Trénink, ke kterému se záznam účasti vztahuje.
     */
    @ManyToOne
    @JoinColumn(name = "trenink_id", nullable = false)
    private Trenink trenink;

    /**
     * Sportovec, jehož účast je evidována.
     */
    @ManyToOne
    @JoinColumn(name = "sportovec_id", nullable = false)
    private Sportovec sportovec;

    /**
     * Výchozí konstruktor požadovaný JPA.
     */
    public UcastNaTreninku() {
    }

    /**
     * Vrátí identifikátor záznamu účasti.
     *
     * @return identifikátor účasti
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor záznamu účasti.
     *
     * @param id identifikátor účasti
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí stav účasti.
     *
     * @return stav účasti
     */
    public String getStav() {
        return stav;
    }

    /**
     * Nastaví stav účasti.
     *
     * @param stav stav účasti
     */
    public void setStav(String stav) {
        this.stav = stav;
    }

    /**
     * Vrátí poznámku k účasti.
     *
     * @return poznámka k účasti
     */
    public String getPoznamka() {
        return poznamka;
    }

    /**
     * Nastaví poznámku k účasti.
     *
     * @param poznamka poznámka k účasti
     */
    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    /**
     * Vrátí trénink, ke kterému účast patří.
     *
     * @return trénink
     */
    public Trenink getTrenink() {
        return trenink;
    }

    /**
     * Nastaví trénink, ke kterému účast patří.
     *
     * @param trenink trénink účasti
     */
    public void setTrenink(Trenink trenink) {
        this.trenink = trenink;
    }

    /**
     * Vrátí sportovce, jehož účast je evidována.
     *
     * @return sportovec
     */
    public Sportovec getSportovec() {
        return sportovec;
    }

    /**
     * Nastaví sportovce, jehož účast je evidována.
     *
     * @param sportovec sportovec účasti
     */
    public void setSportovec(Sportovec sportovec) {
        this.sportovec = sportovec;
    }
}
