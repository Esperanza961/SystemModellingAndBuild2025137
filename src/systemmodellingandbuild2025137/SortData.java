/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import java.util.ArrayList;     // Used to store a dynamic list of names



/**
 *
 * @author Esperanza
 * This class handles the "Sort" menu option
 * It sorts employee records by last name using recursive merge sort.
 */
public class SortData implements MenuAction {       // Implements MenuAction interface for modular design
    
    private ArrayList<String[]> records; // Stores the data passed from main

    /**
     * Constructor: receives the list of records from the dispatcher
     * @param records the employee data loaded from the file
     */
    public SortData(ArrayList<String[]> records) {
        this.records = records;
    }

    /**
     * Executes the sort action.
     * Sorts the records by last name and displays the first 10 sorted entries.
     */
    @Override
    public void execute() {
        System.out.println("Sorting records by Last Name using merge sort...");

        // STEP 1: Sort the records manually
        ArrayList<String[]> sorted = mergeSort(records);

        // STEP 2: Display the first 20 sorted records
        System.out.println("\nFirst 20 records sorted by last name:");
        CsvUtility.displayRecords(sorted, 20);
    }

    /**
     * METHOD MERGESORT
     * Recursive merge sort for String[] records.
     * Sorts by last name (column index 1).
     *
     * @param list the list of records to sort
     * @return a sorted list of records
     */
    private ArrayList<String[]> mergeSort(ArrayList<String[]> list) {
        
        if (list.size() <= 1) //base case
            return list; //It checks whether the list is already so small that it doesn’t need sorting.

        // STEP 1: DIVEDE 
        int mid = list.size() / 2; // Find the midpoint
        
        //STEP 2: slice the list into left and right halves
        ArrayList<String[]> left = new ArrayList<>();
        ArrayList<String[]> right = new ArrayList<>();

                
        // Copy elements into left half
        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }   

        // Copy elements into right half
        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i));
        }
        
        // STEP3: Recursively sort both halves (mergesort inside the mergesort)
        ArrayList<String[]> sortedLeft = mergeSort(left);
        ArrayList<String[]> sortedRight = mergeSort(right);


        // STEP 4: Merge the sorted halves and return the result
        return merge(sortedLeft, sortedRight);
       }


    /**
     * METHOD MERGE
     * Merges two sorted lists into one sorted list by comparing last names.
     * @param left the left sorted half
     * @param right the right sorted half
     * @return a merged and sorted list
     */
    private ArrayList<String[]> merge(ArrayList<String[]> left, ArrayList<String[]> right) {  //each record is string[]
        ArrayList<String[]> result = new ArrayList<>(); // Final merged list
        int i = 0;  //Pointer for left list
        int j = 0; // ointer for right list

        // STEP 1: Compare elements from both lists and add the one with smaller last name
        while (i < left.size() && j < right.size()) {
            // Extract last names from both records and convert to lowercase for consistent comparison
            String lastNameLeft = left.get(i)[1].toLowerCase();  // row[1] = Last Name
            String lastNameRight = right.get(j)[1].toLowerCase();

            // Compare last names alphabetically
            if (lastNameLeft.compareTo(lastNameRight) <= 0) {
                result.add(left.get(i)); // Add from left and move pointer
                i++; // Move pointer forward
            } else {
                result.add(right.get(j)); // Add from right and move pointer
                j++; // Move pointer forward
            }
        }

        // STEP 2: Add any remaining records from the left list
        while (i < left.size()) {
            result.add(left.get(i));
            i++; // Move pointer forward
        }

        // STEP 3: Add any remaining elements from right
        while (j < right.size()) {
            result.add(right.get(j));
            j++; // Move pointer forward
        }

        return result; // Return the merged sorted list
    }


}
