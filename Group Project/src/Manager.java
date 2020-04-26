import java.util.ArrayList;
import java.util.Date;

/**
 * Manager class that's used to represent a manager and declare manager-specific methods
 * @version 4/26/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samuel Crouch
 */

public class Manager extends Employee {

    Store store;
    Inventory inventory;

    /**
     * Default Constructor
     */
    public Manager() {
        super();
    }

    public Manager(Store store, Inventory inventory) {
        super();
        this.store = store;
        this.inventory = inventory;
    }

    public Manager(Store store, Inventory inventory, int id, String name, String home_address, String mobile_phone,
                   String home_phone, String email_address, String creditCardInfo, String password) {

        super(id, name, home_address, mobile_phone, home_phone, email_address, password);
        this.store = store;
        this.inventory = inventory;
    }

    /**
     * Deletes a customer's account
     * @param cust - The customer account to be deleted
     * @return success - True if the customer was successfully deleted
     */
    public boolean deleteCustomer(Customer cust) {
        ArrayList<Customer> cust_list = this.store.getCust_list();

        if(cust_list.indexOf(cust) == -1) {
            return false;
        } else {
            cust_list.remove(cust);
            return true;
        }
    }

    /**
     * Sets an item's retail period
     * @param name - The name of the item to be updated
     * @param period - The new retail period
     * @return success - True if the retail period was successfully updated
     */
    public boolean setRetailPeriod(String name, Date period) {
        for(Item item : this.store.getInventoryList()) {
            if(item.getName().equals(name)) {
                item.setRetailPeriod(period);
                return true;
            }
        }
        return false;
    }

    /**
     * Sets an item's retail rate
     * @param name - The name of the item to be updated
     * @param rate - The new retail rate
     * @return success - True if the retail period was successfully updated
     */
    public boolean setRetailRate(String name, double rate) {
        for(Item item : this.store.getInventoryList()) {
            if(item.getName().equals(name)) {
                item.setRetailRate(rate);
                return true;
            }
        }
        return false;
    }

    //addItem()
    //removeItem()
    //getCustomerReport()
    //removeLateCharge()
    //createInventoryReport()

}
