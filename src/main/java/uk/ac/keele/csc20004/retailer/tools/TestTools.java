/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer.tools;

/**
 * Represents the software testing tools to be used on a computer
 * in a bundle.
 * 
 * @author marcoortolani
 */
public class TestTools {
    private static final int MAX_SERIAL = 100_000;
    private static int serialCount = 0;
    private final int serial;

    /**
     * Creates a new software testing tool.
     *
     */
    public TestTools() {
        serial = (serialCount++) % MAX_SERIAL;
    }

    @Override
    public String toString() {
        return "T[" + serial + "]";
    }
}
