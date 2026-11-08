package org.example.lab2;

import java.util.Random;
import java.util.Scanner;

public class MatrixApp {

    private static final int MAX_SIZE = 20;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 100;
    private static final int MANUAL_MODE = 1;
    private static final int RANDOM_MODE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = readSize(scanner, "Введіть висоту матриці (1-" + MAX_SIZE + "): ");
        int width = readSize(scanner, "Введіть ширину матриці (1-" + MAX_SIZE + "): ");
        int[][] matrix = createMatrix(scanner, height, width);

        System.out.println("\nМатриця " + height + " x " + width + ":");
        printMatrix(matrix);
        printStatistics(matrix);
    }

    private static int[][] createMatrix(Scanner scanner, int height, int width) {
        System.out.println("Оберіть спосіб створення матриці:");
        System.out.println(MANUAL_MODE + " - ввести з клавіатури");
        System.out.println(RANDOM_MODE + " - заповнити рандомно ["
                + RANDOM_MIN + "; " + RANDOM_MAX + "]");
        int mode = readIntInRange(scanner, "Ваш вибір: ", MANUAL_MODE, RANDOM_MODE);

        if (mode == MANUAL_MODE) {
            return readMatrix(scanner, height, width);
        }
        return createRandomMatrix(height, width);
    }

    private static int[][] readMatrix(Scanner scanner, int height, int width) {
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("Елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = readInt(scanner);
            }
        }
        return matrix;
    }

    private static int[][] createRandomMatrix(int height, int width) {
        Random random = new Random();
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = RANDOM_MIN + random.nextInt(RANDOM_MAX - RANDOM_MIN + 1);
            }
        }
        return matrix;
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    private static double calculateArithmeticMean(int[][] matrix) {
        long sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }
        return (double) sum / count;
    }

    private static double calculateGeometricMean(int[][] matrix) {
        double logSum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < 0) {
                    return Double.NaN;
                }
                if (element == 0) {
                    return 0;
                }
                logSum += Math.log(element);
                count++;
            }
        }
        return Math.exp(logSum / count);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%6d", element);
            }
            System.out.println();
        }
    }

    private static void printStatistics(int[][] matrix) {
        System.out.println("\nМінімальний елемент: " + findMin(matrix));
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.printf("Середнє арифметичне: %.2f%n", calculateArithmeticMean(matrix));

        double geometricMean = calculateGeometricMean(matrix);
        if (Double.isNaN(geometricMean)) {
            System.out.println("Середнє геометричне: не визначене (є від'ємні елементи)");
        } else {
            System.out.printf("Середнє геометричне: %.2f%n", geometricMean);
        }
    }

    private static int readSize(Scanner scanner, String message) {
        return readIntInRange(scanner, message, 1, MAX_SIZE);
    }

    private static int readIntInRange(Scanner scanner, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            int value = readInt(scanner);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Значення має бути від " + min + " до " + max + ".");
        }
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Помилка! Введіть ціле число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}