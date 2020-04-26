/**
 * Clerk class that represents a clerk
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

public class Clerk extends Employee {

    public Clerk() {
        super();
    }

    public Clerk(int id, String name, String home_address, String mobile_phone,
                 String home_phone, String email_address, String creditCardInfo, String password) {
        super(id, name, home_address, mobile_phone, home_phone, email_address, password);
    }
}
