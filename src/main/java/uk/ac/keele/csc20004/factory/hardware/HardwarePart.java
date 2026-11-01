/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.hardware;

/**
 * A partial implementation of the Hardware interface, providing a default
 * implementation for the methods that are common to all hardware parts.
 * 
 * @author marcoortolani
 */
public abstract class HardwarePart implements Hardware {
    private final int serialNumber;
    private final double price;
    private final double energyFootprint;
    private final double benchmarkScore;

    /**
     * Create a new hardware part with the given serial number, price, energy
     * footprint and benchmark score.
     * 
     * @param serialNumber    the serial number of the hardware part.
     * @param price           the price of the hardware part.
     * @param energyFootprint the energy footprint of the hardware part (a number beween 0.0 and 100.0).
     * @param benchmarkScore  the benchmark score of the hardware part (a number beween 0.0 and 100.0).
     */
    public HardwarePart(int serialNumber, double price, double energyFootprint, double benchmarkScore) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.energyFootprint = energyFootprint;
        this.benchmarkScore = benchmarkScore;
    }

    /**
     * A simple descriptive String of the hardware part.
     * This method should be implemented by concrete subclasses and will be
     * used within toString() to provide a customised description of the hardware part.
     * 
     * @return  a simple descriptive String of the hardware part.
     */
    protected abstract String getDescription();

    /**
     * Get the serial number of the hardware part.
     * 
     * @return the serial number of the hardware part.
     */
    @Override
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * Get the price of the hardware part.
     * 
     * @return the price of the hardware part.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Get the energy footprint of the hardware part.
     * 
     * @return the energy footprint of the hardware part.
     */
    @Override
    public double getEnergyFootprint() {
        return energyFootprint;
    }

    /**
     * Get the benchmark score of the hardware part.
     * 
     * @return the benchmark score of the hardware part.
     */
    @Override
    public double getBenchmarkScore() {
        return benchmarkScore;
    }

    /**
     * Specialised version of the equals method for HardwarePart objects.
     * Two hardware parts are considered equal if they have the same serial number
     * (arguably, all other attributes should be the same as well)
     * 
     * @param obj the object to compare with.
     * @return true if the two hardware parts have the same serial number, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HardwarePart) {
            return this.getSerialNumber() == ((HardwarePart) obj).getSerialNumber();
        } else {
            return super.equals(obj);
        }
    }

    /**
     * Overridded version of the toString method for HardwarePart objects.
     * 
     * @return a String representation of the hardware part.
     */
    @Override
    public String toString() {

        String name = getDescription() + " [" + getSerialNumber() + "]";
        String shortName = name.length() > 20 ? name.substring(0, 17) + "..." : name;

            String description = String.format(" | %6.2f  | %6.2f | £%7.2f", getEnergyFootprint(),
                getBenchmarkScore(), getPrice());

        return String.format("%-20s", shortName) + description;
    }
}
