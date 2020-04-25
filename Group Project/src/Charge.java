/**
 * Charge class that's used to keep track of charges and fees that can applied to customers
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

import java.util.Date;

public class Charge {
    //class attributes
    private Payment amount;
    private Date issuedReturn;
    private Date actualReturn;
    private Item itemOverdue;

    //constructors
    public Charge() {
        amount = new Payment();
        issuedReturn = new Date();
        actualReturn = new Date();
        itemOverdue = new Item();
    }

    public Charge(Payment amount, Date issuedReturn, Date actualReturn, Item itemOverdue) {
        this.amount = amount;
        this.issuedReturn = issuedReturn;
        this.actualReturn = actualReturn;
        this.itemOverdue = itemOverdue;
    }

    //accesors and mutators

    public Payment getAmount() {
        return amount;
    }

    public void setAmount(Payment amount) {
        this.amount = amount;
    }

    public Date getIssuedReturn() {
        return issuedReturn;
    }

    public void setIssuedReturn(Date issuedReturn) {
        this.issuedReturn = issuedReturn;
    }

    public Date getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(Date actualReturn) {
        this.actualReturn = actualReturn;
    }

    public Item getItemOverdue() {
        return itemOverdue;
    }

    public void setItemOverdue(Item itemOverdue) {
        this.itemOverdue = itemOverdue;
    }

    /*
---------------------------------------------------------------------------------------------------------------
                    additional methods below

                    //calcDays()
                    //calcFine()
    */
}
