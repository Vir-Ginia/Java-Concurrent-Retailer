package uk.ac.keele.csc20004.coursework;

import java.util.concurrent.BlockingQueue;
import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.retailer.ComputerAssembler;
import uk.ac.keele.csc20004.retailer.ComputerRetailer;

public class concurrentassembler_ extends ComputerAssembler implements Runnable {
    private final BlockingQueue<Computer> assemblyLine;

    /**
     * 
     * @param retailer     retailer assocuated with computer assembler
     * @param assemblyLine blocking queue where computers will take place
     */

    public concurrentassembler_(ComputerRetailer retailer, BlockingQueue<Computer> assemblyLine) {
        super(retailer);
        this.assemblyLine = assemblyLine;
    }

    /**
     * this takes computers and places them on the assembly line till the thread is
     * interrupted
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                assembleComputer();
                Thread.sleep(SimulationParameters.ASSEMBLY_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * this makes a random computer and places it onto the assembly line, if the
     * line is full the method blocks until space is available
     */
    @Override
    public void assembleComputer() {
        try {
            Computer computer = produceRandomComputer();
            assemblyLine.put(computer);
            System.out.println("assembled " + computer);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
