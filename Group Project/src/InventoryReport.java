/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/

import java.util.ArrayList;

public class InventoryReport {
    //class attributes
    private ArrayList<Item> list_of_items;

    //constructors
    public InventoryReport() {
        list_of_items = new ArrayList<Item>();
    }

    public InventoryReport(ArrayList<Item> list_of_items) {
        this.list_of_items = list_of_items;
    }

    //accesors and mutators

    public ArrayList<Item> getList_of_items() {
        return list_of_items;
    }

    public void setList_of_items(ArrayList<Item> list_of_items) {
        this.list_of_items = list_of_items;
    }

    /*
---------------------------------------------------------------------------------------------------------------------
                additional methods below

                //getReport()
                //getItemList()
                //addItem()
    */
}
