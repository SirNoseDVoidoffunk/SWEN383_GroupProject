/**
 * Inventory class that's used to hold all of the items in the store
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

import java.util.ArrayList;

public class Inventory {
    //class attributes
    private ArrayList<Item> items;

    /**
     * Default constructor
     */
    public Inventory() {
        items = new ArrayList<Item>();
    }

    /**
     * Parameterized constructor
     * @param items
     */
    public Inventory(ArrayList<Item> items) {
        this.items = items;
    }

    //accesors and mutators

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Checks to see if the inventory is empty or not
     * @return status - True if the inventory is empty, false if not
     */
    public boolean checkOutOfInventory() {
        if(items.isEmpty()) { return true;} else {return false;}
    }

    /**
     * Adds the following items in to the inventory
     * @param items - Items to be added to the inventory
     */
    public void addItems(ArrayList<Item> items) {
        getItems().addAll(items);
    }

    /**
     * Removes a item from the inventory
     * @param item - Item to be removed from the inventory
     */
    public boolean removeItem(Item item) {

        if(this.items.indexOf(item) == -1) {
            return false;
        } else {
            this.items.remove(item);
            return true;
        }
    }
}
