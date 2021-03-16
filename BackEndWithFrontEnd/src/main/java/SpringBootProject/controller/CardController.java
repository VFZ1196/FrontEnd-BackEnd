package SpringBootProject.controller;

import java.util.List;

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

	@Autowired
	public CardRepository cardRepository;

	@Autowired
	public CardService cardService;

	// Add record
	@PostMapping("/card")
	public Card add(@RequestBody Card card) {
		return cardRepository.save(card);
	}

	// Get All record
	@GetMapping("/card")
	public List<Card> getAll() {
		return cardRepository.findAll();
	}

	// Get record By Id
	@GetMapping("/card/{cardId}")
	public Card getById(@PathVariable int cardId) {
		return cardRepository.findById(cardId).get();
	}

	// Validate otp
	@GetMapping("/validateotp/{cardId}/{number}")
	public ResponseEntity<Card> validateotp(@PathVariable int cardId, @PathVariable int number) throws Exception {
		return cardService.validateotp(cardId, number);
	}

	// Validate Card
	@PostMapping("/validatecard/{cardId}/{cardHolderName}/{accountNumber}/{cardNumber}/{cvv}/{expiryDate}")
	public ResponseEntity<Card> validateCard(@PathVariable int cardId, @PathVariable String cardHolderName,
			@PathVariable long accountNumber, @PathVariable long cardNumber,
			@PathVariable int cvv, @PathVariable String expiryDate) {
		return cardService.validateCard(cardId, cardHolderName, accountNumber, cardNumber, cvv,expiryDate);

	}
	
	@PostMapping("/datevalidation/{cardId}/{expiryDate}")
	public Card datevalidate(@PathVariable int cardId,@PathVariable String expiryDate) {
		Card card =  cardRepository.findById(cardId).get();
		System.out.println(card.getExpiryDate());
		if(expiryDate.equals(card.getExpiryDate())) {
			System.out.println("date matched");
		}else {
			System.out.println("Not Matched");
		}
		return null;
	}
  
}
