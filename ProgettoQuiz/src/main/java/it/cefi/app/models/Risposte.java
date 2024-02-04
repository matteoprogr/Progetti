package it.cefi.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Classe per la mappatura dell'entità Risposte e creazione della tabella nel database
@Entity
@Table(name="risposte")
public class Risposte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRisposte;
	
	@Column(length = 50, nullable = false)
	private String risposta; 
	
	@Column
	private Boolean spunta; 
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idDomanda")
	private Domande domanda;
	
	
	

	public Boolean getSpunta() {
		return spunta;
	}

	public void setSpunta(Boolean spunta) {
		this.spunta = spunta;
	}

	public Risposte() {	}

	public Risposte(int idRisposte, String risposta,Boolean spunta, Domande domanda) {
		this.idRisposte = idRisposte;
		this.risposta = risposta;
		this.spunta = spunta;
		this.domanda = domanda;
	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}


	public int getIdRisposte() {
		return idRisposte;
	}

	public void setIdRisposte(int idRisposte) {
		this.idRisposte = idRisposte;
	}


	public Domande getDomanda() {
		return domanda;
	}

	public void setDomanda(Domande domanda) {
		this.domanda = domanda;
	}
	
	
	

}
