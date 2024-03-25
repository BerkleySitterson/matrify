package main;

public class Operations {

    public double[][] add(double[][] A, double[][] B) {

        int rows = A.length;
        int cols = A[0].length;

        if (rows != B.length || cols != B[0].length) {
            System.out.println("Matrices must have the same dimensions to add.");
        }

        double[][] solution = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                solution[i][j] = A[i][j] + B[i][j];
            }
        }
        return solution;
    }

    public double[][] subtract(double[][] A, double[][] B) {

        int rows = A.length;
        int cols = A[0].length;

        if (rows != B.length || cols != B[0].length) {
            System.out.println("Matrices must have the same dimensions to subtract.");
        }

        double[][] solution = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                solution[i][j] = A[i][j] - B[i][j];
            }
        }
        return solution;
    }

    public double[][] multiply(double[][] A, double[][] B) {
        if (A[0].length != B.length) {
            System.out.println("The number of columns in the first matrix must be equal to the number of rows in the second matrix to multiply.");
        }

        double[][] solution = new double[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < A[0].length; k++) {
                    sum += A[i][k] * B[k][j];
                }
                solution[i][j] = sum;
            }
        }
        return solution;
    }
     
    public double[] rowReduce(double[][] A) {

        double[] B = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i][A.length];
        }

        int N = B.length;
        for (int k = 0; k < N; k++) 
        {
            /** find pivot row **/
            int max = k;
            for (int i = k + 1; i < N; i++) 
                if (Math.abs(A[i][k]) > Math.abs(A[max][k])) 
                    max = i;
 
            /** swap row in A matrix **/    
            double[] temp = A[k]; 
            A[k] = A[max]; 
            A[max] = temp;
 
            /** swap corresponding values in constants matrix **/
            double t = B[k]; 
            B[k] = B[max]; 
            B[max] = t;
 
            /** pivot within A and B **/
            for (int i = k + 1; i < N; i++) 
            {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++) 
                    A[i][j] -= factor * A[k][j];
            }

             /* Using back substitution to find unknown variables*/
            double[] solution = new double[N];
            for (int i = N - 1; i >= 0; i--) {
                double sum = 0.0;
                for (int j = i + 1; j < N; j++) 
                    sum += A[i][j] * solution[j];
                solution[i] = (B[i] - sum) / A[i][i];
            }        
        }
 
        /* Using back substitution to find unknown variables*/
        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--) 
        {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) 
                sum += A[i][j] * solution[j];
            solution[i] = (B[i] - sum) / A[i][i];
        }
        return solution;
    }
     
     
    public static void backSubstitute(double[][] A, int n, double[] x) {
        for (int i = n-1; i >= 0; i--) {
            double sum = 0;
            for (int j = i+1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (A[i][n] - sum) / A[i][i];
        }
    }

    public double determinant(double[][] A) {
        double[][] temp;
        double det = 0;

        if (A.length == 0) {
            det = A[0][0];
            return det;
        }

        if (A.length == 2) {
            det = ((A[0][0] * A[1][1]) - (A[0][1] * A[1][0]));
            return det;
        }

        for (int i = 0; i < A[0].length; i++) {
            temp = new double[A.length - 1][A[0].length - 1];

            for (int j = 1; j < A.length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    if (k < i) {
                        temp[j - 1][k] = A[j][k];
                    } else if (k > i) {
                        temp[j - 1][k - 1] = A[j][k];
                    }
                }
            }
            det += A[0][i] * Math.pow(-1, (double) i) * determinant(temp);
        }
        return det;
    }

    public void displayMatrix(double[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[  ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }            
            System.out.print("]\n");            
        }
        System.out.println();
    }

    public void displayVector(double[] solution)
    {
        for (int i = 0; i < solution.length; i++) {
            System.out.print("[  ");
            System.out.printf("%.2f", solution[i]);
            System.out.print(" ]\n");            
        }
        System.out.println();    
    }    

}
