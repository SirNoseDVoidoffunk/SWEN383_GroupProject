/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/

import java.util.ArrayList;
import java.util.Date;

public class Item {
    //class attributes
    private boolean available;
    private boolean onReserve;
    private boolean inStock;
    private int inventoryAmount;
    private Customer customerReserving;
    private Customer customerRenting;
    private ArrayList<Customer> reservationList;
    private Date retailPeriod;
    private Date returnDate;
    private String name;
    private String type;

    //constructors
    public Item() {
        available = false;
        onReserve = false;
        inStock = false;
        inventoryAmount = 0;
        customerReserving = new Customer();
        customerRenting = new Customer();
        reservationList = new ArrayList<Customer>();
        retailPeriod = new Date();
        returnDate = new Date();
        name = "";
        type = "";
    }

    public Item(boolean available, boolean onReserve, boolean inStock,
                int inventoryAmount, Customer customerReserving, Customer customerRenting,
                ArrayList<Customer> reservationList, Date retailPeriod, Date returnDate,
                String name, String type) {
        this.available = available;
        this.onReserve = onReserve;
        this.inStock = inStock;
        this.inventoryAmount = inventoryAmount;
        this.customerReserving = customerReserving;
        this.customerRenting = customerRenting;
        this.reservationList = reservationList;
        this.retailPeriod = retailPeriod;
        this.returnDate = returnDate;
        this.name = name;
        this.type = type;
    }

    //accesors and mutators

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isOnReserve() {
        return onReserve;
    }

    public void setOnReserve(boolean onReserve) {
        this.onReserve = onReserve;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(int inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public Customer getCustomerReserving() {
        return customerReserving;
    }

    public void setCustomerReserving(Customer customerReserving) {
        this.customerReserving = customerReserving;
    }

    public Customer getCustomerRenting() {
        return customerRenting;
    }

    public void setCustomerRenting(Customer customerRenting) {
        this.customerRenting = customerRenting;
    }

    public ArrayList<Customer> getReservationList() {
        return reservationList;
    }

    public void setReservationList(ArrayList<Customer> reservationList) {
        this.reservationList = reservationList;
    }

    public Date getRetailPeriod() {
        return retailPeriod;
    }

    public void setRetailPeriod(Date retailPeriod) {
        this.retailPeriod = retailPeriod;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*
-------------------------------------------------------------------------------------------------------------------
                additional methods below

                //placeOnHold() How does this differentiate from placeOnReserve?
                //cancelReservation() Should this pass a customer?
    */
    
    /*  Added to improve ArrayList functionality for the Inventory class. Since each item has an inventory amount, it is assumed that
        there should not be multiple objects with the same name and type (with the second attribute only being included in case there
        is a DVD and CD with the same name). Let me know if you think otherwise. ~Sam */
    @Override
    public boolean equals(Object o){
        if(o instanceof Item){
            Item i = (Item) o;
            return (this.name.equals(i.getName()) && this.type.equals(i.getType()));
        } else {
            return false;
        }
    }
    
   /**
    * Places a reservation for a customer. If a reservation has already been made, the customer is added to reservationList
    *
    * @param cust: the customer making a reservation
    */
    public void placeOnReserve(Customer cust) {
        if(this.onReserve) {
            this.reservationList.add(cust);
        } else {
            this.customerReserving = cust;
        }
    }
   
   /**
    * Increments inventoryAmount, then sets inStock to true (since there is at least one item in the inventory)
    */
    public void returnToStock() {
        this.inventoryAmount++;
        this.inStock = true;
    }
    
   /**
    * Checks out an item. Assumes that this method can't be called if an item isn't in stock or is already rented.
    *
    * @param cust: the customer checking out this item
    */
    public void checkOutItem(Customer cust) {
        this.inventoryAmount--;
        this.customerRenting = cust;
    }
        
    
    public String checkStatus() {
        if(this.available) {
            return "Available";
        } else if(this.onReserve) {
            return "On Reserve";
        } else if(!(this.inStock)) {
            return "Not in Stock";
        } else {
            return "";
        }
}
