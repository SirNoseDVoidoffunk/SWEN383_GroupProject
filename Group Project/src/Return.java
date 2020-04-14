/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/

import java.util.Date;

public class Return {
    //class attributes
    private String return_number;
    private String rental_number;
    private String customer_account;
    private Date rental_date;
    private Date rental_due;
    private Date date_returned;
    private String item_number;

    //constructors
    public Return() {
        return_number = "";
        rental_number = "";
        customer_account = "";
        rental_date = new Date();
        rental_due = new Date();
        date_returned = new Date();
        item_number = "";
    }

    public Return(String return_number, String rental_number, String customer_account,
                  Date rental_date, Date rental_due, Date date_returned, String item_number) {
        this.return_number = return_number;
        this.rental_number = rental_number;
        this.customer_account = customer_account;
        this.rental_date = rental_date;
        this.rental_due = rental_due;
        this.date_returned = date_returned;
        this.item_number = item_number;
    }

    //accesors and mutators

    public String getReturn_number() {
        return return_number;
    }

    public void setReturn_number(String return_number) {
        this.return_number = return_number;
    }

    public String getRental_number() {
        return rental_number;
    }

    public void setRental_number(String rental_number) {
        this.rental_number = rental_number;
    }

    public String getCustomer_account() {
        return customer_account;
    }

    public void setCustomer_account(String customer_account) {
        this.customer_account = customer_account;
    }

    public Date getRental_date() {
        return rental_date;
    }

    public void setRental_date(Date rental_date) {
        this.rental_date = rental_date;
    }

    public Date getRental_due() {
        return rental_due;
    }

    public void setRental_due(Date rental_due) {
        this.rental_due = rental_due;
    }

    public Date getDate_returned() {
        return date_returned;
    }

    public void setDate_returned(Date date_returned) {
        this.date_returned = date_returned;
    }

    public String getItem_number() {
        return item_number;
    }

    public void setItem_number(String item_number) {
        this.item_number = item_number;
    }

    /*
-----------------------------------------------------------------------------------------------------------------
                additional methods below

                //addLateCharge()

    */
}
