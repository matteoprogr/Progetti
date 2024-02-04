package it.cefi.app.controllers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.app.models.Dati;
import it.cefi.app.models.Domande;

import it.cefi.app.models.Risposte;
import it.cefi.app.services.QuizService;


// RestController per modifca e cancellazione di una domanda
@RestController
@RequestMapping("/k")
public class Amministratore{
	
	@Autowired
	QuizService quizService;
	private static String domMod="";
	

// metodo per la visualizzazione delle domande prensenti nel database 
	@GetMapping("/md")
	public List<Domande> load(){
		
		List<Domande> lista=quizService.getQuestions();
		
		return lista;
	}
	
	// metodo che cattura la domanda scelta per essere modificata o cancellata
	
	@PostMapping("/scelta")
	public void modifica(@RequestBody Map<String, Boolean> testo) {
		
		for(var v: testo.entrySet()) {
			if(v.getValue()==true) {
				domMod=v.getKey();
			}
		}
		}
		
	
	// metodo che modifica la domanda o le risposte della domanda selezionata
	@PostMapping("/restDom")
	public void registraD(@RequestBody Dati quiz) {
		
		String domanda= quiz.getDomanda();
		int idDom=0;
		List<Domande> d=quizService.getQuestions();
		for(var v:d) {
			if(domMod.equals(v.getTesto())) {
				idDom=v.getIdDomanda();
			}
		}
		String [] risposte= {quiz.getR1(),quiz.getR2(),quiz.getR3(),quiz.getR4()};
		Boolean [] spunta= {quiz.getI1(),quiz.getI2(),quiz.getI3(),quiz.getI4()};
		
		

		quizService.UpdateQuestion(idDom,domanda);
		quizService.UpdateAnswer(idDom,risposte,spunta);
		
		
	}

	// metodo per la cancellazione della domanda con le sue risposte
	@PostMapping("/cancella")
	public void Canc(@RequestBody Map<String, Boolean> testo) {
		
		for(var v: testo.entrySet()) {
			if(v.getValue()==true) {
				domMod=v.getKey();
			}
			
		}
		
		List<Domande> d=quizService.getQuestions();
		List<Risposte> r=quizService.getAllAnswers();
		int dom=0;
		for(var v :d) {
			if(domMod.equals(v.getTesto())) {
				dom=v.getIdDomanda();
			}
		}
		int idR=0;
		for(var v:r) {
			if(v.getDomanda().getIdDomanda()==dom) {
				idR=v.getIdRisposte();
				quizService.deleteR(idR);
			}
		}
		
		quizService.delete(dom);
	}
	
}