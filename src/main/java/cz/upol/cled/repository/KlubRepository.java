package cz.upol.cled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.upol.cled.model.Klub;

public interface KlubRepository extends JpaRepository<Klub, Long> {
}
