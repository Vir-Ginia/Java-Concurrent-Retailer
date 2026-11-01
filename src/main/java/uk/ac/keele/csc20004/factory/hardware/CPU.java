/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.hardware;

/**
 * A concrete implementation of the HardwarePart class for a CPU.
 * Besides the common attributes of a hardware part, a CPU also has a clock speed.
 *  
 * @author marcoortolani
 */
public class CPU extends HardwarePart {
    private final double clockSpeed;

    /**
     * Create a new CPU with the given serial number, price, energy footprint, benchmark score and number of cores.
     * Besides the common attributes of a hardware part, a CPU also has a clock speed.
     * 
     * @param serialNumber the serial number of the CPU.
     * @param price the price of the CPU.
     * @param energyFootprint the energy footprint of the CPU (a number between 0.0 and 100.0).
     * @param benchmarkScore the benchmark score of the CPU (a number between 0.0 and 100.0).
     * @param clockSpeed the cleck speed of the CPU (in GHz).
     */
    public CPU(int serialNumber, double price, double energyFootprint, double benchmarkScore, double clockSpeed) {
        super(serialNumber, price, energyFootprint, benchmarkScore);
        this.clockSpeed = clockSpeed;
    }

    /**
     * A simple descriptive String of the hardware part (in this case, "CPU").
     */
    @Override
    protected String getDescription() {
        return String.format("%1.2f GHz CPU", clockSpeed);
    }   
}
