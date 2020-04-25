import java.util.ArrayList;

/**
 * Manager class that's used to represent a manager and declare manager-specific methods
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

public class Manager extends Employee {

    Store store;
    Inventory inventory;

    /**
     * Default Constructor
     */
    public Manager() {

    }

    public Manager(Store store, Inventory inventory) {
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
    //addItem()
    //removeItem()
    //setRentalRate()
    //getCustomerReport()
    //removeLateCharge()
    //createInventoryReport()

}
