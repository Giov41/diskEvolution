package edu.asu.sese.diskEvolution;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ViscosityGridTest {
    ViscosityGrid grid;
    RadialGrid radialGrid;
    int zoneCount = 100;
    
    @Before
    public void setup() { 
        double rmin = 0.1 * PhysicalConstants.auInCm;
        double rmax = 40.0 * PhysicalConstants.auInCm;
        double deltar0 = 0.01 * PhysicalConstants.auInCm;
        radialGrid = new RadialGrid(rmin, rmax, deltar0, zoneCount);
        grid = new ViscosityGrid(radialGrid);
    }
    
    @Test
    public void testGridSize() {
        assertEquals(zoneCount, grid.getCount());
    }
    
    @Test
    public void testGetValue() {
        assertEquals(0.0, grid.getValue(1), 1e-14);
    }

    
    @Test
    public void testInitialization() {
        grid.initializeWithPowerLaw(1.0e12, PhysicalConstants.auInCm, 1.0);
        double rcheck = Math.sqrt(0.1 * 0.11);
        double expected = 1.0e12 * rcheck;
        assertEquals(expected, grid.getValue(0), 1e-3);
    }
}
