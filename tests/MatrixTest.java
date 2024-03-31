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

        double[][] expectedSolution = {
            {2, -4, 6},
            {-8, 10, -12},
            {14, -16, 18}
        };

        double[][] solution = op.add(M1, M2);

        assertArrayEquals(expectedSolution, solution);
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

        double[][] expectedSolution = {
            {2, -4, 6},
            {-8, 10, -12},
            {14, -16, 18}
        };

        double[][] solution = op.subtract(M1, M2);

        assertArrayEquals(expectedSolution, solution);
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

        double[][] expectedSolution = {
            {-30, 36, -42},
            {66, -81, 96},
            {-102, 126, -150}
        };

        double[][] solution = op.multiply(M1, M2);

        assertArrayEquals(expectedSolution, solution);
    }

    @Test
    public void testGaussian() {
        double[][] matrix = {
            {1.0, 9.0, -5.0, -32.0},
            {-3.0, -5.0, -5.0, -10.0},
            {-2.0, -7.0, 1.0, 13.0}
        };

        double[] expectedSolution = {5, -3, 2};
        double[] solution = op.gaussianElim(matrix);

        assertArrayEquals(expectedSolution, solution, .00001);
    }

    @Test
    public void testDeterminant() {
        double [][] matrix = {
            {0.0, 3.0, 5.0},
            {5.0, 5.0, 2.0},
            {3.0, 4.0, 3.0}
        };

        double det = op.determinant(matrix);

        assertEquals(-2, det, 0.0001);
    }

    @Test
    public void testTranspose() {
        double[][] matrix = {
            {2, -9, 3},
            {13, 11, -17},
            {3, 6, 15},
            {4, 13, 1}
        };

        double[][] expectedTranspose = {
            {2, 13, 3, 4},
            {-9, 11, 6, 13},
            {3, -17, 15, 1}
        };

        double[][] transpose = op.transpose(matrix);

        assertArrayEquals(expectedTranspose, transpose);
    }

    @Test
    public void testCofactor() {
        double[][] matrix = {
            {5, -2, 2, 7},
            {1, 0, 0, 3},
            {-3, 1, 5, 0},
            {3, -1, -9, 4}
        };

        double[][] expectedCofactor = {
            {-12, -56, 4, 4},
            {76, 208, 4, 4},
            {-60, -82, -2, 20},
            {-36, -58, -10, 12}
        };

        double[][] cofactor = new double[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cofactor[i][j] = op.getCofactor(matrix, i, j);
            }
        }

        assertArrayEquals(expectedCofactor, cofactor);
    }

    @Test
    public void testAdjoint() {
        double[][] matrix = {
            {5, -2, 2, 7},
            {1, 0, 0, 3},
            {-3, 1, 5, 0},
            {3, -1, -9, 4}
        };

        double[][] expectedAdjoint = {
            {-12, 76, -60, -36},
            {-56, 208, -82, -58},
            {4, 4, -2, -10},
            {4, 4, 20, 12}
        };

        double[][] adjoint = op.getAdjoint(matrix);

        assertArrayEquals(expectedAdjoint, adjoint);
    }

    @Test
    public void testInverse() {
        double[][] matrix = {
            {5, -2, 2, 7},
            {1, 0, 0, 3},
            {-3, 1, 5, 0},
            {3, -1, -9, 4}
        };

        double[][] expectedInverse = {
            {-0.136, 0.864, -0.682, -0.409},
            {-0.636, 2.364, -0.932, -0.659},
            {0.045, 0.045, -0.023, -0.114},
            {0.045, 0.045, .227, .136}
        };

        double[][] inverse = op.inverse(matrix);

        assertArrayEquals(expectedInverse, inverse);
    }
}
