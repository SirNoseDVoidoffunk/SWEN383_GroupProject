/**
 * Reservation class that's used to keep track of the reservation process as a transaction and log itself to the interface computer
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */


import java.util.Date;

public class Reservation extends Transaction {
    //class attributes
    private int reservation_number;
    private Customer customer_account;
    private Date reservation_date;
    private String reservation_title;
    private int item_number;
    private String reservation_status;

    //constructors


    public Reservation() {
        super();
        reservation_number = 0;
        customer_account = null;
        reservation_date = new Date();
        reservation_title = "";
        item_number = -1;
        reservation_status = "";

    }

    public Reservation(int reservation_number, Customer customer_account,
                       String reservation_title, int item_number,
                       String reservation_status) {
        super();
        this.reservation_number = reservation_number;
        this.customer_account = customer_account;
        this.reservation_date = new Date();
        this.reservation_title = reservation_title;
        this.item_number = item_number;
        this.reservation_status = reservation_status;
    }

    //accesors and mutators

    public int getReservation_number() {
        return reservation_number;
    }

    public void setReservation_number(int reservation_number) {
        this.reservation_number = reservation_number;
    }

    public Customer getCustomer_account() {
        return customer_account;
    }

    public void setCustomer_account(Customer customer_account) {
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

    public int getItem_number() {
        return item_number;
    }

    public void setItem_number(int item_number) {
        this.item_number = item_number;
    }

    public String getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(String reservation_status) {
        this.reservation_status = reservation_status;
    }
}
