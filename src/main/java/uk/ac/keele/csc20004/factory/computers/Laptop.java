/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

import uk.ac.keele.csc20004.factory.hardware.Battery;
import uk.ac.keele.csc20004.factory.hardware.CPU;
import uk.ac.keele.csc20004.factory.hardware.HardDrive;
import uk.ac.keele.csc20004.factory.hardware.HardwarePart;
import uk.ac.keele.csc20004.factory.hardware.RAM;

/**
 * A concrete implementation of the AbstractComputer class for a Laptop.
 * A Laptop is a computer with a CPU, a RAM, a HardDrive and a Battery.
 * 
 * @author marcoortolani
 */
public class Laptop extends AbstractComputer {

    /**
     * Create a new Laptop with the given CPU, RAM, HardDrive and Battery.
     * 
     * @param cpu  the CPU of the laptop.
     * @param ram the RAM of the laptop.
     * @param hd the HardDrive of the laptop.
     * @param b the Battery of the laptop.
     */
    public Laptop(CPU cpu, RAM ram, HardDrive hd, Battery b) {
        super(new HardwarePart[] {cpu, ram, hd, b});
    }

    /**
     * Get the model of the computer (a simple descriptive String).
     * For simplicity, the model of a Laptop is "Laptop".
     */
    @Override
    public String getModel() {
        return "Laptop";
    }

}
