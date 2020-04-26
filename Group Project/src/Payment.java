/**
 * Payment class that's used to be the parent class of Cash, DebitCard, and CreditCard to declare shared methods
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

public class Payment {
    //class attributes
    private Double amount;
    private String currency;

    //constructors
    public Payment() {
        amount = 0.0;
        currency = "";
    }

    public Payment(Double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    //accesors and mutators

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /*
--------------------------------------------------------------------------------------------------------------
                        additional methods below

                        //createTransaction()
    */

    /**
     * This method is meant to be overwriten - Returns false if used because the child approve methods are
     * suppose to be used
     * @return False - Don't use this method, use the child methods of Cash, CreditCard, and DebitCard
     */
    public boolean approve() {
        return false;
    }
}
