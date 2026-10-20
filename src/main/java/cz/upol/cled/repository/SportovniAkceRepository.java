package cz.upol.cled.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.upol.cled.model.SportovniAkce;

public interface SportovniAkceRepository extends JpaRepository<SportovniAkce, Long> {
}