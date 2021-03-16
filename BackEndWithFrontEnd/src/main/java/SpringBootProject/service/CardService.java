package SpringBootProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import SpringBootProject.model.Card;
import SpringBootProject.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	public CardRepository cardRepository;

	public ResponseEntity<Card> validateotp(int cardId, Integer number) {
		Card card = cardRepository.findById(cardId).get();
		if (number.equals(card.getOtp())) {
			System.out.println("Otp Validated");
		} else {
			System.out.println("Something wrong");
		}
		return null;
	}

	public ResponseEntity<Card> validateCard(Integer cardId, String cardHolderName, Long accountNumber, Long cardNumber,
			Integer cvv, String expiryDate) {

		Card card = cardRepository.findById(cardId).get();

		if (cardHolderName.equals(card.getCardHolderName()) && accountNumber.equals(card.getAccountNumber())
				&& cardNumber.equals(card.getCardNumber()) && cvv.equals(card.getCvv())
				&& expiryDate.equals(card.getExpiryDate())) {

			System.out.println("Validated");
			
		} else {
			System.out.println("Bad Credentials");
		}

		return null;
	}

}
