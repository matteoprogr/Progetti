package it.cefi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cefi.app.models.Domande;

@Repository
public interface DomandaRepository extends JpaRepository<Domande, Integer> {

}
