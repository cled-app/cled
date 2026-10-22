
package cz.upol.cled.dto;

import java.util.Set;

import cz.upol.cled.model.Role;

/**
 * DTO pro zobrazení uživatelského účtu v administraci.
 *
 * Neobsahuje heslo ani jeho hash.
 */
public record UzivatelPrehledDto(
        Long id,
        String jmeno,
        String prijmeni,
        String email,
        Set<Role> role,
        boolean aktivni
) {
}
