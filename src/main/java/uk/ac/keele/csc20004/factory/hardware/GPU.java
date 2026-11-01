/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.hardware;

/**
 * A concrete implementation of the HardwarePart class for a GPU.
 * Besides the common attributes of a hardware part, a GPU also has a memory
 * size, which represents the amount of VRAM memory (in GB) that the GPU has.
 * 
 * @author marcoortolani
 */
public class GPU extends HardwarePart {
    private final int memorySize;

    /**
     * Create a new GPU with the given serial number, price, energy footprint,
     * benchmark score and memory size.
     * 
     * @param serialNumber    the serial number of the GPU.
     * @param price           the price of the GPU.
     * @param energyFootprint the energy footprint of the GPU (a number between 0.0
     *                        and 100.0).
     * @param benchmarkScore  the benchmark score of the GPU (a number between 0.0
     *                        and 100.0).
     * @param memorySize      the memory size of the GPU (in GB).
     */
    public GPU(int serialNumber, double price, double energyFootprint, double benchmarkScore, int memorySize) {
        super(serialNumber, price, energyFootprint, benchmarkScore);

        this.memorySize = memorySize;
    }

    /**
     * A simple descriptive String of the hardware part (in this case, "GPU").
     */
    @Override
    protected String getDescription() {
        return String.format("%2d GB GPU", memorySize);
    }

}
