/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import java.io.File;            // Allows us to work with files
import java.io.FileNotFoundException;   //Handles the case where the file doesn't exist
import java.util.ArrayList;     // Used to store a dynamic list of names
import java.util.Comparator;    // Allows us to define custom sorting rules
import java.util.Scanner;       // Used to read from the file

/**
 *
 * @author Esperanza
 * This class handles the "Sort" menu option
 */
public class SortData implements MenuAction {       // Implements MenuAction interface for modular design
    
    private final String filename;    // Stores the name of the file to read from

    // Constructor: receives the filename when the class is created
    public SortData(String filename) {      //call the string from main class
        this.filename = filename;           //declare that file as a variable
    }

    
    
    // This method is called when the user selects the "SORT" option
    @Override
    public void execute() {
        // STEP 1: Read records from the file
        ArrayList<String[]> records = readCsvRecords(filename);         //Each record is split into fields (columns)

        // If no names were found, show a message and stop
        if (records.isEmpty()) {
            System.out.println("No records found in file.");
            return;
        }

        // STEP 2: Sort by Last Name (index 1)
        ArrayList<String[]> sorted = mergeSort(records, Comparator.comparing(row -> row[1].toLowerCase()));

        // STEP 3: Display first 5 sorted entries (format)
        //Uses printf to align columns like a table
        System.out.println("\nSorted by Last Name (First 5):");
        System.out.printf("%-15s %-15s %-10s %-25s %-10s %-15s %-15s %-20s %-15s%n",
                "First Name", "Last Name", "Gender", "Email", "Salary", "Department", "Position", "Job Title", "Company");

        // create a resul for the 5 first records
        for (int i = 0; i < Math.min(5, sorted.size()); i++) {
            String[] row = sorted.get(i);
            System.out.printf("%-15s %-15s %-10s %-25s %-10s %-15s %-15s %-20s %-15s%n",
                    row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]);
        }

    }
    
    
    // Reads CSV-style records from the file and returns them as a list of string arrays
    private ArrayList<String[]> readCsvRecords(String filename) {
        ArrayList<String[]> records = new ArrayList<>(); // Create an empty list to store records

        try (Scanner scanner = new Scanner(new File(filename))) { // Try to open the file
            if (scanner.hasNextLine()) scanner.nextLine(); // Skip the header line

            // Read each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); // Remove leading/trailing spaces
                if (!line.isEmpty()) { // Ignore empty lines
                    String[] fields = line.split(",", -1); // Split line by commas into fields
                    if (fields.length >= 9) { // Only accept rows with all 9 expected columns
                        records.add(fields); // Add the row to the list
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // If the file doesn't exist, show an error message
            System.out.println("File not found: " + filename);
        }

        return records; // Return the list of valid records
    }

    

    // Recursive merge sort that sorts a list of String[] using a custom comparator
    // Lets you sort by any column (e.g., row[1] for Last Name)
    //row[0] → First Name
    //row[4] → Salary (it need to parse to Double)
    //row[5] → Department
    //row[7] → Job Title

    private ArrayList<String[]> mergeSort(ArrayList<String[]> list, Comparator<String[]> comparator) {
        if (list.size() <= 1) return list; // Base case: already sorted

        int mid = list.size() / 2; // Find the midpoint
        ArrayList<String[]> left = new ArrayList<>(list.subList(0, mid)); // Left half
        ArrayList<String[]> right = new ArrayList<>(list.subList(mid, list.size())); // Right half

        // Recursively sort both halves and merge them
        return merge(mergeSort(left, comparator), mergeSort(right, comparator), comparator);
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    // so on....
    static void merge(int arr[], int l, int m, int r){     //declare the main variables
        
        // Calculate sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r){
        
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Driver code
    public static void main(String args[]){
        
        int arr[] = {38, 27, 43, 10};
        
        mergeSort(arr, 0, arr.length - 1);
        
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    
}
