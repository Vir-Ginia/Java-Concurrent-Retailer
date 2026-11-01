/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

import uk.ac.keele.csc20004.factory.hardware.Battery;
import uk.ac.keele.csc20004.factory.hardware.CPU;
import uk.ac.keele.csc20004.factory.hardware.HardwarePart;
import uk.ac.keele.csc20004.factory.hardware.RAM;
import uk.ac.keele.csc20004.factory.hardware.SSD;

/**
 * A concrete implementation of the AbstractComputer class for a Tablet.
 * A Tablet is a computer with a CPU, a RAM, a SSD and a Battery.
 * 
 * @author marcoortolani
 */
public class Tablet extends AbstractComputer {

    /**
     * Create a new Tablet with the given CPU, RAM, SSD and Battery.
     * 
     * @param cpu the CPU of the tablet.
     * @param ram the RAM of the tablet.
     * @param ssd the SSD of the tablet.
     * @param b the Battery of the tablet.
     */
    public Tablet(CPU cpu, RAM ram, SSD ssd, Battery b) {
        super(new HardwarePart[] {cpu, ram, ssd, b});
    }

    /**
     * Get the model of the computer (a simple descriptive String).
     * For simplicity, the model of a Tablet is "Tablet".
     */
    @Override
    public String getModel() {
        return "Tablet";
    }
    
}
