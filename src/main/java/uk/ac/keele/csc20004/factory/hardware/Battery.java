/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.hardware;

/**
 * A concrete implementation of the HardwarePart class for a Battery.
 * 
 * @author marcoortolani
 */
public class Battery extends HardwarePart {
    private final int cyclelife;

    /**
     * Create a new Battery with the given serial number, price, energy footprint and benchmark score.
     * Besides the common attributes of a hardware part, a Battery also has a cycle life, which 
     * refers to the number of charge and discharge cycles it can undergo before its capacity 
     * significantly degrades.
     * 
     * @param serialNumber the serial number of the battery.
     * @param price the price of the battery.
     * @param energyFootprint the energy footprint of the battery (a number between 0.0 and 100.0).
     * @param benchmarkScore the benchmark score of the battery (a number between 0.0 and 100.0).
     * @param cyclelife the number of charge/discharge cycles before degradation
     */
    public Battery(int serialNumber, double price, double energyFootprint, double benchmarkScore, int cyclelife) {
        super(serialNumber, price, energyFootprint, benchmarkScore);

        this.cyclelife = cyclelife;
    }

    /**
     * A simple descriptive String of the hardware part (in this case, "Battery").
     * This method will be used within toString() to provide a customised description of the battery.
     * 
     * @return a simple descriptive String of the battery.
     */
    @Override
    protected String getDescription() {
        return "Battery/" + cyclelife + "c.";
    }    
}
