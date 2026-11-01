/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.hardware;

/**
 * A concrete implementation of the HardwarePart class for a RAM.
 * Besides the common attributes of a hardware part, a RAM also has a memory
 * size (in GB).
 * 
 * @author marcoortolani
 */
public class RAM extends HardwarePart {
    private final int size;

    /**
     * Create a new RAM with the given serial number, price, energy
     * footprint, benchmark score and size.
     * 
     * @param serialNumber    the serial number of the RAM.
     * @param price           the price of the RAM.
     * @param energyFootprint the energy footprint of the RAM (a number between 0.0
     *                        and 100.0).
     * @param benchmarkScore  the benchmark score of the RAM (a number between 0.0
     *                        and 100.0).
     * @param size            the size of the RAM (in GB).
     */
    public RAM(int serialNumber, double price, double energyFootprint, double benchmarkScore, int size) {
        super(serialNumber, price, energyFootprint, benchmarkScore);

        this.size = size;
    }

    /**
     * A simple descriptive String of the hardware part (in this case, "RAM").
     */
    @Override
    protected String getDescription() {
        return String.format("%2d GB RAM", size);
    }
}