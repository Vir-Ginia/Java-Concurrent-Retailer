package uk.ac.keele.csc20004.coursework;

import java.util.concurrent.BlockingQueue;
import uk.ac.keele.csc20004.retailer.Bundle;
import uk.ac.keele.csc20004.retailer.DispatchBox;

public class dispatch implements Runnable {
    private final BlockingQueue<Bundle> dispatchQueue;
    private int bundleCount = 0;

    /**
     * 
     * @param dispatchQueue the queue that takes bundles to dispatch
     */
    public dispatch (BlockingQueue<Bundle> dispatchQueue) {
        this.dispatchQueue = dispatchQueue;
    }

    @Override
    public void run() {
        DispatchBox box = new DispatchBox(SimulationParameters.DISPATCH_BOX_CAPACITY);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Bundle bund = dispatchQueue.take();
                box.add(bund);
                bundleCount++;

                if (bundleCount == SimulationParameters.DISPATCH_BOX_CAPACITY) {
                    System.out.println("dispatched box with " + bund);
                    box = new DispatchBox(SimulationParameters.DISPATCH_BOX_CAPACITY);
                    bundleCount++;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}