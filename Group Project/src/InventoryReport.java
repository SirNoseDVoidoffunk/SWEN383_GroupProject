/**
 * InventoryReport class that's used to format a inventory report that's issued by a manager
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samuel Crouch
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

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

    /**
     * Adds an item to the list of items
     * @param item - An item to be added
     */
    public void addItem(Item item) {
        getList_of_items().add(item);
    }

    /**
     * Generates an inventory report CSV
     * @return String - The name of the generated CSV file
     */
    public String getReport() {
        LocalDate date = LocalDate.now();
        String file_Name = "inventory-report-"+date.toString()+".csv";
        try {
            FileWriter csvWriter = new FileWriter(file_Name);

            csvWriter.append("Name,Type,Item ID,Copies Owned,Copies Rented,Copies On Hold,Copies In Stock,Pending Reservations\n");

            for(Item item : list_of_items) {
                csvWriter.append(item.getName()+",");
                csvWriter.append(item.getType()+",");
                csvWriter.append(item.getItemId()+",");
                csvWriter.append(item.getInventoryAmount()+",");
                int counter = 0;
                if(item.getCustomerRenting() != null) {
                    counter++;
                    csvWriter.append("1,");
                } else {
                    csvWriter.append("0,");
                }
                if(item.getCustomerReserving() != null) {
                    counter++;
                    csvWriter.append("1,");
                } else {
                    csvWriter.append("0,");
                }
                csvWriter.append((item.getInventoryAmount()-counter)+",");
                csvWriter.append(item.getReservationList().size()+"\n");
            }
            csvWriter.flush();
            csvWriter.close();

            return file_Name;
        } catch (IOException e) {
            return "";
        }
    }


}
