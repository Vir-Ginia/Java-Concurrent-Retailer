/* **********************
 * CSC-20004 COURSEWORK *
 * Component 2
 * 2023/24 First sit    *
 * **********************/
package uk.ac.keele.csc20004.coursework;

/**
 * This interface groups together the main parameters of the simulation.
 * Feel free to play with them to see how they affect the simulation.
 */
public interface SimulationParameters {
    // the max number of computer in the assembly line waiting to be bundled
    public static final int ASSEMBLY_LINE_CAPACITY = 10;

    // the number of bundles that a dispatch box contains before being dispatched
    public static final int DISPATCH_BOX_CAPACITY = 5;

    // the time it takes to assemble a computer
    public static final int ASSEMBLY_TIME = 1000;

    // the time it takes to install (or add) a software package to a computer
    public static final int SW_PACK_TIME = 500;

    // the time it takes to test a computer
    public static final int TEST_TIME = 500;

    // the time it takes to package a computer
    public static final int PACKAGE_TIME = 500;

    // use this to simulate the time it takes to dispatch a box 
    public static final int DISPATCH_TIME = 2500;
}
