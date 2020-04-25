/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/

import java.util.ArrayList;

public class Inventory {
    //class attributes
    private ArrayList<Item> items;

    //contructors
    public Inventory() {
        items = new ArrayList<Item>();
    }

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

//-------------------------------------------------------------------------------------------------------------
    
    public void checkOutOfInventory(Item item) {
        //TODO (Does this method check out an item, or check if the item is out of stock?)
        return;
    }
    
   
   /*  In the documentation, this returned a boolean, but no errors should be thrown, and a single boolean doesn't accurately
       capture what items couldn't be added (presumably, because they already existed in items). I've revised the method to
       instead return an ArrayList of items that couldn't be added. Feel free to let me know if you think it shouldn't. */
    
   /**
    * @param additions: an ArrayList of items to be added
    * @return: an ArrayList of items that already exist in items
    */
    public ArrayList<Item> addItems(ArrayList<Item> additions) {
        ArrayList<Item> failed = new ArrayList<Item>();
        for(Item item : additions) {
            if(this.items.contains(item)) {
                failed.add(item);
            } else {
                this.items.add(item);
            }
        }
        return failed;
    }
    
   /**
    * @param removal: a valid Item to be removed
    * @return: whether or not the item was successfuly removed
    */
    public boolean removeItem(Item removal) {
        return this.items.remove(removal);
    }
}
