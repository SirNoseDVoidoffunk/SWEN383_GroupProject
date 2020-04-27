/**
 * Cash class that's used to validate a cash operation
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

public class Cash extends Payment {

    double amountDue;

    public Cash() {
        super();
    }

    public Cash(double amountPaid, double amountDue, String currency) {
        super(amountPaid, currency);
        this.amountDue = amountDue;
    }
    //Empty class - No attributes or methods

    /**
     * Overrides Payment method approve, checks to see if the amount given suffices
     * @return
     */
    @Override
    public boolean approve(double amountDue, double amountIssued, String currency) {
        if(amountDue <= amountIssued) {
            return true;
        } else {
            return false;
        }
    }
}
