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
    public boolean setRentalPeriod(String name, double period) {
        for(Item item : this.store.getInventoryList()) {
            if(item.getName().toLowerCase().equals(name.toLowerCase())) {
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
            if(item.getName().toLowerCase().equals(name.toLowerCase())) {
                item.setRentalRate(rate);
                return true;
            }
        }
        return false;
    }

    //addItem()
    //removeItem()
    //getCustomerReport()
    //removeLateCharge()

    /**
     * Creates an inventory report
     * @return String - The name of the generated CSV file
     */
    public String createInventoryReport() {
        InventoryReport inventoryReport = new InventoryReport();
        for(Item item : this.store.getInventoryList()) { inventoryReport.addItem(item); }
        return inventoryReport.getReport();
    }

    /**
     * Creates a customer report
     * @param type - The specific report type to be created
     * @return String - The name of the generated text file
     */
    public String createCustomerReport(String type) {
        CustomerReport customerReport = new CustomerReport();
        for(Customer cust : this.store.getCustomerList()) {
            if(type.equals("all")) {
                customerReport.addCustomer(cust);
            } else if(type.equals("overdue")) {
                boolean addcust = false;
                for(Item item : cust.getRentedItems()) {
                    if(item.getReturnDate().before(new Date())) {
                        addcust = true;
                    }
                }
                if(addcust) {
                    customerReport.addCustomer(cust);
                }
            } else if(type.equals("fines")) {
                if(cust.getFinesOwed().size()>0) {
                    customerReport.addCustomer(cust);
                }
            }
        }
        return customerReport.getReport();
    }

}
