package SpringBootProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class CardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="details_id")
	private int detailsId;

	private long cardNumber;
	private int cvv;

	private String expiryDate;

	public CardDetails() {
		
	}
	
	public CardDetails(long cardNumber, int cvv, String expiryDate) {
		super();
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
	}

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
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

}
