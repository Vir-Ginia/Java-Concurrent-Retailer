/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.sequential;

import uk.ac.keele.csc20004.retailer.DispatchBox;
import uk.ac.keele.csc20004.retailer.Dispatcher;

/**
 * A sequential implementation of a dispatcher.
 * This implementation is provided as an example of how to use the
 * method in the retailer to implement a dispatcher.
 * 
 * This implementation is sequential, so it does not meet the requirements of the coursework.
 * 
 * @author marcoortolani
 */
public class SequentialDispatcher extends Dispatcher {

    /**
     * Creates a new sequential dispatcher.
     * 
     * @param retailer the retailer that the dispatcher works for
     */
    public SequentialDispatcher(SequentialRetailer retailer) {
        super(retailer);
    }

    /**
     * Simulates a dispatch by referring to the analogous method in the retailer.
     * It retrieves the correct number of bundles from the retailer and packs them in a dispatch box.
     * 
     * @see SequentialRetailer#dispatch()
     * @return the dispatch box
     */
    @Override
    public DispatchBox dispatchBox() throws InterruptedException {
        return retailer.dispatch();
    }
}
