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
 * Entita představující sportovní klub v systému CLED.
 *
 * Klub je zařazen pod krajský svaz a může mít více trenérů,
 * sportovců a tréninků.
 */
@Entity
@Table(name = "klub")
public class Klub {

    /**
     * Jedinečný identifikátor klubu.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Název sportovního klubu.
     */
    @Column(nullable = false)
    private String nazev;

    /**
     * Kontaktní e-mail klubu.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Určuje, zda je klub v systému aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Krajský svaz, pod který klub spadá.
     */
    @ManyToOne
    @JoinColumn(name = "krajsky_svaz_id", nullable = false)
    private KrajskySvaz krajskySvaz;

    /**
     * Seznam trenérů působících v klubu.
     */
    @OneToMany(mappedBy = "klub", cascade = CascadeType.ALL)
    private List<Trener> treneri = new ArrayList<>();

    /**
     * Seznam sportovců registrovaných v klubu.
     */
    @OneToMany(mappedBy = "klub", cascade = CascadeType.ALL)
    private List<Sportovec> sportovci = new ArrayList<>();

    /**
     * Seznam tréninků pořádaných klubem.
     */
    @OneToMany(mappedBy = "klub", cascade = CascadeType.ALL)
    private List<Trenink> treninky = new ArrayList<>();

    /**
     * Vytvoří nový klub.
     */
    public Klub() {
    }

    /**
     * Vrátí identifikátor klubu.
     *
     * @return identifikátor klubu
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor klubu.
     *
     * @param id identifikátor klubu
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí název klubu.
     *
     * @return název klubu
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Nastaví název klubu.
     *
     * @param nazev název klubu
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Vrátí kontaktní e-mail klubu.
     *
     * @return e-mail klubu
     */
    public String getEmail() {
        return email;
    }

    /**
     * Nastaví kontaktní e-mail klubu.
     *
     * @param email e-mail klubu
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Zjistí, zda je klub aktivní.
     *
     * @return true, pokud je klub aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví stav aktivity klubu.
     *
     * @param aktivni true pro aktivní klub
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí krajský svaz, pod který klub patří.
     *
     * @return krajský svaz
     */
    public KrajskySvaz getKrajskySvaz() {
        return krajskySvaz;
    }

    /**
     * Nastaví krajský svaz, pod který klub patří.
     *
     * @param krajskySvaz krajský svaz
     */
    public void setKrajskySvaz(KrajskySvaz krajskySvaz) {
        this.krajskySvaz = krajskySvaz;
    }

    /**
     * Vrátí seznam trenérů klubu.
     *
     * @return seznam trenérů
     */
    public List<Trener> getTreneri() {
        return treneri;
    }

    /**
     * Nastaví seznam trenérů klubu.
     *
     * @param treneri seznam trenérů
     */
    public void setTreneri(List<Trener> treneri) {
        this.treneri = treneri;
    }

    /**
     * Vrátí seznam sportovců klubu.
     *
     * @return seznam sportovců
     */
    public List<Sportovec> getSportovci() {
        return sportovci;
    }

    /**
     * Nastaví seznam sportovců klubu.
     *
     * @param sportovci seznam sportovců
     */
    public void setSportovci(List<Sportovec> sportovci) {
        this.sportovci = sportovci;
    }

    /**
     * Vrátí seznam tréninků klubu.
     *
     * @return seznam tréninků
     */
    public List<Trenink> getTreninky() {
        return treninky;
    }

    /**
     * Nastaví seznam tréninků klubu.
     *
     * @param treninky seznam tréninků
     */
    public void setTreninky(List<Trenink> treninky) {
        this.treninky = treninky;
    }
}
