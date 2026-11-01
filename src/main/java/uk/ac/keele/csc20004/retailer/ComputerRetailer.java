/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer;

import uk.ac.keele.csc20004.factory.computers.Computer;

/**
 * An interface defining the operations that a computer retailer must support.
 *
 * @author marcoortolani
 */
public interface ComputerRetailer {
    /**
     * Stores the computer in the retailer's assembly line.
     * 
     * @param computer the computer to store
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    public void storeAssembledComputer(Computer computer) throws InterruptedException;

    /**
     * Retrieves a computer from the retailer's assembly line.
     * @return the computer
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    public Computer getAssembledComputer() throws InterruptedException;

    /**
     * Production of a bundle of software, testing and packaging for a computer.
     * 
     * @param computer the computer to process
     * @return the bundle
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    public Bundle test_pack(Computer computer) throws InterruptedException;

    /**
     * Production of a bundle of packaging, plus attached software pack for a computer.
     * 
     * @param computer the computer to process
     * @return the bundle
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    public Bundle pack(Computer computer) throws InterruptedException;

    /**
     * Enqueues a bundle for dispatch.
     * The idea is that the retailer will have a queue of bundles from where the dispatchers will take them
     * to fill a box.
     * 
     * @param b the bundle to enqueue
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    public void enqueueForDispatch(Bundle b) throws InterruptedException;

    /**
     * Simulates filling a box with bundles from the list of waiting bundels, and dispatching the box.
     * @return the box that has been dispatched
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    public DispatchBox dispatch() throws InterruptedException;
}
