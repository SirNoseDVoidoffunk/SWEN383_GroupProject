/**
 * Item class that's used as the parent class of DVD and CD and to declare shared methods for both of those classes
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
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
        retailPeriod = null;
        returnDate = null;
        name = "";
        type = "";
        item_id = -1;
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
            if(reservationList.indexOf(cust) == 0) {
                reservationList.remove(cust);
                if(reservationList.size() == 0) {
                    available = true;
                    onReserve = false;
                }
            // if the customer is only on the reservation list
            } else {
                reservationList.remove(cust);
            }
        }
    }

    /*
-------------------------------------------------------------------------------------------------------------------
                additional methods below

                //placeOnHold()
                //returnToStock()
                //checkOutItem()
                //checkStatus()
                //setRetailRate()
                //setRetailPeriod()
    */
}
