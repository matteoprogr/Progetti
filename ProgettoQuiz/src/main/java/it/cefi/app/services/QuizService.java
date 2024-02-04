package it.cefi.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.app.depositories.DomandaRepository1;
import it.cefi.app.depositories.RisposteRepository1;
import it.cefi.app.models.Domande;
import it.cefi.app.models.Risposte;


@Service
public class QuizService {
	
	@Autowired
	private DomandaRepository1 domandaRepository;
	
	@Autowired
	private RisposteRepository1 risposteRepository;
	
	public void SaveQuestion(Domande domanda) {

		domandaRepository.save(domanda);
		
	}
	
	public void SaveAnswer(Risposte risposta) {
		
		risposteRepository.save(risposta);
	}
public void SaveAllAnswer(List<Risposte> risposta) {
		
		risposteRepository.saveAll(risposta);
	}
	
	public List<Domande> getQuestions(){
		
		return domandaRepository.findAll();
	}
	
	public List<Risposte> getAnswers(int i){
		return risposteRepository.findById(i).stream().toList();
	}
	public List<Risposte> getAllAnswers(){
		return risposteRepository.findAll();
	}
	
	public void deleteR(int i) {
		risposteRepository.deleteById(i);
	}
	public void delete(int i) {
		domandaRepository.deleteById(i);
	}
	public void UpdateQuestion(int i,String text) {

		Optional<Domande> mod=domandaRepository.findById(i);
		Domande domanda=mod.get();
		domanda.setTesto(text);
		domandaRepository.save(domanda);
		
	}
	public void UpdateAnswer(int v,String[] text,Boolean[] bool) {
		List<Risposte> risposte=risposteRepository.findAll();
		List<Integer> idRisp=new ArrayList<>();
			for(var c:risposte) {
				if(c.getDomanda().getIdDomanda()==v) {
			idRisp.add(c.getIdRisposte());
				}
		}
			
			for(int i=0;i<idRisp.size();i++) {
			Optional<Risposte> mod=risposteRepository.findById(idRisp.get(i));
			Risposte risposta= mod.get(); 
			risposta.setRisposta(text[i]);
			risposta.setSpunta(bool[i]);
			risposteRepository.save(risposta);
			}
			
	}

}
