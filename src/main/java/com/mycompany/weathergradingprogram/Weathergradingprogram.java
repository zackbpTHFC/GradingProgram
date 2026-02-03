/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.weathergradingprogram;

import java.util.Scanner;
import java.util.Arrays;

/**
 * HNC Programming - Unit 1
 * Weather Data Analysis Program
 * Author: [Your Student ID]
 */
public class Weathergradingprogram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Data sets provided in the assignment brief 
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        double[] temp2023 = {8, 9, 12, 16, 18, 22, 24, 22, 20, 16, 12, 9};
        double[] temp2024 = {8, 8, 12, 17, 19, 20, 23, 22, 19, 16, 10, 8};

        System.out.println("--- London Weather Data Analysis ---");
        
        // Display initial data
        System.out.println("Data for 2023: " + Arrays.toString(temp2023));
        System.out.println("Data for 2024: " + Arrays.toString(temp2024));

        // Menu for Algorithms
        System.out.println("\nSelect an option:");
        System.out.println("1. Sort 2023 data (Bubble Sort)");
        System.out.println("2. Search for a month's temperature in 2024 (Linear Search)");
        
        // Error handling for non-integer menu input
        if (input.hasNextInt()) {
            int choice = input.nextInt();

            if (choice == 1) {
                bubbleSort(temp2023);
                System.out.println("Sorted 2023 Temperatures: " + Arrays.toString(temp2023));
            } else if (choice == 2) {
                System.out.print("Enter month index (0 for Jan, 11 for Dec): ");
                if (input.hasNextInt()) {
                    int index = input.nextInt();
                    linearSearch(temp2024, index, months);
                } else {
                    System.out.println("Invalid index input.");
                }
            } else {
                System.out.println("Invalid option selected.");
            }
        } else {
            System.out.println("Please enter a valid number.");
        }
        
        input.close();
    }

    /**
     * Algorithm: Bubble Sort (Meets P4 criteria)
     * Compares adjacent elements and swaps them if they are in the wrong order.
     */
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Algorithm: Linear Search (Meets P4 criteria)
     * Steps through the array to find a specific index or value.
     */
    public static void linearSearch(double[] data, int targetIndex, String[] monthNames) {
        boolean found = false;
        for (int i = 0; i < data.length; i++) {
            if (i == targetIndex) {
                System.out.println("The temperature for " + monthNames[i] + " is: " + data[i] + "°C");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Month index out of range. Please use 0-11.");
        }
    }
}