/**
 * InventoryReport class that's used to format a inventory report that's issued by a manager
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
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
