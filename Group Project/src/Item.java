/**
 * Item class that's used as the parent class of DVD and CD and to declare shared methods for both of those classes
 * @version 4/26/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samuel Crouch
 */

import java.text.SimpleDateFormat;
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
    private double retailPeriod = 5000; // hard coded for demonstration purposes
    private Date returnDate;
    private double rentalRate;
    private String name;
    private String type;
    private int item_id;

    //constructors
    public Item() {
        available = false;
        onReserve = false;
        inStock = false;
        inventoryAmount = 0;
        customerReserving = null;
        customerRenting = null;
        reservationList = new ArrayList<Customer>();
        returnDate = null;
        name = "";
        type = "";
        item_id = -1;
        rentalRate = 19.95;
    }

    public Item(boolean available, boolean onReserve, boolean inStock, int inventoryAmount, String name, String type) {

        this.available = available;
        this.onReserve = onReserve;
        this.inStock = inStock;
        this.inventoryAmount = inventoryAmount;
        this.name = name;
        this.type = type;

        this.rentalRate = 19.95; // hard coded

        // attribute set during rental period
        this.customerReserving = null;
        this.customerRenting = null;
        this.reservationList = new ArrayList<Customer>();

        this.returnDate = null;

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

    public double getRetailPeriod() {
        return retailPeriod;
    }

    public void setRetailPeriod(double retailPeriod) {
        this.retailPeriod = retailPeriod;
    }

    public double getRentalRate() { return rentalRate; }

    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

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

    public int getItemId() {
        return item_id;
    }

    public void setItemId(int item_id) {
        this.item_id = item_id;
    }


    /**
     * Updates the necessary values in order to place an item on reserve
     * @param cust - Customer that is reserving the item
     * @return status - True if the reserve could happen successfully, false if not
     */
    public boolean placeOnReserve(Customer cust) {

        // if the item is available then reserve it
        if(available && !onReserve) {
            this.onReserve = true;
            this.customerReserving = cust;
            this.reservationList.add(cust);

            available = false;
            return true;
            // if the item is not available (not in stock) or it's reserved then add to reservation list
        } else if(!available || onReserve) {
            this.reservationList.add(cust);
            return true;
        }
        return false;
    }

    /**
     * Cancel's the reservation for a specific customer
     * @param cust - The customer that wants to cancel their reservation
     */
    public void cancelReservation(Customer cust) {
        if(!this.reservationList.isEmpty()) {
            // if the customer is at the top of the list
            if(reservationList.indexOf(cust) != -1) {
                reservationList.remove(cust);
                if(reservationList.size() == 0) {
                    available = true;
                    onReserve = false;
                }
            }
        }
    }
   
   /**
    * Increments inventoryAmount, then sets inStock to true (since there is at least one item in the inventory)
    */
    public void returnToStock() {
        if(reservationList.isEmpty()) {
            onReserve = false;
            available = true;
        } else {
            if(reservationList.size() < inventoryAmount) {
                available = true;
            }
            onReserve = true;
            customerReserving = reservationList.get(0);
        }
        customerRenting = null;
        inStock = true;
        inventoryAmount++;
        returnDate = null;
    }

    /**
     * Returns the position of where the customer is on the reservation list
     * @param cust - The customer on the reservation list
     * @return placement - Where on the list the customer is
     */
    public int getCustomerPlace(Customer cust) {
        return reservationList.indexOf(cust);
    }

    /**
     * Sets the appropriate variables to make the item as rented
     * @param cust - The customer that wishes to check out the item
     */
    public void checkOutItem(Customer cust) {
        if(reservationList.indexOf(cust) != -1) {
            reservationList.remove(cust);
            if(reservationList.size() > 0) {
                customerReserving = reservationList.get(0);
            }
        }
        returnDate = new Date();
        returnDate.setTime( returnDate.getTime() + (long)(retailPeriod));
        inventoryAmount--;
        checkOutOfInventory();
        customerRenting = cust;

        if(inventoryAmount == 0 || inventoryAmount <= reservationList.size()) {
            available = false;
        } else {
            available = true;
        }

        if(inventoryAmount == 0) {
            inStock = false;
        }
    }

    /**
     * Checks to see if the item stock is 1 and if so, transmits that there is only one left in inventory to regional
     * control computer
     */
    public void checkOutOfInventory() {
        if(inventoryAmount == 1) {
            // call to the regional control computer with store_id, item_id, and quantity
            System.out.println("Transmitted Out of Inventory");
        }
    }

    /**
     * A formatted string that returns information about the specific item
     * @return String - A formatted string that returns the information about an item
     */
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String info = "";
        info += "Title: " + this.name + "\n";
        if(available) {
            info += "Status: Available with " + inventoryAmount + " in stock";
        } else if(onReserve) {
            info += "Status: On Reserve\nCustomer: " + reservationList.get(0).getName();
        } else if(!inStock) {
            info += "Status: Rented\nCustomer: " + customerRenting.getName() +
                    "\nDue Date: " + format.format(returnDate);
        }
        return info;
    }
}
