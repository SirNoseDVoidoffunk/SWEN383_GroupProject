/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
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
                        //approve()
    */
}
