package uk.ac.keele.csc20004.coursework;

import uk.ac.keele.csc20004.retailer.AbstractComputerRetailer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.retailer.Bundle;
import uk.ac.keele.csc20004.retailer.DispatchBox;
import uk.ac.keele.csc20004.retailer.tools.Packaging;
import uk.ac.keele.csc20004.retailer.tools.SoftwarePack;
import uk.ac.keele.csc20004.retailer.tools.TestTools;

public class MyComputerRetailer extends AbstractComputerRetailer {
    private final BlockingQueue<Computer> assemblyLine;
    private final BlockingQueue<Bundle> dispatchQueue;

    /**
     * 
     * @param assemblyLineCapacity max number of computers the assemblyline holds
     * @param dispatchBoxCapacity max number of bundles the dispatch box holds
     */

    public MyComputerRetailer(int assemblyLineCapacity, int dispatchBoxCapacity) {
        super(assemblyLineCapacity, dispatchBoxCapacity);
        assemblyLine = new ArrayBlockingQueue<>(assemblyLineCapacity);
        dispatchQueue = new ArrayBlockingQueue<>(dispatchBoxCapacity);
    }

    /**
     * @param computer the computer contains on the assemblyline
     * @throws InterruptedException throws if thread is interrupted
     */
    @Override
    public void storeAssembledComputer(Computer computer) throws InterruptedException {
        assemblyLine.put(computer);
        System.out.println("contains " + computer);
    }

    /**
     * @param computer the computer fetched from the assemblyline
     * @throws InterruptedException throws if thread is interrupted
     */
    @Override
    public Computer getAssembledComputer() throws InterruptedException {
        Computer computer = assemblyLine.take();
        System.out.println("fetching " + computer);
        return computer;
    }

    /**
     * @param computer tested and packed
     * @return the bundle 
     * @throws InterruptedException throws if thread is interrupted
     */
    @Override
    public Bundle test_pack(Computer computer) throws InterruptedException {
        Thread.sleep(SimulationParameters.TEST_TIME + SimulationParameters.PACKAGE_TIME);
        SoftwarePack softwaretool = new SoftwarePack();
        TestTools testtools = new TestTools();
        Packaging pack = new Packaging();
        Bundle bundle = new Bundle(computer, softwaretool, testtools, pack);
        return bundle;
    }

    /**
     * @param computer computer packed
     * @return the bundle
     * @throws InterruptedException
     */
    @Override
    public Bundle pack(Computer computer) throws InterruptedException {
        Thread.sleep(SimulationParameters.PACKAGE_TIME);
        SoftwarePack softwaretool = new SoftwarePack();
        Packaging pack = new Packaging();
        Bundle bundle = new Bundle(computer, pack, softwaretool);
        return bundle;
    }

    /**
     * @param bundle the bundle for dispatch
     * @throws InterruptedException throws if thread is interrupted
     */
    @Override
    public void enqueueForDispatch(Bundle bund) throws InterruptedException {
        dispatchQueue.put(bund);
        System.out.println("bundle queue for dispatch: " + bund);
    }

    /**
     * @return dispatch box 
     * @throws InterruptedException throws if thread is interrupted
     */
    @Override
    public DispatchBox dispatch() throws InterruptedException {
        DispatchBox box = new DispatchBox(dispatchBoxCapacity);
        for (int i = 0; i < dispatchBoxCapacity; i++) {
            Bundle bund = dispatchQueue.take();
            box.add(bund);
        }
        return box;
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        MyComputerRetailer retailer = new MyComputerRetailer(SimulationParameters.ASSEMBLY_LINE_CAPACITY,
                SimulationParameters.DISPATCH_BOX_CAPACITY);
        Thread a_thread = new Thread(new concurrentassembler_(retailer, retailer.assemblyLine));
        Thread t_thread = new Thread(() -> {
            Random random = new Random();
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Computer computer = retailer.getAssembledComputer();

                    Bundle bund;
                    if (random.nextBoolean()) {
                        bund = retailer.test_pack(computer);
                        System.out.println("test and packed " + computer);
                    } else {
                        bund = retailer.pack(computer);
                        System.out.println("packed " + computer);
                    }
                    retailer.enqueueForDispatch(bund);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread d_thread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    DispatchBox box = retailer.dispatch();
                    System.out.println(box + " dispatched");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        a_thread.start();
        t_thread.start();
        d_thread.start();

    }
}
