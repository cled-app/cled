package cz.upol.cled.model;

/**
 * Role uživatele v systému CLED.
 *
 * Role určuje oprávnění a rozsah přístupu uživatele
 * k jednotlivým částem systému.
 */
public enum Role {

    /**
     * Hlavní administrátor systému.
     */
    ADMIN,

    /**
     * Uživatel zastupující sportovní svaz.
     */
    SVAZ,

    /**
     * Uživatel zastupující krajský svaz.
     */
    KRAJSKY_SVAZ,

    /**
     * Uživatel zastupující sportovní klub.
     */
    KLUB,

    /**
     * Trenér sportovního klubu.
     */
    TRENER,

    /**
     * Sportovec registrovaný v klubu.
     */
    SPORTOVEC,

    /**
     * Rodič nebo zákonný zástupce sportovce.
     */
    RODIC
}