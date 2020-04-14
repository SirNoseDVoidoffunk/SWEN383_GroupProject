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

    /*
-------------------------------------------------------------------------------------------------------------
                additional methods below
                //checkOutOfInventory()
                //addItems()
                //removeItem()
                //getItems()
    */
}
