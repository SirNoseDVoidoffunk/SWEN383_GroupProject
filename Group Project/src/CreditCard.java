/**
 * CreditCard class that's used to validate credit card processes
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
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
