package it.cefi.app.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Classe per la mappatura dell'entità Domande e creazione della tabella nel database
@Entity
@Table(name="domande")
public class Domande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDomanda;
	
	@Column(length = 50, nullable = false)
	private String testo; 
	
	@JsonIgnore
    @OneToMany(mappedBy = "domanda" )
    private List<Risposte> risposte = new ArrayList<>();

    
    
	public Domande() {
	}

	public Domande(int idDomanda, String testo) {
		this.idDomanda = idDomanda;
		this.testo = testo;
	}

	public int getIdDomanda() {
		return idDomanda;
	}

	public String getTesto() {
		return testo;
	}

	public List<Risposte> getRisposte() {
		return risposte;
	}

	public void setIdDomanda(int idDomanda) {
		this.idDomanda = idDomanda;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public void setRisposte(List<Risposte> risposte) {
		this.risposte = risposte;
	}

}
