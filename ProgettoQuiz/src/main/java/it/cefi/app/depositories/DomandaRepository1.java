package it.cefi.app.depositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cefi.app.models.Domande;

//interfaccia che estende JpaRepository, un interfaccia che permette all'accesso ai dati e operazioni CRUD
//Per l'accesso alle domande nel database
@Repository
public interface DomandaRepository1 extends JpaRepository<Domande, Integer> {

}
