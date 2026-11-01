/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

import uk.ac.keele.csc20004.factory.hardware.CPU;
import uk.ac.keele.csc20004.factory.hardware.GPU;
import uk.ac.keele.csc20004.factory.hardware.HardDrive;
import uk.ac.keele.csc20004.factory.hardware.HardwarePart;
import uk.ac.keele.csc20004.factory.hardware.RAM;

/**
 * A concrete implementation of the AbstractComputer class for a Server.
 * A Server is a computer with a CPU, a GPU, 2 RAMs, a HardDrive.
 * 
 * @author marcoortolani
 */
public class Server extends AbstractComputer {

    /**
     * Create a new Server with the given CPU, GPU, 2 RAMs and HardDrive.
     * 
     * @param cpu the CPU of the server.
     * @param gpu the GPU of the server.
     * @param ram1 the first RAM of the server.
     * @param ram2 the second RAM of the server.
     * @param hd the HardDrive of the server.
     */
    public Server(CPU cpu, GPU gpu, RAM ram1, RAM ram2, HardDrive hd) {
        super(new HardwarePart[] {cpu, gpu, ram1, ram2, hd});
    }


    /**
     * Get the model of the computer (a simple descriptive String).
     * For simplicity, the model of a Server is "Server".
     */
    @Override
    public String getModel() {
        return "Server";
    }
    
}
