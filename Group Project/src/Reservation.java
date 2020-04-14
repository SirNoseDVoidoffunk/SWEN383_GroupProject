/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/


import java.util.Date;

public class Reservation {
    //class attributes
    private String reservation_number;
    private String customer_account;
    private Date reservation_date;
    private String reservation_title;
    private String item_number;
    private String reservation_status;

    //constructors


    public Reservation() {
        reservation_number = "";
        customer_account = "";
        reservation_date = new Date();
        reservation_title = "";
        item_number = "";
        reservation_status = "";

    }

    public Reservation(String reservation_number, String customer_account,
                       Date reservation_date, String reservation_title, String item_number,
                       String reservation_status) {
        this.reservation_number = reservation_number;
        this.customer_account = customer_account;
        this.reservation_date = reservation_date;
        this.reservation_title = reservation_title;
        this.item_number = item_number;
        this.reservation_status = reservation_status;
    }

    //accesors and mutators

    public String getReservation_number() {
        return reservation_number;
    }

    public void setReservation_number(String reservation_number) {
        this.reservation_number = reservation_number;
    }

    public String getCustomer_account() {
        return customer_account;
    }

    public void setCustomer_account(String customer_account) {
        this.customer_account = customer_account;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public String getReservation_title() {
        return reservation_title;
    }

    public void setReservation_title(String reservation_title) {
        this.reservation_title = reservation_title;
    }

    public String getItem_number() {
        return item_number;
    }

    public void setItem_number(String item_number) {
        this.item_number = item_number;
    }

    public String getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(String reservation_status) {
        this.reservation_status = reservation_status;
    }
}
