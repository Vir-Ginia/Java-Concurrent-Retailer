/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

/**
 * Interface defining what is meant by "networked device" in the context of 
 * the coursework. A networked device is characterised by having a number of 
 * network interfaces.
 * By implementing this interface, a class will need to provide a method to
 * get the number of network interfaces of the device.
 * 
 * @author marcoortolani
 */
public interface NetworkedDevice {
    /**
     * Get the number of network interfaces of the device.
     * @return the number of network interfaces of the device.
     */
    public int getNumInterfaces();
}
