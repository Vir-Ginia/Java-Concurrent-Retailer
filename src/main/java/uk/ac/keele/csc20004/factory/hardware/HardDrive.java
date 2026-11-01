/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.hardware;

/**
 * A concrete implementation of the HardwarePart class for a HDD.
 * Besides the common attributes of a hardware part, a HDD also has a memory
 * size (in GB).
 * 
 * @author marcoortolani
 */
public class HardDrive extends HardwarePart {
    private final int size;

    /**
     * Create a new Hard Drive with the given serial number, price, energy
     * footprint, benchmark score and size.
     * Besides the common attributes of a hardware part, a Hard Drive also has a
     * size (in GB).
     * 
     * @param serialNumber    the serial number of the Hard Drive.
     * @param price           the price of the Hard Drive.
     * @param energyFootprint the energy footprint of the Hard Drive (a number
     *                        between 0.0 and 100.0).
     * @param benchmarkScore  the benchmark score of the Hard Drive (a number
     *                        between 0.0 and 100.0).
     * @param size            the size of the Hard Drive (in GB).
     */
    public HardDrive(int serialNumber, double price, double energyFootprint, double benchmarkScore, int size) {
        super(serialNumber, price, energyFootprint, benchmarkScore);

        this.size = size;
    }

    /**
     * A simple descriptive String of the hardware part (in this case, "HDD").
     */
    @Override
    protected String getDescription() {
        return String.format("%s HDD", formatSize(size));
    }

    private static String formatSize(int sizeInGB) {
        if (sizeInGB < 1024) {
            return sizeInGB + " GB";
        } else {
            double sizeInTB = sizeInGB / 1024.0;
            return String.format("%.2f TB", sizeInTB);
        }
    }
}
