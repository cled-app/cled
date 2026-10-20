package cz.upol.cled.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.upol.cled.model.Uzivatel;
import cz.upol.cled.service.UzivatelService;

@RestController
@RequestMapping("/api/uzivatele")
public class UzivatelController {

    private final UzivatelService uzivatelService;

    public UzivatelController(UzivatelService uzivatelService) {
        this.uzivatelService = uzivatelService;
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Uzivatel> najdiPodleEmailu(@PathVariable String email) {
        Optional<Uzivatel> uzivatel = uzivatelService.najdiPodleEmailu(email);

        return uzivatel
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Uzivatel uloz(@RequestBody Uzivatel uzivatel) {
        return uzivatelService.uloz(uzivatel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> smaz(@PathVariable Long id) {
        uzivatelService.smaz(id);
        return ResponseEntity.noContent().build();
    }
}
