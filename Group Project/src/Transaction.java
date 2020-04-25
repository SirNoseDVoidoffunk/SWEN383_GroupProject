import java.util.ArrayList;

/**
 * Transaction class that's used to issue the correct type of transaction process and call that process to log itself
 * to the interface computer
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */
public class Transaction {
    //class attributes
    private int transactionID;
    private double total_charges;
    private double subtotal;
    private double taxes;
    private ArrayList<Item> line_items;

    //constructors


    public Transaction() {
        transactionID = -1;
        total_charges = 0.0;
        subtotal = 0.0;
        taxes = 0.0;
        line_items = new ArrayList<Item>();
    }

    public Transaction(int transactionID, double total_charges, double subtotal, double taxes, ArrayList<Item> line_items) {
        this.transactionID = transactionID;
        this.total_charges = total_charges;
        this.subtotal = subtotal;
        this.taxes = taxes;
        this.line_items = line_items;
    }

    //accesors and mutators

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public double getTotal_charges() {
        return total_charges;
    }

    public void setTotal_charges(double total_charges) {
        this.total_charges = total_charges;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public ArrayList<Item> getLine_items() {
        return line_items;
    }

    public void setLine_items(ArrayList<Item> line_items) {
        this.line_items = line_items;
    }

    /**
     * Logs the transaction to the regional control computer
     * @return status - True if the transaction was able to be logged into the regional control computers
     */
    public boolean logTransaction() {
        // this is where we would connect to the regional control computer and log the transaction
        // For the POC, we are only return true in assumption this action gets carried out when in full development
        return true;
    }
}
