package SpringBootProject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="card")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;
	private String cardHolderName;
	private long accountNumber;
	private float amount;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "card_details", 
				joinColumns = @JoinColumn(name = "card_id"), 
				inverseJoinColumns = @JoinColumn(name = "details_id"))
	private Set<CardDetails> details = new HashSet<>();

	public Card() {
		
	}

	public Card(String cardHolderName, long accountNumber, float amount, Set<CardDetails> details) {
		super();
		this.cardHolderName = cardHolderName;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.details = details;
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

	public Set<CardDetails> getDetails() {
		return details;
	}

	public void setDetails(Set<CardDetails> details) {
		this.details = details;
	}
	
	
}
