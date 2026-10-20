package cz.upol.cled.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.upol.cled.model.Uzivatel;

public interface UzivatelRepository extends JpaRepository<Uzivatel, Long> {

    Optional<Uzivatel> findByEmail(String email);

}
