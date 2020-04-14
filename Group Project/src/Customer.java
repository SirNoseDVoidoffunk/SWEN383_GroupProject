/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/

import java.util.ArrayList;

public class Customer {
    //class attributes
    private String customer_account_status;
    private Double accountBalance;
    private ArrayList<Charge> finesOwed;
    private String creditCardNumber;
    private String creditCardExp;
    private ArrayList<Item> rentedItems;
    private ArrayList<Item> reservedItems;

    //constructors

    public Customer() {
        customer_account_status = "";
        accountBalance = 0.0;
        creditCardNumber = "";
        creditCardExp = "";
        finesOwed = new ArrayList<Charge>();
        rentedItems = new ArrayList<Item>();
        reservedItems = new ArrayList<Item>();
    }

    public Customer(String customer_account_status, Double accountBalance, ArrayList<Charge> finesOwed,
                    String creditCardNumber, String creditCardExp, ArrayList<Item> rentedItems,
                    ArrayList<Item> reservedItems) {
        this.customer_account_status = customer_account_status;
        this.accountBalance = accountBalance;
        this.finesOwed = finesOwed;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExp = creditCardExp;
        this.rentedItems = rentedItems;
        this.reservedItems = reservedItems;
    }

    //accesors and mutators

    public String getCustomer_account_status() {
        return customer_account_status;
    }

    public void setCustomer_account_status(String customer_account_status) {
        this.customer_account_status = customer_account_status;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public ArrayList<Charge> getFinesOwed() {
        return finesOwed;
    }

    public void setFinesOwed(ArrayList<Charge> finesOwed) {
        this.finesOwed = finesOwed;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardExp() {
        return creditCardExp;
    }

    public void setCreditCardExp(String creditCardExp) {
        this.creditCardExp = creditCardExp;
    }

    public ArrayList<Item> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(ArrayList<Item> rentedItems) {
        this.rentedItems = rentedItems;
    }

    public ArrayList<Item> getReservedItems() {
        return reservedItems;
    }

    public void setReservedItems(ArrayList<Item> reservedItems) {
        this.reservedItems = reservedItems;
    }

    /*
---------------------------------------------------------------------------------------------------------------
                    Additional methods below
                    //reserveItem()
                    //cancelReservation()
                    //rentItem()
                    //returnItem()
                    //addLateCharge()
                    //showInquiry()
                    //pay()
                    //removeLateCharge()
    */
}
