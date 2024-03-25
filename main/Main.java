package main;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        final String COLOR = "\u001b[36m";
        final String RESET = "\u001b[0m";
        
        Scanner scnr = new Scanner(System.in);
        boolean run = true;
        int choice;
        double[][] matrix, matrix2, mSolution;
        double[] vSolution;

        System.out.println(COLOR);
        printBanner();

        while (run) {
            printMenu();

            choice = scnr.nextInt();
            Operations op = new Operations();

            switch(choice) {
                case 1:
                    System.out.println("\nYou chose to add two matrices.");

                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 2:
                    System.out.println("\nYou chose to subtract two matrices.");

                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 3:
                    System.out.println("\nYou chose to multiply two matrices.");

                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.multiply(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 4:
                    System.out.println("\nYou chose to solve a system of linear equations using Gaussian Elimination.");

                    System.out.println("Enter the dimensions of the augmented matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    

                    vSolution = op.rowReduce(matrix);
                    System.out.println("\nSolution (NaN means Infinite Solutions):");
                    op.displayVector(vSolution);

                    break;
                case 5:
                    System.out.println("\nYou chose to find the determinant of a matrix.");

                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    double determinant = op.determinant(matrix);

                    System.out.print("\nSolution: ");
                    System.out.println(determinant);
                    break;
                case 6:
                    System.out.println("\nYou chose to find the transpose of a matrix.");
                    
                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    // solution = firstMatrix.transpose();

                    System.out.println("\nSolution:");
                    // solution.display();
                    break;
                case 7:
                    System.out.println("\nYou chose to find the inverse of a matrix.");
                                        
                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    // solution = firstMatrix.inverse();

                    System.out.println("\nSolution:");
                    // solution.display();
                    break;
                case 8:
                    System.out.println("\nYou chose to determine if a matrix is linearly independent.");
                                        
                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    // solution = firstMatrix.dependence();

                    System.out.println("\nSolution:");
                    // solution.display();
                    break;
                case 9:
                    System.out.println("\nYou chose to find the basis of a matrix.");
                                        
                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    // solution = firstMatrix.basis();

                    System.out.println("\nSolution:");
                    // solution.display();
                    break;
                case 0:
                    System.out.println("\nExiting Matrify. Goodbye!" + RESET);
                    run = false;
                    scnr.close();
                    break;
            }
        }
      
    }

    public static void printBanner() {
        String filePath = "main/banner.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("\n---------------------------------------------------------------------------------------\n" +
                                "Welcome to Matrify, a linear algebra calculator used to perform operations on matrices.\n" +
                                "---------------------------------------------------------------------------------------\n");
        } catch (IOException e) {
            System.err.println("Failed to read banner.txt: " + e.getMessage());
        }
    }

    public static void printMenu() {
        System.out.print("============= Menu =============\n\n" +
                            "\t1 : ADD\n" +
                            "\t2 : SUBTRACT\n" +
                            "\t3 : MULTIPLY\n" +
                            "\t4 : GAUSSIAN ELIMINATION\n" +
                            "\t5 : DETERMINANT\n" +
                            "\t6 : TRANSPOSE\n" +
                            "\t7 : INVERSE\n" +
                            "\t8 : LINEAR DEPENDENCE\n" +
                            "\t9 : FIND BASIS\n" +
                            "\t0 : EXIT\n\n" +
                            "================================\n" +
                            "Enter your choice: ");
    }

    public static double[][] setMatrix(Scanner scnr) {

        int row = scnr.nextInt();
        int col = scnr.nextInt();
        double[][] matrix = new double[row][col];

        System.out.println("Enter the elements, row by row, seperated by a space: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                double value = scnr.nextDouble();
                matrix[i][j] = value;
            }
        }

        return matrix;
    }
    
}