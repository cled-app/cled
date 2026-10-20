package cz.upol.cled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.upol.cled.model.Sportovec;

public interface SportovecRepository extends JpaRepository<Sportovec, Long> {
}
