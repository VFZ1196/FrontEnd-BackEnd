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
	private long accountNumber;
	private float amount;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "card_details", 
				joinColumns = @JoinColumn(name = "card_id"), 
				inverseJoinColumns = @JoinColumn(name = "details_id"))
	private Set<CardDetails> details = new HashSet<>();

	public Card() {
		
	}
	public Card(long accountNumber, float amount, Set<CardDetails> details) {
		super();
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
