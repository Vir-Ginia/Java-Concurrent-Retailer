package uk.ac.keele.csc20004.coursework;

import java.util.concurrent.BlockingQueue;
import uk.ac.keele.csc20004.retailer.Bundle;
import uk.ac.keele.csc20004.retailer.tools.Packaging;
import uk.ac.keele.csc20004.retailer.tools.SoftwarePack;
import uk.ac.keele.csc20004.factory.computers.Computer;

public class packtech implements Runnable {
    private final BlockingQueue<Computer> assemblyLine;
    private final BlockingQueue<Bundle> dispatchQueue;

    /**
     * 
     * @param assemblyLine blocking queue for assembled computers
     * @param dispatchQueue blocking queue for packed bundles
     */

    public packtech (BlockingQueue<Computer> assemblyLine, BlockingQueue<Bundle> dispatchQueue) {
        this.assemblyLine = assemblyLine;
        this.dispatchQueue = dispatchQueue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Computer computer = assemblyLine.take();
                Thread.sleep(SimulationParameters.PACKAGE_TIME);
                SoftwarePack software = new SoftwarePack();
                Packaging packaging = new Packaging();
                Bundle bund = new Bundle(computer, packaging, software);
                dispatchQueue.put(bund);
                System.out.println("packtech packaged " + computer);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
