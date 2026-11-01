/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer;

import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.retailer.tools.Packaging;
import uk.ac.keele.csc20004.retailer.tools.SoftwarePack;
import uk.ac.keele.csc20004.retailer.tools.TestTools;

/**
 * Represents a bundle of a computer, software pack, (optional) test tools and packaging.
 * 
 * @author marcoortolani
 */
public class Bundle {
    protected final Computer computer;
    protected final SoftwarePack softwarePack;
    protected final TestTools testTools;
    protected final Packaging packaging;

    /**
     * This constructor creates a bundle with a computer, software pack, test tools and packaging.
     * It will be used by the test_and_pack technician.
     * 
     * @param computer the computer to be bundled
     * @param softwarePack the software pack to be added
     * @param testTools the test tools to be used
     * @param packaging the packaging to be used
     */
    public Bundle(Computer computer, SoftwarePack softwarePack, TestTools testTools, Packaging packaging) {
        this.computer = computer;
        this.softwarePack = softwarePack;
        this.testTools = testTools;
        this.packaging = packaging;
    }

    /**
     * This constructor creates a bundle with a computer, software pack and packaging.
     * It will be used by the pack technician.
     * @param computer the computer to be bundled
     * @param packaging the packaging to be used
     * @param softwarePack the software pack to be added
     */
    public Bundle(Computer computer, Packaging packaging, SoftwarePack softwarePack) {
        this.computer = computer;
        this.softwarePack = softwarePack;
        this.testTools = null;
        this.packaging = packaging;
    }

    @Override
    public String toString() {
        if (testTools == null) {
            return "<" + computer.getModel() + "[" + computer.getSerialNumber() + "]" + ", " + packaging + ", "
                    + softwarePack + ">";
        } else {
            return "<" + computer.getModel() + "[" + computer.getSerialNumber() + "]" + ", " + softwarePack + ", "
                    + testTools + ", " + packaging + ">";
        }
    }
}
