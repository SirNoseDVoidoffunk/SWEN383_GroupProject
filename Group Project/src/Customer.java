/**
 * Customer class that's used to allow the customer many different methods such as buying and reserving items
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

import java.util.ArrayList;
import java.util.Date;

public class Customer extends Person {
    //class attributes
    private String customer_account_status;
    private Double accountBalance;
    private ArrayList<Charge> finesOwed;
    private String creditCardNumber;
    private String creditCardExp;
    private String creditCardInfo;
    private ArrayList<Item> rentedItems;
    private ArrayList<Item> reservedItems;

    private final double STANDARD_LATE_FEE_PERCENT = 3; // 300% for demonstration purposes - usually .03

    //constructors

    public Customer() {
        customer_account_status = "";
        accountBalance = 0.0;
        creditCardNumber = "";
        creditCardExp = "";
        finesOwed = new ArrayList<Charge>();
        rentedItems = new ArrayList<Item>();
        reservedItems = new ArrayList<Item>();
    }

    public Customer(int id, String name, String home_address, String mobile_phone, String home_phone, String email_address,
                    String creditCardInfo, String password) {

        super(id, name, home_address, mobile_phone, home_phone, email_address, password);
        this.creditCardInfo = creditCardInfo;

        customer_account_status = "";
        accountBalance = 0.0;
        creditCardNumber = "";
        creditCardExp = "";
        finesOwed = new ArrayList<Charge>();
        rentedItems = new ArrayList<Item>();
        reservedItems = new ArrayList<Item>();
    }

    public Customer(String customer_account_status, Double accountBalance, ArrayList<Charge> finesOwed,
                    String creditCardNumber, String creditCardExp, ArrayList<Item> rentedItems,
                    ArrayList<Item> reservedItems) {
        this.customer_account_status = customer_account_status;
        this.accountBalance = accountBalance;
        this.finesOwed = finesOwed;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExp = creditCardExp;
        this.rentedItems = rentedItems;
        this.reservedItems = reservedItems;
    }

    //accesors and mutators

    public String getCustomer_account_status() {
        return customer_account_status;
    }

    public void setCustomer_account_status(String customer_account_status) {
        this.customer_account_status = customer_account_status;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public ArrayList<Charge> getFinesOwed() {
        return finesOwed;
    }

    public void setFinesOwed(ArrayList<Charge> finesOwed) {
        this.finesOwed = finesOwed;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardExp() {
        return creditCardExp;
    }

    public void setCreditCardExp(String creditCardExp) {
        this.creditCardExp = creditCardExp;
    }

    public ArrayList<Item> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(ArrayList<Item> rentedItems) {
        this.rentedItems = rentedItems;
    }

    public ArrayList<Item> getReservedItems() {
        return reservedItems;
    }

    public void setReservedItems(ArrayList<Item> reservedItems) {
        this.reservedItems = reservedItems;
    }

    /**
     * Reserves an item and returns the status of the reservation
     * @param item - the item to be reserved
     * @return success - True if the item could successfully be reserved, false if not
     */
    public boolean reserveItem(Item item) {
        if(item.placeOnReserve(this)) {
            this.reservedItems.add(item);
            int transaction_num = (int)(Math.random() * 10000000);
            Reservation reservation = new Reservation(transaction_num, this, item.getName(), item.getItemId(), "reserved");
            boolean status = reservation.logTransaction();
            reservation = null; // delete of the reservation object
            return status;
        } else {
            return false;
        }
    }

    public boolean cancelReservation(Item item) {
        reservedItems.remove(item);
        item.cancelReservation(this);

        int transaction_num = (int)(Math.random() * 10000000);
        Reservation reservation = new Reservation(transaction_num, this, item.getName(), item.getItemId(), "cancel");
        boolean status = reservation.logTransaction();
        reservation = null; // delete of the reservation object
        return status;
    }

    /**
     * Returns an item to inventory and checks to see if the item is late and applies a late charge if need be
     * @param item - Item returned
     * @return charge applied - returns true if there was a late charge, false if not
     */
    public boolean returnItem(Item item) {
        boolean late_fee_applied = false;
        Date now = new Date();
        if(now.after(item.getReturnDate())) {
            addLateCharge(item);
            late_fee_applied = true;
        }

        item.returnToStock();
        rentedItems.remove(item);

        return late_fee_applied;
    }

    /**
     * Adds a standard fee to the customer account
     * @param late_item - The item that was returned late
     */
    public void addLateCharge(Item late_item) {
        // create a new charge object and add it to the customer class
        finesOwed.add(new Charge(new Payment(STANDARD_LATE_FEE_PERCENT * late_item.getRentailRate(), "USD"), late_item.getReturnDate(), new Date(), late_item));
        accountBalance += STANDARD_LATE_FEE_PERCENT * late_item.getRentailRate();
    }

    /**
     * Rents an item and updates the corresponding variables and processes the payment
     * @param item
     */
    public boolean rentItem(Item item, boolean includeFees, String method, int store_id){
        boolean payment_successful = false;
        double amount = 0;
        if(includeFees) {
            amount = item.getRentailRate() + accountBalance;
        } else {
            amount = item.getRentailRate();
        }

        if(method.equals("cash")) {
            Cash cash = new Cash();
            payment_successful = cash.approve(amount, amount, "USD");

        } else if(method.equals("creditcard")) {
            CreditCard card = new CreditCard();
            payment_successful = card.approve(amount, amount, "USD");

        } else if(method.equals("debitcard")) {
            DebitCard card = new DebitCard();
            payment_successful = card.approve(amount, amount, "USD");
        }

        if(payment_successful) {
            int rental_id = (int) (Math.random() * 10000000);

            // Business Requirement 8/8.1
            Rental rental = new Rental(rental_id, this.getId(), new Date(), item.getItemId(), "rent", store_id);
            rental.logTransaction();
            item.checkOutItem(this);

            rentedItems.add(item);

            if(reservedItems.indexOf(item) != -1) {
                reservedItems.remove(item);
            }

            return true;

        }

        return false;
    }

    /**
     * Compiles a list of fees in a formatted string and returns it
     * @return string - The formatted string of charges
     */
    public String showInquiry() {
        String fees = "";
        for(Charge fee : this.finesOwed) {
            fees += fee.toString() + "\n";
        }
        return fees;
    }

    /**
     * Allows the customer to pay all of the balance of their fees
     * @param method - method of paying
     * @param amount - amount to pay
     * @param currency - the currency of the transaction
     * @return success - if the payment is successfully, returns true, otherwise, returns false
     */
    public boolean payFees(String method, double amount, String currency) {

        if(method.equals("cash")) {
            Cash cash = new Cash(amount, accountBalance, currency);
            if(cash.approve(accountBalance, amount, currency)){
                finesOwed.clear();
                accountBalance = 0.0;
                return true;
            }

        } else if(method.equals("creditcard")) {
            CreditCard card = new CreditCard();
            if(card.approve(accountBalance, amount, currency)){
                finesOwed.clear();
                accountBalance = 0.0;
                return true;
            }

        } else if(method.equals("debitcard")) {
            DebitCard card = new DebitCard();
            if(card.approve(accountBalance, amount, currency)){
                finesOwed.clear();
                accountBalance = 0.0;
                return true;
            }
        }

        return false;
    }

    /*
---------------------------------------------------------------------------------------------------------------
                    Additional methods below
                    //reserveItem()
                    //cancelReservation()
                    //rentItem()
                    //returnItem()
                    //addLateCharge()
                    //showInquiry()
                    //pay()
                    //removeLateCharge()
    */
}
