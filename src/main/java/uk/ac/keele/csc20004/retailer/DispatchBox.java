/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer;

/**
 * The dispatch box containing the bundles.
 * The box has a fixed capacity and must be filled before it can be dispatched.
 * 
 * @author marcoortolani
 */
public class DispatchBox {
    protected final Bundle[] bundles;
    protected int index;

    /**
     * Creates a new dispatch box with the given capacity.
     * 
     * @param capacity the capacity of the box
     */
    public DispatchBox(int capacity) {
        bundles = new Bundle[capacity];
        index = 0;
    }
    /**
     * Returns the capacity of the box.
     * 
     * @return the capacity
     */
    public int capacity() {
        return bundles.length; 
    }

    /**
     * Adds a bundle to the box.
     * Adding more than the capacity will result in an exception.
     * 
     * @param b the bundle to add
     */
    public void add(Bundle b) {
        bundles[index++] = b;
    }

    /**
     * Returns a description of the box (by listing the bundles in it)
     * 
     * @return the description of the box
     */
    @Override
    public String toString() {
        String descr = "{ ";
        for (Bundle bundle : bundles) {
            descr += bundle + " ";
        }
        descr += "} ";
        return descr;
    }
}
