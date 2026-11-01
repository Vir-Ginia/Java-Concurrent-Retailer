/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer;

/**
 * A technician that creates a bundle and sends it to dispatch.
 * This is an abstract class that shows the common functionality of either type of technician.
 * 
 * @author marcoortolani
 */
public abstract class ComputerTechnician {
    protected ComputerRetailer retailer;

    /**
     * This constructor creates a technician for a retailer.
     * 
     * @param retailer the retailer that the technician works for
     */
    public ComputerTechnician(ComputerRetailer retailer) {
        this.retailer = retailer;
    }

    /**
     * Method to create a bundle. The method must take care of accessing the
     * appropriate tools and creating the bundle.
     * The method isa abstract and must be implemented by the concrete technician.
     * 
     * @return the bundle created
     * @throws InterruptedException if the thread is interrupted (when sleeping or waiting for a resource)
     */
    public abstract Bundle createBundle() throws InterruptedException;

    /**
     * Method to send a bundle to the waiting queu before dispatch.
     * 
     * @param b the bundle to send
     * @throws InterruptedException if the thread is interrupted (when sleeping or waiting for a resource)
     */
    public void sendToDispatch(Bundle b) throws InterruptedException {
        retailer.enqueueForDispatch(b);
    }
}
