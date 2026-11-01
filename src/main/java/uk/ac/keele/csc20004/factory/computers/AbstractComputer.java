/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

import java.util.ArrayList;

import uk.ac.keele.csc20004.factory.hardware.Hardware;

/**
 * A partial implementation of the Computer interface.
 * This class provides the implementation of most methods necessary to implement
 * a Computer.
 * It is specialised by the concrete computer classes for Laptop, Server and
 * Tablet.
 * 
 * @author marcoortolani
 */
public abstract class AbstractComputer implements Computer {
    private static final int MAX_SERIAL = 10000;
    private static int serialCounter = 0;

    protected ArrayList<Hardware> parts;

    protected final int serialNumber;
    protected final double price;
    protected final double energyFootprint;
    protected final double benchmarkScore;

    /**
     * Create a new computer with the given parts, provided as an array of Hardware
     * components.
     * 
     * @param parts the parts of the computer.
     */
    protected AbstractComputer(Hardware[] parts) {
        serialCounter = (++serialCounter % MAX_SERIAL);
        this.serialNumber = serialCounter;

        this.parts = new ArrayList<>(parts.length);

        for (Hardware part : parts) {
            this.parts.add(part);
        }

        double price = 0;
        for (Hardware part : parts) {
            price += part.getPrice();
        }
        this.price = price;

        // take the average of the energy footprint of the parts
        double energyFootprint = 0;
        for (Hardware part : parts) {
            energyFootprint += part.getEnergyFootprint();
        }
        this.energyFootprint = energyFootprint / parts.length;

        // take the average of the benchmark score of the parts
        double benchmarkScore = 0;
        for (Hardware part : parts) {
            benchmarkScore += part.getBenchmarkScore();
        }
        this.benchmarkScore = benchmarkScore / parts.length;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getEnergyFootprint() {
        return energyFootprint;
    }

    @Override
    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public double getBenchmarkScore() {
        return benchmarkScore;
    }

    @Override
    public int getNumParts() {
        return parts.size();
    }

    @Override
    public String toString() {
        return AbstractComputer.formatComputerString(this);
    }

    @Override
    public String printOutParts() {
        String description = "";
        for (Hardware part : parts) {
            description += part + "\n";
        }
        return description;
    }

    /**
     * Format a computer description as a string, with a fixed width for the name
     * followed by a printout of the attributes.
     * 
     * @param computer the computer to format.
     * @return the formatted string.
     */
    public static String formatComputerString(Computer computer) {
        String name = computer.getModel() + " [" + computer.getSerialNumber() + "]";
        String shortName = name.length() > 20 ? name.substring(0, 17) + "..." : name;

        String description = String.format(" | %6.2f  | %6.2f | £%7.2f", computer.getEnergyFootprint(),
                computer.getBenchmarkScore(), computer.getPrice());

        return String.format("%-20s", shortName) + description;
    }

}
