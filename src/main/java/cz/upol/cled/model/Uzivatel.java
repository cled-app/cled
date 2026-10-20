package cz.upol.cled.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

/**
 * Entita představující uživatelský účet v systému CLED.
 *
 * <p>Uživatel obsahuje základní přihlašovací a osobní údaje
 * a může mít jednu nebo více rolí. Role jsou uloženy pomocí
 * {@link ElementCollection} v samostatné databázové tabulce
 * {@code uzivatel_role}.</p>
 */
@Entity
@Table(name = "uzivatel")
public class Uzivatel {

    /**
     * Jedinečný identifikátor uživatele.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Křestní jméno uživatele.
     */
    @Column(nullable = false)
    private String jmeno;

    /**
     * Příjmení uživatele.
     */
    @Column(nullable = false)
    private String prijmeni;

    /**
     * Přihlašovací a kontaktní e-mail uživatele.
     *
     * <p>E-mail musí být v systému jedinečný.</p>
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Heslo uživatele.
     *
     * <p>Heslo bude v aplikační vrstvě ukládáno v zabezpečené
     * podobě pomocí vhodného mechanismu pro jeho hashování.</p>
     */
    @Column(nullable = false)
    private String heslo;

    /**
     * Role přiřazené uživateli.
     *
     * <p>Jeden uživatel může mít více rolí. Role jsou uloženy
     * v samostatné tabulce {@code uzivatel_role}.</p>
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
        name = "uzivatel_role",
        joinColumns = @JoinColumn(name = "uzivatel_id")
    )
    @Column(name = "role", nullable = false)
    private Set<Role> role = new HashSet<>();

    /**
     * Určuje, zda je uživatelský účet aktivní.
     */
    @Column(nullable = false)
    private boolean aktivni = true;

    /**
     * Určuje, zda se jedná o dočasný demonstrační účet.
     *
     * <p>Demonstrační účet je určen pro prezentaci bakalářského
     * projektu a může být po obhajobě odstraněn nebo deaktivován.</p>
     */
    @Column(nullable = false)
    private boolean demoUcet = false;

    /**
     * Výchozí konstruktor požadovaný JPA.
     */
    public Uzivatel() {
    }

    /**
     * Vrátí identifikátor uživatele.
     *
     * @return identifikátor uživatele
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor uživatele.
     *
     * @param id identifikátor uživatele
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Vrátí křestní jméno uživatele.
     *
     * @return křestní jméno uživatele
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Nastaví křestní jméno uživatele.
     *
     * @param jmeno křestní jméno uživatele
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Vrátí příjmení uživatele.
     *
     * @return příjmení uživatele
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Nastaví příjmení uživatele.
     *
     * @param prijmeni příjmení uživatele
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * Vrátí e-mail uživatele.
     *
     * @return e-mail uživatele
     */
    public String getEmail() {
        return email;
    }

    /**
     * Nastaví e-mail uživatele.
     *
     * @param email e-mail uživatele
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Vrátí heslo uživatele.
     *
     * @return heslo uživatele
     */
    public String getHeslo() {
        return heslo;
    }

    /**
     * Nastaví heslo uživatele.
     *
     * @param heslo heslo uživatele
     */
    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    /**
     * Vrátí role přiřazené uživateli.
     *
     * @return množina rolí uživatele
     */
    public Set<Role> getRole() {
        return role;
    }

    /**
     * Nastaví role uživatele.
     *
     * @param role množina rolí
     */
    public void setRole(Set<Role> role) {
        this.role = role;
    }

    /**
     * Vrátí informaci, zda je uživatelský účet aktivní.
     *
     * @return {@code true}, pokud je účet aktivní
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví aktivitu uživatelského účtu.
     *
     * @param aktivni {@code true}, pokud má být účet aktivní
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }

    /**
     * Vrátí informaci, zda se jedná o demonstrační účet.
     *
     * @return {@code true}, pokud je účet určen pro demonstraci
     */
    public boolean isDemoUcet() {
        return demoUcet;
    }

    /**
     * Nastaví, zda se jedná o demonstrační účet.
     *
     * @param demoUcet {@code true}, pokud je účet demonstrační
     */
    public void setDemoUcet(boolean demoUcet) {
        this.demoUcet = demoUcet;
    }
}