package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.Operations;

public class MatrixTest {

    Operations op = new Operations();

    @Test
    public void testAdd() {
        double[][] M1 = {
            {1.0, -2.0, 3.0},
            {-4.0, 5.0, -6.0},
            {7.0, -8.0, 9.0}
        };
        
        double[][] M2 = {
            {1.0, -2.0, 3.0},
            {-4.0, 5.0, -6.0},
            {7.0, -8.0, 9.0}
        };

        double[][] solution = op.add(M1, M2);

        System.out.println("---------------------------------------");
        System.out.println("***Addition Test***");
        System.out.println("Matrix 1: ");
        op.displayMatrix(M1);

        System.out.println("\nMatrix 2: ");
        op.displayMatrix(M2);

        System.out.println("\nResult: ");
        op.displayMatrix(solution);
        System.out.println("---------------------------------------\n");

        assertEquals(2, solution[0][0], 0.0001);
        assertEquals(-4, solution[0][1], 0.0001);
        assertEquals(6, solution[0][2], 0.0001);
        assertEquals(-8, solution[1][0], 0.0001);
        assertEquals(10, solution[1][1], 0.0001);
        assertEquals(-12, solution[1][2], 0.0001);
        assertEquals(14, solution[2][0], 0.0001);
        assertEquals(-16, solution[2][1], 0.0001);
        assertEquals(18, solution[2][2], 0.0001);
    }

    @Test
    public void testSubtract() {
        double[][] M1 = {
            {1, -2, 3},
            {-4, 5, -6},
            {7, -8, 9}
        };

        double[][] M2 = {
            {-1, 2, -3},
            {4, -5, 6},
            {-7, 8, -9}
        };

        double[][] solution = op.subtract(M1, M2);

        System.out.println("---------------------------------------");
        System.out.println("***Subtract Test***");
        System.out.println("Matrix 1: ");
        op.displayMatrix(M1);

        System.out.println("\nMatrix 2: ");
        op.displayMatrix(M2);

        System.out.println("\nResult: ");
        op.displayMatrix(solution);
        System.out.println("---------------------------------------\n");

        assertEquals(2, solution[0][0], 0.0001);
        assertEquals(-4, solution[0][1], 0.0001);
        assertEquals(6, solution[0][2], 0.0001);
        assertEquals(-8, solution[1][0], 0.0001);
        assertEquals(10, solution[1][1], 0.0001);
        assertEquals(-12, solution[1][2], 0.0001);
        assertEquals(14, solution[2][0], 0.0001);
        assertEquals(-16, solution[2][1], 0.0001);
        assertEquals(18, solution[2][2], 0.0001);
    }

    @Test
    public void testMultiply() {
        double[][] M1 = {
            {1, -2, 3},
            {-4, 5, -6},
            {7, -8, 9}
        };

        double[][] M2 = {
            {-1, 2, -3},
            {4, -5, 6},
            {-7, 8, -9}
        };

        double[][] solution = op.multiply(M1, M2);

        System.out.println("---------------------------------------");
        System.out.println("***Multiply Test***");
        System.out.println("Matrix 1: ");
        op.displayMatrix(M1);

        System.out.println("\nMatrix 2: ");
        op.displayMatrix(M2);

        System.out.println("\nResult: ");
        op.displayMatrix(solution);
        System.out.println("---------------------------------------\n");

        assertEquals(-30, solution[0][0], 0.0001);
        assertEquals(36, solution[0][1], 0.0001);
        assertEquals(-42, solution[0][2], 0.0001);
        assertEquals(66, solution[1][0], 0.0001);
        assertEquals(-81, solution[1][1], 0.0001);
        assertEquals(96, solution[1][2], 0.0001);
        assertEquals(-102, solution[2][0], 0.0001);
        assertEquals(126, solution[2][1], 0.0001);
        assertEquals(-150, solution[2][2], 0.0001);
    }

    @Test
    public void testRREF() {
        double[][] matrix = {
            {1.0, 9.0, -5.0, -32.0},
            {-3.0, -5.0, -5.0, -10.0},
            {-2.0, -7.0, 1.0, 13.0}
        };

        double[] solution = op.rowReduce(matrix);

        System.out.println("---------------------------------------");
        System.out.println("***RREF Test***");
        System.out.println("Matrix: ");
        op.displayMatrix(matrix);

        System.out.println("\nResult: ");
        op.displayVector(solution);
        System.out.println("---------------------------------------\n");

        assertEquals(5, solution[0], 0.0001);
        assertEquals(-3, solution[1], 0.0001);
        assertEquals(2, solution[2], 0.0001);
    }

    @Test
    public void testDeterminant() {
        double [][] matrix = {
            {0.0, 3.0, 5.0},
            {5.0, 5.0, 2.0},
            {3.0, 4.0, 3.0}
        };

        double det = op.determinant(matrix);

        System.out.println("---------------------------------------");
        System.out.println("***Determinant Test***");
        System.out.println("Matrix: ");
        op.displayMatrix(matrix);

        System.out.println("\nResult: ");
        System.out.println(det);
        System.out.println("---------------------------------------\n");

        assertEquals(-2, det, 0.0001);
    }
}
