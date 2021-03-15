package SpringBootProject.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringBootProject.model.Card;
import SpringBootProject.repository.CardRepository;
import SpringBootProject.service.CardService;

@RestController
public class CardController {
	
	Random random = new Random();
	public static double getRandomNumber(double min, double max) {
		double r = (int)(Math.random()*(max-min+1)+min);
		return r;
	}
	
	@Autowired
	public CardRepository cardRepository;
	
	@Autowired
	public CardService cardService;
	
	
	@PostMapping("/card")
	public Card add(@RequestBody Card card) {
		return cardRepository.save(card);
	}
 	
	@GetMapping("/card")
	public List<Card> getAll() {
		return cardRepository.findAll();
	}
	
	@GetMapping("/card/{cardId}")
	public Card getById(@PathVariable int cardId ) {
		return cardRepository.findById(cardId).get();
	}
  
	@GetMapping("/cardValidation/{cardId}")
	public ResponseEntity<Card> cardValidation(@PathVariable int cardId){
		Card card = cardRepository.findById(cardId).get();
		System.out.println(card);
		return null;
	}
	
	@PostMapping("/otp")
	public ResponseEntity<Card> enterOtp(){
		
		int otpNumber = (int) getRandomNumber(1000,4000);
		System.out.println(otpNumber);
		
		return null;
		
	}
}
