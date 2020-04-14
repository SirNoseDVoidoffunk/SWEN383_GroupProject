/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/

public class CreditCard {
    //class attributes
    private String cardNumber;
    private String cvv;
    private String expiration;

    //constructors

    public CreditCard() {
        cardNumber = "";
        cvv = "";
        expiration = "";
    }

    public CreditCard(String cardNumber, String cvv, String expiration) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiration = expiration;
    }

    //accesors and mutators

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
