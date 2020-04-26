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
    private String rental_number;
    private String customer_account;
    private Date rental_date;
    private String item_number;
    private String rental_status;

    //constructors
    public Rental() {
        rental_number = "";
        customer_account = "";
        rental_date = new Date();
        item_number = "";
        rental_status = "";
    }

    public Rental(String rental_number, String customer_account, Date rental_date, String item_number, String rental_status) {
        this.rental_number = rental_number;
        this.customer_account = customer_account;
        this.rental_date = rental_date;
        this.item_number = item_number;
        this.rental_status = rental_status;
    }

    //accesors and mutators

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

    public String getItem_number() {
        return item_number;
    }

    public void setItem_number(String item_number) {
        this.item_number = item_number;
    }

    public String getRental_status() {
        return rental_status;
    }

    public void setRental_status(String rental_status) {
        this.rental_status = rental_status;
    }

}
