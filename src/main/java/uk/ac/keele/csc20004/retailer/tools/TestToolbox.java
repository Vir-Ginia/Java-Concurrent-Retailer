/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer.tools;

import uk.ac.keele.csc20004.coursework.SimulationParameters;

/**
 * A toolbox containing the sfotware testing tools for a bundle.
 *
 * @author marcoortolani
 */
public class TestToolbox {
    /**
     * Gets a software testing tool.
     * 
     * @return the software testing tool
     */
    public TestTools getTool() {
        try {
            Thread.sleep(SimulationParameters.TEST_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new TestTools();
    }

}
