/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
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

    public Store(Inventory inventory, String location, ArrayList<Transaction> history, ArrayList<Customer> cust_list) {
        this.inventory = inventory;
        this.location = location;
        this.history = history;
        this.cust_list = cust_list;
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

//-----------------------------------------------------------------------------------------------------------------------
    
   /**
    * Returns all Items in Inventory whose names contain a search parameter
    *
    * @param name: The parameter being searched for
    * @return: An ArrayList of matching results
    */
    public ArrayList<Item> searchForItems(String name) {
        ArrayList<Item> matches = new ArrayList<Item>();
        for (Item item : this.inventory.getItems()) {
            if(item.getName().toLowerCase().contains(name.toLowerCase)) {
                matches.add(item);
            }
        }
        return matches;
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
