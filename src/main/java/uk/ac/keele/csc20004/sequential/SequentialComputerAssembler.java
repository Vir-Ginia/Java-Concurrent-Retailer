/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.sequential;

import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.retailer.ComputerAssembler;
import uk.ac.keele.csc20004.retailer.ComputerRetailer;

/**
 * A sequential implementation of a computer assembler.
 * This implementation is provided as an example of how to use the 
 * method in the computer retailer to implement an assembler.
 *
 * This implementation is sequential, so it does not meet the requirements of the coursework.
 * 
 * @author marcoortolani
 */
public class SequentialComputerAssembler extends ComputerAssembler {

    /**
     * Creates a new sequential computer assembler.
     * 
     * @param retailer the retailer that the assembler works for
     */
    public SequentialComputerAssembler(ComputerRetailer retailer) {
        super(retailer);
    }

    /**
     * Simulates a computer assembly by producing a random computer and storing it in the retailer.
     */
    @Override
    public void assembleComputer() {
        Computer computer = produceRandomComputer();
        try {
            retailer.storeAssembledComputer(computer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

}
