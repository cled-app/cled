package cz.upol.cled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.upol.cled.model.Rodic;

public interface RodicRepository extends JpaRepository<Rodic, Long> {
}
