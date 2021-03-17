package SpringBootProject.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import SpringBootProject.model.Card;
import SpringBootProject.repository.CardRepository;

@Service
public class CardService {

	Random random = new Random();

	public static double getRandomNumber(double min, double max) {
		double r = (int) (Math.random() * (max - min + 1) + min);
		return r;
	}

	private int otpNumber = (int) getRandomNumber(1000, 2000);

	@Autowired
	public CardRepository cardRepository;

	// OTP validation
	public ResponseEntity<Card> validateotp(int cardId, Integer number) {
		Card card = cardRepository.findById(cardId).get();
		if (number.equals(card.getOtp())) {
			System.out.println("Otp Validated");
		} else {
			System.out.println("Something wrong");
		}
		return null;
	}
 
	// Card Validation
	public ResponseEntity<Card> validateCard(Integer cardId, String cardHolderName, Long cardNumber, Integer cvv,
			String expiryDate) {

		Card card = cardRepository.findById(cardId).get();

		if (cardHolderName.equals(card.getCardHolderName()) && cardNumber.equals(card.getCardNumber())
				&& cvv.equals(card.getCvv()) && expiryDate.equals(card.getExpiryDate())) {
			

			System.out.println("Card validation successful");
			System.out.println("Genrated otp after card validation -> " + otpNumber);

		} else {
			System.out.println("Bad Credentials");
		}

		return null;
	}

}
