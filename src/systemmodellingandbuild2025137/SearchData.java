/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import inpututilities.InputUtilities;
import java.util.ArrayList;     // Used to store the list of employee records
import java.util.Scanner;       // Used to read user input from the console

/**
 *
 * @author Esperanza
 * This class handles the "Search" menu option.
 * It allows the user to search employee records by Last Name or Department
 * using a fully manual linear search.
 * 
 * It implements the MenuAction interface for modular design.
 */
public class SearchData implements MenuAction {


    private ArrayList<String[]> records; // Stores the employee records passed from the dispatcher

    /**
     * Constructor: receives the list of records from the dispatcher.
     * @param records the employee data loaded from the file
     */
    public SearchData(ArrayList<String[]> records) {
        this.records = records;
    }

    /**
     * Executes the search action.
     * Prompts the user to choose a search type and enter a search term.
     * Then performs a linear search and displays matching records.
     */
    @Override
    public void execute() {
        //Scanner input = new Scanner(System.in); // Create scanner for user input
        InputUtilities myInput = new InputUtilities();  //Create input helper object

        // Display search options
        System.out.println("\n SEARCH MENU");
        System.out.println("1. Search by Last Name");
        System.out.println("2. Search by Department");
        System.out.print("Choose an option (1 or 2): ");

        // Use validated input method
        int choice = myInput.askUserForInt("Choose an option (1 or 2): ", 1, 2);
        
        Scanner input = new Scanner(System.in); // Still needed for reading strings

        // Handle user choice
        switch (choice) {
            case 1:
                // Prompt for last name
                System.out.print("Enter Last Name to search: ");
                String lastName = input.nextLine().trim();  //remove spaces
                searchByLastName(lastName); // Call helper method
                break;

            case 2:
                // Prompt for department
                System.out.print("Enter Department to search: ");
                String department = input.nextLine().trim(); //remove spaces
                searchByDepartment(department); // Call helper method
                break;

            default:
                // Handle invalid input
                System.out.println(" Invalid choice. Returning to main menu.");
        }
    }

    /**
     * Searches the records by Last Name (column index 1).
     * Performs a case-insensitive linear search.
     * 
     * @param target the last name to search for
     */
    private void searchByLastName(String target) {
        ArrayList<String[]> matches = new ArrayList<>(); // Stores matching records

        // Loop through each record
        for (String[] row : records) {
            // Compare last name (column 1) ignoring case
            if (row[1].toLowerCase().startsWith(target.toLowerCase())) {      //Converts both values to lowercase for case-insensitive comparison
                matches.add(row); // Add match to result list
            }
        }

        // Display results
        if (matches.isEmpty()) {
            System.out.println("No employee found with last name: " + target);
        } else {
            System.out.println("\n Matches found:");
            CsvUtility.displayRecords(matches, matches.size()); // Show all matches
        }
    }

    /**
     * Searches the records by Department (column index 5).
     * Performs a case-insensitive linear search.
     * 
     * @param target the department to search for
     */
    private void searchByDepartment(String target) {
        ArrayList<String[]> matches = new ArrayList<>(); // Stores matching records

        // Loop through each record
        for (String[] row : records) {
            // Compare department (column 5) ignoring case
            if (row[5].toLowerCase().startsWith(target.toLowerCase())) {      //Converts both values to lowercase
                matches.add(row); // Add match to result list
            }
        }

        // Display results
        if (matches.isEmpty()) {
            System.out.println("No employees found in department: " + target);
        } else {
            System.out.println("\n Matches found:");
            CsvUtility.displayRecords(matches, matches.size()); // Show all matches
        }
    }
}
