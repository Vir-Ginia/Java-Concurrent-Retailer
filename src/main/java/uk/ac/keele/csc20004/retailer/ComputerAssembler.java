/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.retailer;

import java.util.Random;

import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.factory.computers.Laptop;
import uk.ac.keele.csc20004.factory.computers.Server;
import uk.ac.keele.csc20004.factory.computers.Tablet;
import uk.ac.keele.csc20004.factory.hardware.Battery;
import uk.ac.keele.csc20004.factory.hardware.CPU;
import uk.ac.keele.csc20004.factory.hardware.GPU;
import uk.ac.keele.csc20004.factory.hardware.HardDrive;
import uk.ac.keele.csc20004.factory.hardware.NetworkCard;
import uk.ac.keele.csc20004.factory.hardware.RAM;
import uk.ac.keele.csc20004.factory.hardware.SSD;

/**
 * An abstract class partially implementing the computer assembler.
 * The assembler takes care of creating a computer from its parts.
 * 
 * @author marcoortolani
 */
public abstract class ComputerAssembler {
    // Constant for the maximum serial number
    protected static final int MAX_SERIAL = 10000;

    // The size to be used when refilling the hardware racks
    protected static final int HARDWARE_RACK_SIZE = 10;
    // The number of computers to be produced for delivery
    protected static final int DELIVERY_LINE_MIN_SIZE = 10;

    // The maximum price for each hardware part
    protected static final double MAX_CPU_PRICE = 500.0;
    protected static final double MAX_RAM_PRICE = 100.0;
    protected static final double MAX_HDD_PRICE = 300.0;
    protected static final double MAX_SSD_PRICE = 250.0;
    protected static final double MAX_NIC_PRICE = 80.0;
    protected static final double MAX_GPU_PRICE = 1000.0;
    protected static final double MAX_BATTERY_PRICE = 150.0;

    // Serial numbers for the hardware parts
    private int serialCPU = 0;
    private int serialRAM = 0;
    private int serialHDD = 0;
    private int serialNIC = 0;
    private int serialSSD = 0;
    private int serialGPU = 0;
    private int serialBattery = 0;

    private final Random rnd;

    protected final ComputerRetailer retailer;

    /**
     * The constructor initialises the assembler with the retailer.
     * 
     * @param retailer the retailer to which the computer will be delivered
     */
    public ComputerAssembler(ComputerRetailer retailer) {
        this.retailer = retailer;

        rnd = new Random();
    }

    /**
     * The method to simulate the assembly of a computer and deliver it to the assembly line of the retailer.
     * The method is abstract and must be implemented by the concrete classes.
     */
    public abstract void assembleComputer();

    /**
     * A convenience method to produce a random computer, complete with all its parts.
     * 
     * @return a random computer
     */
    protected Computer produceRandomComputer() {
        int choice = rnd.nextInt(3);

        Computer computer = null;

        switch (choice) {
            case 0: { // laptop
                CPU cpu = createCPU();
                RAM ram = createRAM();
                HardDrive hdd = createHardDrive();
                Battery b = createBattery();

                computer = new Laptop(cpu, ram, hdd, b);

            }
                break;
            case 1: { // tablet
                CPU cpu = createCPU();
                RAM ram = createRAM();
                SSD ssd = createSSD();
                Battery b = createBattery();

                computer = new Tablet(cpu, ram, ssd, b);
            }
                break;
            case 2: // server
            default: {
                CPU cpu = createCPU();
                GPU gpu = createGPU();
                RAM ram1 = createRAM();
                RAM ram2 = createRAM();
                HardDrive hdd = createHardDrive();

                computer = new Server(cpu, gpu, ram1, ram2, hdd);
            }
                break;
        }

        return computer;
    }

    /**
     * Creates a new CPU with a random price, energy footprint, and benchmark score.
     * 
     * @return a new CPU
     */
    protected CPU createCPU() {
        serialCPU = ++serialCPU % MAX_SERIAL;

        double price = rnd.nextDouble() * MAX_CPU_PRICE;
        double energyFootprint = rnd.nextDouble() * 100;
        double benchmarkScore = rnd.nextDouble() * 100;

        double speed = 1.0 + rnd.nextDouble() * 2.0; // [1.0, 3.0)

        return new CPU(serialCPU, price, energyFootprint, benchmarkScore, speed);
    }

    /** Creates a new RAM with a random price, energy footprint, and benchmark score.
     * 
     * @return a new RAM
     */
    protected RAM createRAM() {
        serialRAM = ++serialRAM % MAX_SERIAL;

        double price = rnd.nextDouble() * MAX_RAM_PRICE;
        double energyFootprint = rnd.nextDouble() * 100;
        double benchmarkScore = rnd.nextDouble() * 100;

        int index = rnd.nextInt(3) + 3; // 3, 4, 5
        int size = (int) Math.pow(2, index); // 8, 16, 32 GB

        return new RAM(serialRAM, price, energyFootprint, benchmarkScore, size);
    }

    /** Creates a new HardDrive with a random price, energy footprint, and benchmark score.
     * 
     * @return a new HardDrive
     */
    protected HardDrive createHardDrive() {
        serialHDD = ++serialHDD % MAX_SERIAL;

        double price = rnd.nextDouble() * MAX_HDD_PRICE;
        double energyFootprint = rnd.nextDouble() * 100;
        double benchmarkScore = rnd.nextDouble() * 100;

        int index = 1 + rnd.nextInt(4); // 1, 2, 3, 4
        int size = 512 * index; // 512 GB, 1, 1.5, 2 TB

        return new HardDrive(serialHDD, price, energyFootprint, benchmarkScore, size);
    }

    /** Creates a new NetworkCard with a random price, energy footprint, and benchmark score.
     * 
     * @return a new NetworkCard
     */
    protected NetworkCard createNetworkCard() {
        serialNIC = ++serialNIC % MAX_SERIAL;

        double price = rnd.nextDouble() * MAX_NIC_PRICE;
        double energyFootprint = rnd.nextDouble() * 100;
        double benchmarkScore = rnd.nextDouble() * 100;

        boolean wifi = rnd.nextBoolean();

        return new NetworkCard(serialNIC, price, energyFootprint, benchmarkScore, wifi);
    }

    /** Creates a new SSD with a random price, energy footprint, and benchmark score.
     * 
     * @return a new SSD
     */
    protected SSD createSSD() {
        serialSSD = ++serialSSD % MAX_SERIAL;

        double price = rnd.nextDouble() * MAX_SSD_PRICE;
        double energyFootprint = rnd.nextDouble() * 100;
        double benchmarkScore = rnd.nextDouble() * 100;

        int index = 1 + rnd.nextInt(4); // 1, 2, 3, 4,
        int size = 256 * index; // 256GB, 512 GB, 1, 1.5 TB

        return new SSD(serialSSD, price, energyFootprint, benchmarkScore, size);
    }

    /** Creates a new GPU with a random price, energy footprint, and benchmark score.
     * 
     * @return a new GPU
     */
    protected GPU createGPU() {
        serialGPU = ++serialGPU % MAX_SERIAL;

        double price = rnd.nextDouble() * MAX_GPU_PRICE;
        double energyFootprint = rnd.nextDouble() * 100;
        double benchmarkScore = rnd.nextDouble() * 100;

        int index = rnd.nextInt(3) + 3; // 3, 4, 5
        int mem = (int) Math.pow(2, index); // 8, 16, 32 GB

        return new GPU(serialGPU, price, energyFootprint, benchmarkScore, mem);
    }

    /** Creates a new Battery with a random price, energy footprint, and benchmark score.
     * 
     * @return a new Battery
     */
    protected Battery createBattery() {
        serialBattery = ++serialBattery % MAX_SERIAL;

        double price = rnd.nextDouble() * MAX_BATTERY_PRICE;
        double energyFootprint = rnd.nextDouble() * 100;
        double benchmarkScore = rnd.nextDouble() * 100;

        int cyclelife = rnd.nextInt(900) + 100; // [100, 1000]

        return new Battery(serialBattery, price, energyFootprint, benchmarkScore, cyclelife);
    }
    

}
