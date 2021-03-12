package SpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	

}
