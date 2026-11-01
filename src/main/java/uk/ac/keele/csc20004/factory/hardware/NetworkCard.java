/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.hardware;

/**
 * A concrete implementation of the HardwarePart class for a Network Card.
 * Besides the common attributes of a hardware part, a Network Card also has a
 * boolean attribut to indicate if it is wireless or not.
 * 
 * @author marcoortolani
 */
public class NetworkCard extends HardwarePart {
    private final boolean wifi;

    /**
     * Create a new Network Card (wired or wireless) with the given serial number, price, energy.
     * 
     * @param serialNumber the serial number of the Network Card.
     * @param price the price of the Network Card.
     * @param energyFootprint the energy footprint of the Network Card (a number between 0.0 and 100.0).
     * @param benchmarkScore the benchmark score of the Network Card (a number between 0.0 and 100.0).
     * @param wifi true if the Network Card is wireless, false otherwise.
     */
    public NetworkCard(int serialNumber, double price, double energyFootprint, double benchmarkScore, boolean wifi) {
        super(serialNumber, price, energyFootprint, benchmarkScore);

        this.wifi = wifi;
    }

    /**
     * A simple descriptive String of the hardware part (in this case, "NIC").
     */
    @Override
    protected String getDescription() {
        if(wifi)
            return "WiFi";
        else
            return "Eth";
    }
}
