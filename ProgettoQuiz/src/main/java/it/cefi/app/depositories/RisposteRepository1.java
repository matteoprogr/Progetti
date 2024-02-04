package it.cefi.app.depositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cefi.app.models.Risposte;


// interfaccia che estende JpaRepository, un interfaccia che permette all'accesso ai dati e operazioni CRUD
// Per l'accesso alle risposte nel database
@Repository
public interface RisposteRepository1 extends JpaRepository<Risposte, Integer>  {

}
