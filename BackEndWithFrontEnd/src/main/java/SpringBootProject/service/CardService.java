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
	public ResponseEntity<Card> validateCard(Integer cardId, Card card) {

		Card car = cardRepository.findById(cardId).get();

		if(card.getCardHolderName().equals(car.getCardHolderName()) && card.getCardNumber()==(car.getCardNumber())
				&& card.getCvv()==(car.getCvv()) && card.getExpiryDate().equals(car.getExpiryDate())) {

			System.out.println("Card validation successful");
			System.out.println("Genrated otp after card validation -> " + otpNumber);

		} else {
			System.out.println("Bad Credentials");
		}

		return null;
	}
	

}
