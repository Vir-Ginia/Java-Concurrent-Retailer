/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

/**
 * Interface defining the basic methods for a Computer.
 * Each computer has a serial number, a model (a simple descriptive String),
 * a price, an energy footprint (a percentage score representing the energy
 * efficiency of the computer),
 * a benchmark score (a percentage score representing the performance of the
 * computer),
 * a list of hardware components.
 * The energy footprint and the benchmark score are calculated as the average of
 * the energy footprint and the benchmark score of the hardware components.
 * 
 * @author marcoortolani
 */
public interface Computer {
    /**
     * Get the serial number of the computer.
     * 
     * @return the serial number of the computer.
     */
    public int getSerialNumber();

    /**
     * Get the model of the computer (a simple descriptive String).
     * 
     * @return the model of the computer.
     */
    public String getModel();

    /**
     * Get the price of the computer.
     * 
     * @return the price of the computer.
     */
    public double getPrice();

    /**
     * Get the energy footprint of the computer.
     * This is a percentage score representing the energy efficiency of the
     * computer.
     * 
     * @return the energy footprint of the computer.
     */
    public double getEnergyFootprint();

    /**
     * Get the benchmark score of the computer.
     * This is a percentage score representing the performance of the computer.
     * 
     * @return the benchmark score of the computer.
     */
    public double getBenchmarkScore();

    /**
     * Get the number of hardware components of the computer.
     * 
     * @return the number of hardware components of the computer.
     */
    public int getNumParts();

    /**
     * Get a String describing the list of hardware components of the computer.
     * 
     * @return a String describing the list of hardware components of the computer
     */
    public String printOutParts();
}
