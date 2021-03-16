package SpringBootProject.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="card")
public class Card {
	
	Random random = new Random();

	public static double getRandomNumber(double min, double max) {
		double r = (int)(Math.random()*(max-min+1)+min);
		return r;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;
	private String cardHolderName;
	private long accountNumber;
	private float amount;
	private long cardNumber;
	private int cvv;
	private String expiryDate;
	private int otp = (int) getRandomNumber(1000,2000);

	public Card() {
		
	}

	public Card(Random random, String cardHolderName, long accountNumber, float amount, long cardNumber, int cvv,
			String expiryDate, int otp) {
		super();
		this.random = random;
		this.cardHolderName = cardHolderName;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
		this.otp = otp;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

}
