package cz.upol.cled.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.upol.cled.dto.UzivatelPrehledDto;
import cz.upol.cled.service.UzivatelService;

@RestController
@RequestMapping("/api/uzivatele")
@PreAuthorize("hasRole('ADMIN')")
public class UzivatelController {

    private final UzivatelService uzivatelService;

    public UzivatelController(UzivatelService uzivatelService) {
        this.uzivatelService = uzivatelService;
    }

    /**
     * Vrátí seznam uživatelských účtů pro administraci.
     *
     * @return seznam uživatelů bez hesel
     */
    @GetMapping
    public ResponseEntity<List<UzivatelPrehledDto>> najdiVsechny() {
        return ResponseEntity.ok(
                uzivatelService.najdiVsechnyProAdministraci()
        );
    }
}
