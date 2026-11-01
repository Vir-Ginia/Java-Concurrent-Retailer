/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer.tools;

/**
 * Represents the packaging for a computer component.
 * 
 * @author marcoortolani
 */
public class Packaging {
    private static final int MAX_SERIAL = 100_000;
    private static int serialCount = 0;
    private final int serial;

    /**
     * Creates a new packaging.
     *
     */
    public Packaging() {
        serial = (serialCount++) % MAX_SERIAL;
    }

    @Override
    public String toString() {
        return "P[" + serial + "]";
    }
}
