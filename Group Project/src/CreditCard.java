/**
 * CreditCard class that's used to validate credit card processes
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

public class CreditCard extends Payment {
    //class attributes
    private String cardNumber;
    private String cvv;
    private String expiration;

    //constructors

    public CreditCard() {
        super();
        cardNumber = "";
        cvv = "";
        expiration = "";
    }

    public CreditCard(String cardNumber, String cvv, String expiration) {
        super();
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiration = expiration;
    }

    /**
     * This method would call the interface and make sure the credit card information is correct, however, for the POC,
     * we are only checking the amount suffices with the impression that in full scale development, this method will be
     * implemented properly and completely
     * @return success - True if the transaction was approve, False if not
     */
    @Override
    public boolean approve(double amountDue, double amountIssued, String currency) {
        if(amountDue <= amountIssued){
            return true;
        } else {
            return false;
        }
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
