package cz.upol.cled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.upol.cled.model.Trener;

public interface TrenerRepository extends JpaRepository<Trener, Long> {
}
