/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer;

/**
 * Represents a dispatcher for the retailer.
 * 
 * @author marcoortolani
 */
public abstract class Dispatcher {
    protected ComputerRetailer retailer;

    /**
     * Creates a new dispatcher.
     * @param retailer the retailer that the dispatcher is associated with
     */
    public Dispatcher(ComputerRetailer retailer) {
        this.retailer = retailer;
    }

    /**
     * Dispatches a box.
     * 
     * @return the box that has been dispatched
     * @throws InterruptedException if the thread is interrupted (e.g. when sleeping or waiting for a lock)
     */
    public abstract DispatchBox dispatchBox() throws InterruptedException;
}
