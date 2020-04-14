/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/


import java.util.ArrayList;

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

    /*
-------------------------------------------------------------------------------------------------------
                    additional methods below

                    //getReport()
                    //addCustomer()
                    //getCustomerList()
    */
}
