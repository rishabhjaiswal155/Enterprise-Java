package com.app.pojos;
import javax.persistence.*;
import java.time.LocalDate;
@Embeddable
public class Card {
	@Column(name = "card_number",length = 30,unique=true)
private String cardNumber;
	@Column(name="expiry_date")
private LocalDate expiryDate;
	@Column(length=3)
private String cvv;
	@Enumerated(EnumType.STRING)
	@Column(name="card_type",length = 20)
private Type cardType;
public Card() {
	// TODO Auto-generated constructor stub
}
public Card(String cardNumber, LocalDate expiryDate, String cvv, Type cardType) {
	super();
	this.cardNumber = cardNumber;
	this.expiryDate = expiryDate;
	this.cvv = cvv;
	this.cardType = cardType;
}
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public LocalDate getExpiryDate() {
	return expiryDate;
}
public void setExpiryDate(LocalDate expiryDate) {
	this.expiryDate = expiryDate;
}
public String getCvv() {
	return cvv;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public Type getCardType() {
	return cardType;
}
public void setCardType(Type cardType) {
	this.cardType = cardType;
}
@Override
public String toString() {
	return "Card [cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + ", cvv=" + cvv + ", cardType=" + cardType
			+ "]";
}


}
