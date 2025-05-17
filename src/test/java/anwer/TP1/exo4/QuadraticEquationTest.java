package anwer.TP1.exo4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuadraticEquationTest {
    
    @Test
    public void testTwoRealRoots() {
        double[] roots = QuadraticEquation.solve(1, -3, 2);
        assertNotNull(roots);
        assertEquals(2, roots.length);
        assertArrayEquals(new double[]{2.0, 1.0}, roots, 0.0001);
    }
    
    @Test
    public void testOneRealRoot() {
        double[] roots = QuadraticEquation.solve(1, -2, 1);
        assertNotNull(roots);
        assertEquals(1, roots.length);
        assertArrayEquals(new double[]{1.0}, roots, 0.0001);
    }
    
    @Test
    public void testNoRealRoots() {
        double[] roots = QuadraticEquation.solve(1, 1, 1);
        assertNull(roots);
    }
    
    @Test
    public void testLinearEquation() {
        double[] roots = QuadraticEquation.solve(0, 2, -4);
        assertNotNull(roots);
        assertEquals(1, roots.length);
        assertArrayEquals(new double[]{2.0}, roots, 0.0001);
    }
    
    @Test
    public void testConstantEquation() {
        double[] roots = QuadraticEquation.solve(0, 0, 5);
        assertNull(roots);
    }
} 