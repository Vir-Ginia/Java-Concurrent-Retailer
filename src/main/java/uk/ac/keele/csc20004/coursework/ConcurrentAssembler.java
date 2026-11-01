/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.coursework;

import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.retailer.ComputerAssembler;
import uk.ac.keele.csc20004.retailer.ComputerRetailer;

/**
 * A concurrent computer assembler. This class is provided as an example of how
 * to implement
 * the concurrent version of a worker, startig from the sequential
 * implementation.
 * The class implements the Runnable interface, so it is not directly a threa
 * but
 * can easily be used to create one.
 * 
 * @author marcoortolani
 */
public class ConcurrentAssembler extends ComputerAssembler implements Runnable {

    public ConcurrentAssembler(ComputerRetailer retailer) {
        super(retailer);
    }

    /**
     * Assembles a computer and stores it in the retailer.
     * This method is the same as the one in the sequential version
     * 
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

    /**
     * When used as a thread, the assembler will periodically
     * try to assemble a computer for the retailer.
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(SimulationParameters.ASSEMBLY_TIME);
                assembleComputer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }    
        }
    }
}
