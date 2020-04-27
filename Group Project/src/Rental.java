/**
 * Rental class that's used to keep track of the rental process as a transaction and log itself to the interface computer
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */
import java.util.Date;

public class Rental extends Transaction {
    //class attributes
    private double rental_number;
    private double customer_account;
    private Date rental_date;
    private double item_number;
    private String rental_status;
    private int store_id;

    //constructors
    public Rental() {
        rental_number = -1;
        customer_account = -1;
        rental_date = new Date();
        item_number = -1;
        rental_status = "";
    }

    public Rental(double rental_number, double customer_account, Date rental_date, double item_number, String rental_status, int store_id) {
        this.rental_number = rental_number;
        this.customer_account = customer_account;
        this.rental_date = rental_date;
        this.item_number = item_number;
        this.rental_status = rental_status;
        this.store_id = store_id;
    }

    //accesors and mutators

    public double getRental_number() {
        return rental_number;
    }

    public void setRental_number(double rental_number) {
        this.rental_number = rental_number;
    }

    public double getCustomer_account() {
        return customer_account;
    }

    public void setCustomer_account(double customer_account) {
        this.customer_account = customer_account;
    }

    public Date getRental_date() {
        return rental_date;
    }

    public void setRental_date(Date rental_date) {
        this.rental_date = rental_date;
    }

    public double getItem_number() {
        return item_number;
    }

    public void setItem_number(double item_number) {
        this.item_number = item_number;
    }

    public String getRental_status() {
        return rental_status;
    }

    public void setRental_status(String rental_status) {
        this.rental_status = rental_status;
    }

    /**
     * Logs the transaction to the regional control computer
     * @return status - True if the transaction was able to be logged into the regional control computers
     */
    public boolean logTransaction() {
        // this is where we would connect to the regional control computer and log the transaction
        // For the POC, we are only return true in assumption this action gets carried out when in full development
        // all of the variables such as store_id, customer_id, item_id, bought date, and return date are stored above
        // as class variables
        return true;
    }

}
