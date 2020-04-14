/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/

public class DebitCard {
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
