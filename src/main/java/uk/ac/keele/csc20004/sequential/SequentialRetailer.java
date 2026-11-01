/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.sequential;

import java.util.ArrayList;

import uk.ac.keele.csc20004.coursework.SimulationParameters;
import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.retailer.AbstractComputerRetailer;
import uk.ac.keele.csc20004.retailer.Bundle;
import uk.ac.keele.csc20004.retailer.ComputerAssembler;
import uk.ac.keele.csc20004.retailer.ComputerTechnician;
import uk.ac.keele.csc20004.retailer.DispatchBox;
import uk.ac.keele.csc20004.retailer.Dispatcher;
import uk.ac.keele.csc20004.retailer.tools.Packaging;
import uk.ac.keele.csc20004.retailer.tools.SoftwarePack;
import uk.ac.keele.csc20004.retailer.tools.TestTools;

/**
 * A sequential implementation of a computer retailer.
 * This implementation is provided as an example of how to use implemwnt the basic programming logic of the retailer.
 * This implementation is sequential, so it does not meet the requirements of the coursework.
 * 
 * @author marcoortolani 
 */
public class SequentialRetailer extends AbstractComputerRetailer {
    private ArrayList<Computer> computers = new ArrayList<Computer>();
    private ArrayList<Bundle> bundleAccumulator = new ArrayList<>();

    /**
     * Creates a new sequential retailer.
     * 
     * @param assemblyLineCapacity the capacity of the assembly line
     * @param dispatchBoxCapacity the capacity of the dispatch box
     */
    public SequentialRetailer(int assemblyLineCapacity, int dispatchBoxCapacity) {
        super(assemblyLineCapacity, dispatchBoxCapacity);
    }

    /**
     * Simulates the storage of an assembled computer by storing it in a list.
     * 
     * @param computer the computer to store
     */
    @Override
    public void storeAssembledComputer(Computer computer) {
        computers.add(computer);
        System.out.println("Stored: " + computer.getModel() + "[" + computer.getSerialNumber() + "]");
    }

    /**
     * Simulates the retrieval of an assembled computer by removing it from the list.
     * 
     * @return the assembled computer
     */
    @Override
    public Computer getAssembledComputer() {
        if (computers.isEmpty()) {
            return null;
        }

        Computer computer = computers.remove(0);
        System.out.println("Retrieved: " + computer.getModel() + "[" + computer.getSerialNumber() + "]");

        return computer;
    }

    /**
     * Simulates the creation of a bundle by retrieving the necessary tools from the toolboxes.
     * In this case we will need the software pack, the test tools and the packaging.
     * 
     * @param computer the computer to pack
     * @return the bundle
     */
    @Override
    public Bundle test_pack(Computer computer) {
        SoftwarePack softwarePack = softwarePackToolbox.getTool();
        TestTools testTools = testToolbox.getTool();
        Packaging packaging = packagingToolbox.getTool();
        return new Bundle(computer, softwarePack, testTools, packaging);
    }

    /**
     * Simulates the creation of a bundle by retrieving the necessary tools from the toolboxes.
     * In this case we will need the packaging and the software pack.
     * 
     * @param computer the computer to pack
     * @return the bundle
     */
    @Override
    public Bundle pack(Computer computer) {
        Packaging packaging = packagingToolbox.getTool();
        SoftwarePack softwarePack = softwarePackToolbox.getTool();
        return new Bundle(computer, packaging, softwarePack);
    }

    /**
     * Stores the bundle in a list, before they can be addedd to a dispatch box.
     * 
     * @param b the bundle to store
     */
    @Override
    public void enqueueForDispatch(Bundle b) throws InterruptedException {
        bundleAccumulator.add(b);
    }

    /**
     * Retrieves a sufficient number of bundles from the list to fill a dispatch box.
     * 
     * @return the dispatch box
     * @throws InterruptedException if the thread is interrupted (e.g. when sleeping or waiting for a lock)
     */
    @Override
    public DispatchBox dispatch() throws InterruptedException {
        DispatchBox box = new DispatchBox(dispatchBoxCapacity);

        // we assume there are sufficient elements in the bundleAccumulator
        for (int i = 0; i < dispatchBoxCapacity; i++) {
            Bundle b = bundleAccumulator.remove(0);
            box.add(b);
        }

        return box;
    }

    // ///////////////////////////////////////
    // MAIN METHOD FOR SEQUENTIAL SIMULATION
    // ///////////////////////////////////////
    public static void main(String[] args) {
        System.out.println("SequentialRetailer");

        SequentialRetailer retailer = 
            new SequentialRetailer(SimulationParameters.ASSEMBLY_LINE_CAPACITY,
                                    SimulationParameters.DISPATCH_BOX_CAPACITY);

        ComputerAssembler assembler = new SequentialComputerAssembler(retailer);
        Dispatcher dispatcher = new SequentialDispatcher(retailer);


        // assemble a few computers
        // let's make sure it's a multiple of the box capacity
        // and that we can create enough bundles of each type
        int boxCapacity = SimulationParameters.DISPATCH_BOX_CAPACITY;
        int numComputers = 4 * boxCapacity;

        for (int i = 0; i < numComputers; i++) {
            assembler.assembleComputer();
        }

        ComputerTechnician t1 = new SequentialPackTechnician(retailer);
        ComputerTechnician t2 = new SequentialTestPackTechnician(retailer);

        try {
            for (int i = 0; i < numComputers; i++) {
                Bundle bundle;
                if (i % 2 == 0) {
                    bundle = t1.createBundle();
                    System.out.println("PackBundle created: " + bundle);
                    t1.sendToDispatch(bundle);
                    System.out.println("PackBundle sent " + bundle + " for dispatch");
                } else {
                    bundle = t2.createBundle();
                    System.out.println("TestPackBundle created: " + bundle);
                    t2.sendToDispatch(bundle);
                    System.out.println("TestPackBundle sent " + bundle + " for dispatch");
                }

                // every "boxCapacity" iterations, we should've filled a box
                if ((i+1) % boxCapacity == 0) {
                    DispatchBox box = dispatcher.dispatchBox();
                    System.out.println("Dispatcher: " + box + " dispatched");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
