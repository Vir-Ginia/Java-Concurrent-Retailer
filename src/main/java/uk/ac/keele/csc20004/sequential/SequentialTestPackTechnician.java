/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.sequential;

import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.retailer.Bundle;
import uk.ac.keele.csc20004.retailer.ComputerRetailer;
import uk.ac.keele.csc20004.retailer.ComputerTechnician;

/**
 * A sequential implementation of a pack technician.
 * 
 * This implementation is provided as an example of how to use the method in the retailer to implement a pack technician.
 * This implementation is sequential, so it does not meet the requirements of the coursework.
 * 
 * @author marcoortolani
 */
public class SequentialTestPackTechnician extends ComputerTechnician {

    /**
     * Creates a new sequential pack technician.
     * @param retailer the retailer that the technician works for
     */
    public SequentialTestPackTechnician(ComputerRetailer retailer) {
        super(retailer);
    }

    /**
     * Simulates a bundle creation by referring to the analogous method in the retailer.
     * It retrieves the assembled computer from the retailer and packs it in a bundle,
     * by retrieving the necessary tools from the toolboxes.
     * 
     * @see ComputerRetailer#getAssembledComputer()
     * @see ComputerRetailer#test_pack(Computer)
     * 
     * @return the bundle
     */
    @Override
    public Bundle createBundle() throws InterruptedException {
        Computer computer = retailer.getAssembledComputer();
        Bundle bundle = retailer.test_pack(computer);

        return bundle;
    }

}
