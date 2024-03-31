package main;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        final String COLOR = "\u001b[36m";
        final String RESET = "\u001b[0m";
        
        Map<String, String> questions = new HashMap<>();
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
                case 0:
                    System.out.println("Would you like to save these questions/answers in a text file? (Y/N)");
                    scnr.nextLine();
                    String save = scnr.nextLine();

                    if (save.equalsIgnoreCase("y")) {
                        exportToMarkdown(questions);
                    } 

                    System.out.println("\nExiting Matrify. Goodbye!" + RESET);
                    run = false;
                    scnr.close();
                    break;
                case 1:
                    System.out.println("\nYou chose to add two matrices.");

                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    System.out.println(op.displayMatrix(mSolution));

                    questions.put(op.displayMatrix(matrix) + " + \n\n" + op.displayMatrix(matrix2) + " = \n\n", op.displayMatrix(mSolution));

                    break;
                case 2:
                    System.out.println("\nYou chose to subtract two matrices.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.subtract(matrix, matrix2);

                    System.out.println("\nSolution:");
                    System.out.println(op.displayMatrix(mSolution));

                    questions.put(op.displayMatrix(matrix) + " - \n\n" + op.displayMatrix(matrix2) + " = \n\n", op.displayMatrix(mSolution));

                    break;
                case 3:
                    System.out.println("\nYou chose to multiply two matrices.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.multiply(matrix, matrix2);

                    System.out.println("\nSolution:");
                    System.out.println(op.displayMatrix(mSolution));

                    questions.put(op.displayMatrix(matrix) + " x \n\n" + op.displayMatrix(matrix2) + " = \n\n", op.displayMatrix(mSolution));

                    break;
                case 4:
                    System.out.println("You chose to find the determinant of a matrix.");
                    
                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    double determinant = op.determinant(matrix);

                    System.out.println("\nSolution:");
                    System.out.println(determinant);
                    String det = Double.toString(determinant);

                    questions.put(op.displayMatrix(matrix) + "\nDeterminant = \n\n", det + "\n\n");

                    break;
                case 5:
                    System.out.println("\nYou chose to find the transpose of a matrix.");
                    
                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    mSolution = op.transpose(matrix);

                    System.out.println("\nSolution:");
                    System.out.println(op.displayMatrix(mSolution));

                    questions.put(op.displayMatrix(matrix) + "\nTranspose = \n\n", op.displayMatrix(mSolution));

                    break;
                case 6:
                    System.out.println("\nYou chose to find the cofactor of a matrix.");
                    
                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    double[][] cofactor = new double[matrix.length][matrix[0].length];

                    for(int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[0].length; j++) {
                            cofactor[i][j] = op.getCofactor(matrix, i, j);
                        }
                    }

                    System.out.println("\nSolution:");
                    System.out.println(op.displayMatrix(cofactor));

                    questions.put(op.displayMatrix(matrix) + "\nCofactor Matrix = \n\n", op.displayMatrix(cofactor));

                    break;
                case 7:
                    System.out.println("\nYou chose to find the adjoint of a matrix.");
                    
                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    mSolution = op.getAdjoint(matrix);

                    System.out.println("\nSolution:");
                    System.out.println(op.displayMatrix(mSolution));

                    questions.put(op.displayMatrix(matrix) + "\nAdjoint Matrix = \n\n", op.displayMatrix(mSolution));

                    break;
                case 8:
                    System.out.println("\nYou chose to find the inverse of a matrix.");
                    
                    System.out.println("Enter the dimensions of the matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    mSolution = op.inverse(matrix);

                    System.out.println("\nSolution:");
                    System.out.println(op.displayMatrix(mSolution));

                    questions.put(op.displayMatrix(matrix) + "\nInverse = \n\n", op.displayMatrix(mSolution));

                    break;
                case 9:
                    System.out.println("\nYou chose to find the basis of a matrix.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 10:
                    System.out.println("\nYou chose to find the rank of a matrix.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 11:
                    System.out.println("\nYou chose to find the trace of a matrix.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 12:
                    System.out.println("\nYou chose to find the null space of a matrix.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 13:
                    System.out.println("\nYou chose to find the column space of a matrix.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 14:
                    System.out.println("\nYou chose to find the row space of a matrix.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 15:
                    System.out.println("\nYou chose to solve a system of linear equations using Gaussian Elimination.");
                    
                    System.out.println("Enter the dimensions of the augmented matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);

                    vSolution = op.gaussianElim(matrix);

                    System.out.println("\nSolution:");
                    op.displayVector(vSolution);

                    break;
                case 16:
                    System.out.println("\nYou chose to determine if a set of vectors is linearly dependent.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 17:
                    System.out.println("\nYou chose to find the eigenvalues of a matrix.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 18:
                    System.out.println("\nYou chose to find the eigenvectors of a matrix.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                case 19:
                    System.out.println("\nYou chose to perform Singular Value Decomposition (SVD) on a matrix.");
                    
                    System.out.println("Enter the dimensions of the first matrix, seperated by a space: ");
                    matrix = setMatrix(scnr);
                    System.out.println("Enter the dimensions of the second matrix, seperated by a space: ");
                    matrix2 = setMatrix(scnr);

                    mSolution = op.add(matrix, matrix2);

                    System.out.println("\nSolution:");
                    op.displayMatrix(mSolution);

                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                
                    
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
        } catch (IOException e) {
            System.err.println("Failed to read banner.txt: " + e.getMessage());
        }
    }

    public static void printMenu() {
        System.out.print("\n========================= Menu =========================\n\n" +
        "        0 : EXIT                 10 : RANK\n" +
        "        1 : ADD                  11 : TRACE\n" +
        "        2 : SUBTRACT             12 : NULL SPACE\n" +
        "        3 : MULTIPLY             13 : COLUMN SPACE\n" +
        "        4 : DETERMINANT          14 : ROW SPACE\n" +
        "        5 : TRANSPOSE            15 : GAUSSIAN ELIMINATION\n" +
        "        6 : COFACTOR             16 : LINEAR DEPENDENCE\n" +
        "        7 : ADJOINT              17 : EIGENVALUE\n" +
        "        8 : INVERSE              18 : EIGENVECTOR\n" +
        "        9 : BASIS                19 : SVD\n\n" +
        "========================================================\n" +
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

    public static void exportToMarkdown(Map<String, String> questions) {

        LocalDate currDate = LocalDate.now();
        String formattedDate = currDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String fileName = "review_" + formattedDate + ".md";
        String filePath = "./output/" + fileName;
        int questionNum = 1;

        try (FileWriter writer = new FileWriter(filePath)) {

            for (Map.Entry<String, String> entry : questions.entrySet()) {
                String question = entry.getKey();
                String answer = entry.getValue();
            
                writer.write("## Question #" + questionNum + "\n");
                writer.write("```\n");
                writer.write(question);
                writer.write(answer);
                writer.write("```\n");
    
                questionNum++;
            }
            writer.close();
            System.out.println("Questions and Answers have been saved as '" + fileName + "' located in the output folder.");
        } catch (IOException e) {
            System.err.println("An error has occurred while saving data to the text file: " + e);
            e.printStackTrace();
        }
    }
    
}