/**
 * CD class that's used to represent a CD item in the store's inventory
 * @version 4/26/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samuel Crouch
 */
public class CD extends Item {

    public CD() {
        super();
    }

    public CD(boolean available, boolean onReserve, boolean inStock, int inventoryAmount, double retailRate, String name, String type) {
        super(available, onReserve, inStock, inventoryAmount, retailRate, name, type);
    }
    //empty class - no attributes or methods
}
