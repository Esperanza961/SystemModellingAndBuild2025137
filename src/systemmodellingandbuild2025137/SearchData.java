/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import inpututilities.InputUtilities;
import java.util.ArrayList;     // Used to store the list of employee records
import java.util.Scanner;       // Used to read user input from the console

/**
 * CLASS SearchData
 * ----------------
 * Provides functionality to search employee records using Binary Search.
 *
 * Workflow:
 *   1. Sort the list alphabetically by the chosen field (Last Name or Department)
 *      using SortData (merge sort).
 *   2. Perform a binary search to find the target employee(s).
 *   3. Display the result clearly.
 *
 * Implements the MenuAction interface for modular design.
 *
 * Author: Esperanza
 */
public class SearchData implements MenuAction {

    /** Stores the employee records passed from the dispatcher */
    private ArrayList<String[]> records;

    /** Constructor: receives the list of records from the dispatcher */
    public SearchData(ArrayList<String[]> records) {
        this.records = records;
    }

    /** Executes the search action */
    @Override
    public void execute() {
        InputUtilities myInput = new InputUtilities();

        // Display search options
        System.out.println("\n SEARCH MENU");
        System.out.println("1. Search by Last Name (Binary Search)");
        System.out.println("2. Search by Department (Binary Search)");

        int choice = myInput.askUserForInt("Choose an option (1 or 2): ", 1, 2);

        Scanner input = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.print("Enter Last Name to search: ");
                String lastName = input.nextLine().trim();
                searchBinary(lastName, 1); // column 1 = Last Name
                break;

            case 2:
                System.out.print("Enter Department to search: ");
                String department = input.nextLine().trim();
                searchBinary(department, 5); // column 5 = Department
                break;

            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    /**
     * Generic Binary Search method for employee records.
     * @param target the string to search for
     * @param columnIndex the column to search (1 = Last Name, 5 = Department)
     */
    private void searchBinary(String target, int columnIndex) {
        // Step 1: Sort records using SortData (merge sort)
        SortData sorter = new SortData(records);
        ArrayList<String[]> sortedRecords = sorter.getSortedRecords();

        // Step 2: Binary Search
        int low = 0;
        int high = sortedRecords.size() - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midValue = sortedRecords.get(mid)[columnIndex].toLowerCase();
            int comparison = target.toLowerCase().compareTo(midValue);

            // Check if midValue starts with target
            if (midValue.startsWith(target.toLowerCase())) {
                System.out.println("\n Match found:");
                ArrayList<String[]> singleRecord = new ArrayList<>();
                singleRecord.add(sortedRecords.get(mid));
                CsvUtility.displayRecords(singleRecord, 1);
                found = true;
                break;

            } else if (comparison > 0) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }

        if (!found) {
            System.out.println("No employee found with " +
                (columnIndex == 1 ? "last name: " : "department: ") + target);
        }
    }

}
