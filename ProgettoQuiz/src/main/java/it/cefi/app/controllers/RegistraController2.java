package it.cefi.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.app.models.Dati;
import it.cefi.app.models.Domande;
import it.cefi.app.models.Risposte;
import it.cefi.app.services.QuizService;
//RestController per la registrazione di una nuova domanda con le sue risposte
	
	@RestController
	public class RegistraController2{
		@Autowired
		QuizService quizService;
		
		@PostMapping("/dom")
		public void registraD(@RequestBody Dati quiz) {
			
			List<Risposte> risposte=new ArrayList<>();
			
			Domande domanda = new Domande(0,"");
			
					 domanda.setIdDomanda(0);
					 domanda.setTesto(quiz.getDomanda());
					
			quizService.SaveQuestion(domanda);
					
				
				risposte.add(new Risposte(0,quiz.getR1(),quiz.getI1(),domanda));
				risposte.add(new Risposte(0,quiz.getR2(),quiz.getI2(),domanda));
				risposte.add(new Risposte(0,quiz.getR3(),quiz.getI3(),domanda));
				risposte.add(new Risposte(0,quiz.getR4(),quiz.getI4(),domanda));
				
			quizService.SaveAllAnswer(risposte);
			
		}
	}

