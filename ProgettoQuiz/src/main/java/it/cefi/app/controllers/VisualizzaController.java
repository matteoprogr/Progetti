package it.cefi.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.app.models.Domande;
import it.cefi.app.models.Quiz;
import it.cefi.app.models.Risposte;
import it.cefi.app.services.QuizService;
// Controller e restController per la visualizzazione delle doomande e per scegliere la risposta
@Controller
@RequestMapping("/v")
public class VisualizzaController {
	
	@Autowired
	QuizService quizService;
	
	int d=0;
	int r=0;
	int corrette=0;
	int p=1;
	int reset=0;
	int count=0;
	
	
	
	// metodo che visualizza la pagina html e resetta tutte le variabili globali
	@GetMapping
	public String v() {
		d=0;
		r=0;
		corrette=0;
		p=1;
		reset=0;
		count=0;
		return "visualizza";
		
	}
	
	@RestController
	public class VisualizzaController1{
		
		
		// metodo che carica le domande dal database alla pagina web
		@GetMapping("/load")
	    public ResponseEntity<Quiz> carica() {
			
			List<Domande> domande=quizService.getQuestions();
	        List<Risposte> lista=quizService.getAllAnswers();
	        
	        Quiz quiz=new Quiz(domande.get(d).getTesto(),lista.get(r++).getRisposta(),lista.get(r++).getRisposta(),
	        		lista.get(r++).getRisposta(),lista.get(r++).getRisposta());
	        System.out.println(d +" "+r);
	        
	        d++;
	        if(d==domande.size()) {
	        	d=0;
	        	r=0;
	        }
	        
	        
	        return ResponseEntity.ok(quiz);
			
	    }
		
			// metodo per la catturare la scelta dell'user e verifica se è corretta 
			
			@PostMapping("/scelta")
			public int[] scelta(@RequestBody Map<String,Boolean> scelta) {
				
				List<Domande> dm =quizService.getQuestions();
				List<Risposte> rm= quizService.getAllAnswers();
				int rs=dm.size();
				
				List<Risposte> lista=new ArrayList<>();
				if(count>-1) {
					p=dm.get(count).getIdDomanda();
				
					for(int w=0;w<rm.size();w++) {
						if(rm.get(w).getDomanda().getIdDomanda()==p) {
							lista.add(rm.get(w));
						}
					}
				}
				
				int i=0;
				int j=0;
				for(var v:scelta.entrySet()) {
					if(i>0) {
						
						if(lista.get(j).getSpunta()==true && v.getValue()==true) {
							corrette++;
							
						}
						j++;
					}
					i=1;
					
				}
				count++;
			    reset++;
				
				p = reset==rs ? 1 : p;
				
				
				int [] h=new int[3];
				h[0]=corrette;
				h[1]=rs;
				h[2]=reset;
				
				return h;
			}
			
			// metodo che restituisce il risultato del quiz 
			@GetMapping("/ris")
			public int[] risultato() {
				int[] g=new int[2];
				g[0]=corrette;
				g[1]=reset;
				
				return g;
			}
		
	}

}

















