/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

/**
 * Interface defining what is meant by "high performance device" in the context of 
 * the coursework. A high performamce device is characterised by having an additional 
 * number of CPU cores.
 * By implementing this interface, a class will need to provide a method to
 * get the number of cpu cores of the device.
 * 
 * @author marcoortolani
 */

public interface HighPerformanceDevice {
    /**
     * Get the number of CPU cores of the device.
     * 
     * @return the number of CPU cores of the device.
     */
    public int getNumCores();
}
