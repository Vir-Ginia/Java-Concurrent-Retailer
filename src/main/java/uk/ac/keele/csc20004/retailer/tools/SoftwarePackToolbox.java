/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer.tools;

import uk.ac.keele.csc20004.coursework.SimulationParameters;

/**
 * This class represents a toolbox for the SoftwarePack tool.
 * 
 * @author marcoortolani
 */
public class SoftwarePackToolbox {
    /**
     * Gets a software pack.
     * 
     * @return the software pack
     */
    public SoftwarePack getTool() {
        try {
            Thread.sleep(SimulationParameters.SW_PACK_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new SoftwarePack();
    }
}
