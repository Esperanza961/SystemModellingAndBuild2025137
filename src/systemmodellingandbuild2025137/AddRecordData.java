/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import inpututilities.InputUtilities;
import java.util.ArrayList;     // Used to store the list of employee records
import java.util.HashSet;
import java.util.Scanner;       //Used to read user input from the console

/**
 * 
 * METHOD execute() -- Uses InputUtilities to collect validated input and adds it to the record list
 * 
 * Handles the "Add Record" menu option.
 * Allows the user to manually enter a new employee record.
 * Adds the record to the in-memory list (ArrayList<String[]>).
 * 
 * @author Esperanza
 */
public class AddRecordData implements MenuAction{
    
    private ArrayList<String[]> records; // Reference to the main record list

    /**
     * Constructor: receives the list of records from the dispatcher.
     * @param records the employee data loaded from the file
     */
    public AddRecordData(ArrayList<String[]> records) {
        this.records = records;
    }

    /**
     *  
     * Executes the add-record action.
     * Prompts the user for each field and adds the new record to the list.
     */
    @Override
    public void execute() {
        //Scanner Mynput = new Scanner(System.in); // Used for reading strings
        InputUtilities myInput = new InputUtilities(); // For validated numeric input

        System.out.println("\n ADD NEW EMPLOYEE RECORD");

        // Create a new record array with 10 fields
        String[] newRecord = new String[10];
        
        // Extract existing departments from records
        // HashSet ensures uniqueness and allows fast validation with .contains()
        HashSet<String> existingDepartments = new HashSet<>();
        // Extract existing job titles from records into a HashSet
        HashSet<String> existingJobTitles = new HashSet<>();

        for (String[] row : records) {
            if (row.length >= 6) {
                existingDepartments.add(row[5]); // Department column
            }
            if (row.length >= 8) {
                existingJobTitles.add(row[7]); // Job Title column
            }
        }


        // Prompt for each field using your utility methods
        newRecord[0] = myInput.askUserForText("Enter First Name:");             //add the first name
        newRecord[1] = myInput.askUserForText("Enter Last Name:");              //add the last Name
        newRecord[2] = myInput.askUserForGender("Enter Gender (e.g. Male/Female):");////add the gender
        newRecord[3] = myInput.askUserForEmail("Enter Email Address:");          //add the email


        // Ask for salary as double (you can later add askUserForDouble if needed)
        double salary = myInput.askUserForDouble("Enter Salary (e.g. 3500.75):", 0, 1000000);
        newRecord[4] = String.format("%.2f", salary); // format to 2 decimal places

        // Validate Department: must exist in the current dataset
        String department;
        do {
            department = myInput.askUserForText("Enter Department choose from: " + existingDepartments);
            if (!existingDepartments.contains(department)) {
                System.out.println("!Invalid Department. Please choose from: " + existingDepartments);
            }
        } while (!existingDepartments.contains(department));
        newRecord[5] = department; // Department

        // Position (e.g., Junior, Senior) – free text
        newRecord[6] = myInput.askUserForText("Enter Position (e.g. Junior, Senior):");

        // Job Title (requirement instead of Manager Type)
        // Validate Job Title: must exist in the current dataset
        String jobTitle;
        do {
            jobTitle = myInput.askUserForText("Enter Job Title choose from::" + existingJobTitles);
            if (!existingJobTitles.contains(jobTitle)) {
                System.out.println("!Invalid Job Title. Please choose from: " + existingJobTitles);
            }
        } while (!existingJobTitles.contains(jobTitle));
        newRecord[7] = jobTitle; // Job Title


        // Company Name
        newRecord[8] = myInput.askUserForText("Enter Company Name:");

        

        // Add to the main list
        records.add(newRecord);

        System.out.println("\n Record added successfully!");
        CsvUtility.displayRecords(records, records.size()); // Show updated list
    }


    
}
