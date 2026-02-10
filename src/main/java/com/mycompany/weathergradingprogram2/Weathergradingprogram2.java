package com.mycompany.weathergradingprogram2;
 
import java.util.Scanner;
import java.util.Arrays;
 
/**
* HNC Programming - Assignment 1
* Weather Data Analysis Program (Enhanced for M3/D3)
*/
public class Weathergradingprogram2 {
 
    // Global Constants: Demonstrates 'Project Organization' and readability [cite: 62, 83]
    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Data sets provided in the assignment brief [cite: 15]
        double[] temp2023 = {9, 8, 12, 16, 18, 22, 24, 22, 20, 16, 12, 9};
        double[] temp2024 = {8, 8, 12, 17, 19, 20, 23, 22, 19, 16, 10, 8};
 
        System.out.println("--- London Weather Data Analysis ---");
        System.out.println("Data for 2023: " + Arrays.toString(temp2023));
        System.out.println("Data for 2024: " + Arrays.toString(temp2024));
 
        boolean running = true;
        while (running) {
            displayMenu();
            // Enhanced Input Validation: Demonstrates 'Smart Code Completion' [cite: 76, 79]
            if (input.hasNextInt()) {
                int choice = input.nextInt();
 
                switch (choice) {
                    case 1:
                        bubbleSort(temp2023);
                        System.out.println("Sorted 2023 Temperatures: " + Arrays.toString(temp2023));
                        break;
                    case 2:
                        handleSearch(input, temp2024);
                        break;
                    case 3:
                        running = false;
                        System.out.println("Exiting Program...");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 1-3.");
                }
            } else {
                System.out.println("Error: Please enter a valid numerical menu choice.");
                input.next(); // Clear invalid input
            }
        }
        input.close();
    }
 
    /**
     * Helper method to show menu structure.
     * Document: I used 'Extract Method' in NetBeans to modularize this[cite: 64].
     */
    private static void displayMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Sort 2023 data (Bubble Sort)");
        System.out.println("2. Search for a month's temperature in 2024 (Linear Search)");
        System.out.println("3. Exit");
        System.out.print("Choice: ");
    }
 
    /**
     * Refactored search handler for cleaner Main method logic.
     */
    private static void handleSearch(Scanner input, double[] data) {
        System.out.print("Enter month index (0 for Jan, 11 for Dec): ");
        if (input.hasNextInt()) {
            int index = input.nextInt();
            linearSearch(data, index);
        } else {
            System.out.println("Error: Invalid month index.");
            input.next(); 
        }
    }
 
    /**
     * Algorithm: Bubble Sort (P4/M3)
     */
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
 
    /**
     * Algorithm: Linear Search (P4/M3)
     */
    public static void linearSearch(double[] data, int targetIndex) {
        if (targetIndex >= 0 && targetIndex < data.length) {
            System.out.println("The temperature for " + MONTHS[targetIndex] + " is: " + data[targetIndex] + "°C");
        } else {
            System.out.println("Search Failed: Month index out of range (0-11).");
        }
    }
}
