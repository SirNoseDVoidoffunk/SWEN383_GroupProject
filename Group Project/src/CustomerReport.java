/**
 * Customer Report class that's used to format a customer support that's issued to a manager
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samuel Crouch
 */


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class CustomerReport {
    //class attributes
    private ArrayList<Customer> list_of_cust;

    //constructors

    public CustomerReport() {
        list_of_cust = new ArrayList<Customer>();
    }

    public CustomerReport(ArrayList<Customer> list_of_cust) {
        this.list_of_cust = list_of_cust;
    }

    //accesors and mutators

    public ArrayList<Customer> getList_of_cust() {
        return list_of_cust;
    }

    public void setList_of_cust(ArrayList<Customer> list_of_cust) {
        this.list_of_cust = list_of_cust;
    }

    /**
     * Adds a customer to the list of customers
     * @param cust - A customer to be added
     */
    public void addCustomer(Customer cust) {
        getList_of_cust().add(cust);
    }

    /**
     * Generates a customer report file
     * @return String - The name of the generated text file
     */
    public String getReport() {
        LocalDate date = LocalDate.now();
        String file_Name = "customer-report-"+date.toString()+".txt";
        try {
            FileWriter txtWriter = new FileWriter(file_Name);

            for(Customer cust : list_of_cust) {
                txtWriter.append("Name: "+cust.getName()+"\r\n");
                txtWriter.append("Home Phone: "+cust.getHome_phone()+"\r\n");
                txtWriter.append("Mobile Phone: "+cust.getMobile_phone()+"\r\n");
                txtWriter.append("Email Address: "+cust.getEmail_address()+"\r\n");

                txtWriter.append("\r\nCurrent Rentals: "+cust.getRentedItems().size()+"\r\n");
                txtWriter.append("Overdue Items:\r\n");
                boolean overdue = false;
                for(Item item : cust.getRentedItems()) {
                    if(item.getReturnDate().before(new Date())) {
                        txtWriter.append("\t"+item.getName()+": Due "+item.getReturnDate()+"\r\n");
                        overdue = true;
                    }
                }
                if(!overdue) {
                    txtWriter.append("\tNone\r\n");
                }

                txtWriter.append("Fines:\r\n");
                double total = 0;
                for(Charge fine : cust.getFinesOwed()) {
                    txtWriter.append("\t"+fine.getItemOverdue().getName()+": Due "+fine.getIssuedReturn()+", returned "+fine.getActualReturn()+". Amount: $"+fine.getAmount().getAmount()+"\r\n");
                    total += fine.getAmount().getAmount();
                }
                if(total>0) {
                    txtWriter.append("\tTotal owed: $"+total+"\r\n");
                } else {
                    txtWriter.append("\tNone\r\n");
                }
                txtWriter.append("\r\n");
            }
            txtWriter.flush();
            txtWriter.close();

            return file_Name;
        } catch (IOException e) {
            return "";
        }
    }
}
