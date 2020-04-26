/**
 * DVD class that's used to represent a DVD item in the store
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */

public class DVD extends Item {

    public DVD() {
        super();
    }

    public DVD(boolean available, boolean onReserve, boolean inStock, int inventoryAmount, String name, String type) {
        super(available, onReserve, inStock, inventoryAmount, name, type);
    }

}
