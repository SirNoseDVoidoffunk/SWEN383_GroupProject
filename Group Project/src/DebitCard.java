/**
 * Debit card class that's used to validate a debit card transaction
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

public class DebitCard extends Payment {
    //class attributes
    private String carNumber;
    private String cvv;
    private String expiration;

    //constructors

    public DebitCard() {
        carNumber = "";
        cvv = "";
        expiration = "";
    }

    public DebitCard(String carNumber, String cvv, String expiration) {
        this.carNumber = carNumber;
        this.cvv = cvv;
        this.expiration = expiration;
    }

    /**
     * This method would call the bank interface and make sure the debit card information is correct, however, for the POC,
     * we are automatically returning true with the impression that in full scale development, this method will be implemented
     * @return success - True if the transaction was approve, False if not
     */
    public boolean approve() {
        return true;
    }

    //accesors and mutators

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
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
