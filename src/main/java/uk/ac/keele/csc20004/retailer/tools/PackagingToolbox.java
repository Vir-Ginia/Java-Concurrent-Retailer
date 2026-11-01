/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer.tools;

import uk.ac.keele.csc20004.coursework.SimulationParameters;

/**
 * The toolbox containing packaging for the bundles.
 * 
 * @author marcoortolani
 */
public class PackagingToolbox {

    /**
     * Gets packaging for the bundle.
     * 
     * @return the packaging
     */
    public Packaging getTool() {
        try {
            Thread.sleep(SimulationParameters.PACKAGE_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         return new Packaging();
    }

}
