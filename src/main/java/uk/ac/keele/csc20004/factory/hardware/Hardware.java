/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.hardware;

/**
 * Interface defining what is meant by "hardware" in the context of
 * the coursework. A hardware component is characterised by having a serial
 * number, a price, an energy footprint and a benchmark score.
 * The energy footprint and the benchmark score will be real numbers to be
 * interpreted as percentages representing the energy efficiency and the
 * performance of the hardware component, respectively.
 * 
 * @author marcoortolani
 */
public interface Hardware {
    /**
     * Get the (possbily, unique) serial number of the hardware component.
     * 
     * @return the serial number of the hardware component.
     */
    public int getSerialNumber();

    /**
     * Get the price of the hardware component.
     * 
     * @return the price of the hardware component.
     */
    public double getPrice();

    /**
     * Get the energy footprint of the hardware component.
     * This is a percentage score (a number between 0.0 and 100.0) representing the
     * energy efficiency of the hardware component.
     * 
     * @return the energy footprint of the hardware component.
     */
    public double getEnergyFootprint();

    /**
     * Get the benchmark score of the hardware component.
     * This is a percentage score (a number between 0.0 and 100.0) representing the
     * performance of the hardware component.
     * 
     * @return the benchmark score of the hardware component.
     */
    public double getBenchmarkScore();
}
