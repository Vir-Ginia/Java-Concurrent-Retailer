/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer;

import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.retailer.tools.PackagingToolbox;
import uk.ac.keele.csc20004.retailer.tools.SoftwarePackToolbox;
import uk.ac.keele.csc20004.retailer.tools.TestToolbox;

/**
 * This class represents a partial implementation of a computer retailer.
 * It is provided for your convenience and you should extend it to implement
 * your own retailer.
 * 
 * @see ComputerRetailer
 * @author marcoortolani
 */
public abstract class AbstractComputerRetailer implements ComputerRetailer {
    protected final int assemblyLineCapacity;

    protected final SoftwarePackToolbox softwarePackToolbox;
    protected final PackagingToolbox packagingToolbox;
    protected final TestToolbox testToolbox;

    protected final int dispatchBoxCapacity;

    /**
     * Create a new computer retailer with the given assembly line and dispatch box
     * capacities.
     * 
     * @param assemblyLineCapacity the capacity of the assembly line
     * @param dispatchBoxCapacity the capacity of the dispatch box
     */
    public AbstractComputerRetailer(int assemblyLineCapacity, int dispatchBoxCapacity) {
        this.assemblyLineCapacity = assemblyLineCapacity;
        this.dispatchBoxCapacity = dispatchBoxCapacity;
        
        softwarePackToolbox = new SoftwarePackToolbox();
        packagingToolbox = new PackagingToolbox();
        testToolbox = new TestToolbox();
    }

    /**
     * Store the given computer in the assembly line.
     * Needs to be implemented by the concrete retailer.
     * 
     * @param computer the computer to store
     */
    @Override
    public abstract void storeAssembledComputer(Computer computer) throws InterruptedException;

    /**
     * Retrieve a computer from the assembly line.
     * Needs to be implemented by the concrete retailer.
     * 
     * @return the computer retrieved from the assembly line
     */
    @Override
    public abstract Computer getAssembledComputer() throws InterruptedException;

    /**
     * Production of a bundle of software, testing and packaging for a computer.
     * 
     * @param computer the computer to process
     * @return the bundle
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    @Override
    public abstract Bundle test_pack(Computer computer) throws InterruptedException;

    /**
     * Production of a bundle of packaging, plus attached software pack for a computer.
     * 
     * @param computer the computer to process
     * @return the bundle
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    @Override
    public abstract Bundle pack(Computer computer) throws InterruptedException;

    /**
     * Enqueues a bundle for dispatch.
     * The idea is that the retailer will have a queue of bundles from where the dispatchers will take them
     * to fill a box.
     * 
     * @param b the bundle to enqueue
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    @Override
    public abstract void enqueueForDispatch(Bundle b) throws InterruptedException;

    /**
     * Simulates filling a box with bundles from the list of waiting bundels, and dispatching the box.
     * 
     * @return the box that has been dispatched
     * @throws InterruptedException if the thread is interrupted (mostly due to use of sleep())
     */
    @Override
    public abstract DispatchBox dispatch() throws InterruptedException;
}
