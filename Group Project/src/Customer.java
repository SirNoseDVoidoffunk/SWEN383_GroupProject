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

    public void addRentedItems(ArrayList<Item> rentedItems){
        for(Item item : rentedItems){
            this.rentedItems.add(item);
        }
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

    /**
    * Rents an item and returns status of ability to be rented
    * @param itemName - name of item to be rented
    * @return success - True if item can be rented
    */
    public boolean rentItem(Store store, String itemName) {
        //should only ever return one item
        ArrayList<Item> item = store.searchForItems(itemName);
        if(item.get(0).checkOutItem(this)) {
            this.addRentedItems(item);
            return true;
        } else {
            return false;
        }
    }

    /**
    * Rents an item and returns status of ability to be rented
    * @param itemNames - ArrayList of item names of items to be rented
    * @return success - True if item can be rented
    */
    public boolean rentItems(Store store, ArrayList<String> itemNames) {
        for(String itemName : itemNames) {
            rentItem(store, itemName);
        }
    }

    /**
    * Rents an item and returns status of ability to be rented
    * @param itemName - name of item to be returned
    * @return success - True if item successfully returned
    */
    public boolean returnItem(String itemName) {
        ArrayList<Item> item = store.searchForItems(itemName);
        Item itemToRent = item.get(0);
        itemToRent.returnToStock(this);

        //checks on payment and late charges should go here
        return true;
    }

    /**
    * Rents an item and returns status of ability to be rented
    * @param itemName - name of item to be returned
    * @return success - True if item successfully returned
    */
    public boolean returnItem(ArrayList<String> itemNames) {
        for(Item itemName : itemNames){
            returnItem(itemName);
        }
        //checks on payment and late charges should go here
        return true;
    }
}
