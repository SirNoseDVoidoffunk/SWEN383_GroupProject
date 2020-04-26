/**
 * Store class that's used to keep track of the inventory, customer, employee, and payment classes
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

import java.util.ArrayList;

public class Store {
    //class attributes
    private Inventory inventory;
    private String location;
    private ArrayList<Transaction> history;
    private ArrayList<Customer> cust_list;

    //constructors
    public Store() {
        inventory = new Inventory();
        location = "";
        history = new ArrayList<Transaction>();
        cust_list = new ArrayList<Customer>();
    }

    public Store(Inventory inventory, String location) {
        this.inventory = inventory;
        this.location = location;
        this.history = new ArrayList<>();
        this.cust_list = new ArrayList<>();
    }

    //accesors and mutators

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Transaction> history) {
        this.history = history;
    }

    public ArrayList<Customer> getCust_list() {
        return cust_list;
    }

    public void setCust_list(ArrayList<Customer> cust_list) {
        this.cust_list = cust_list;
    }
    /*
-----------------------------------------------------------------------------------------------------------------------
                        additional methods below
                        //getInventoryList()
    */

    /**
     * Given a search inquiry, filters and finds the list of titles start with that sequence of letters and returns it
     * @param search - Search string
     * @return items - The list of item that contains the search string
     */
    public ArrayList<Item> searchForItems(String search) {
        ArrayList<Item> matches = new ArrayList<Item>();
        for (Item item : this.inventory.getItems()) {
            if(item.getName().toLowerCase().contains(search.toLowerCase())) {
                matches.add(item);
            }
        }
        return matches;
    }

    /**
     * Returns the customer list of the store
     * @return customer list - the list of customers
     */
    public ArrayList<Customer> getCustomerList() {
        return this.cust_list;
    }

    public void addCustomerToList(Customer cust) {
        if(cust_list.indexOf(cust) == -1) {
            cust_list.add(cust);
        }
    }
    
   /**
    * Retrieves the ArrayList of Items from Inventory
    *
    * @return: The contents of the Inventory's Items attribute
    */
    public ArrayList<Item> getInventoryList() {
        return this.inventory.getItems();
    }
}
