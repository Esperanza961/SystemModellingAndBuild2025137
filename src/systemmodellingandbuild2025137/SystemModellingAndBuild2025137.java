/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package systemmodellingandbuild2025137;

import inpututilities.InputUtilities;       //Import your input validation class
import java.util.ArrayList;                 //For storing records as dynamic lists

/**
 *
 * @author Esperanza
 */
public class SystemModellingAndBuild2025137 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // STEP 1: Setup
        InputUtilities myInput = new InputUtilities();  //Create input helper object
        
        String filename = "Applicants_Form.txt";       //Define the data file to load
        
        // STEP 2: Load data from file
        ArrayList<String[]> records = CsvUtility.readCsvRecords(filename); // Read all rows from the file

        // STEP 3: Check if file was empty or missing
        if (records.isEmpty()) {
            System.out.println("No data found in file. Exiting program.");
            return; // Exit early if no data
        }

        // STEP 4: Show first 10 records as a preview
        System.out.println("\n First 10 Records:");
        CsvUtility.displayRecords(records, 10); // Show first 10 rows in table format

        // STEP 5: Menu loop
        MenuOption selected;
        
        do {
            System.out.println("");
            showMenu(); // Display menu options

            int option = myInput.askUserForInt("Choose an option:", 1, MenuOption.values().length); // Ask user for choice
            selected = MenuOption.values()[option - 1]; // Convert number to enum

            MenuDispatcher.dispatch(selected, records); // Call the appropriate menu class

        } while (selected != MenuOption.EXIT); // Repeat until user chooses to exit

        System.out.println("GOODBYE!"); // Farewell message
    }

    
    
    /**
     *  Displays the menu on the screen
     */
    private static void showMenu() {
        
        System.out.println("""
                           
                           **************** MENU ************
                           \t 1 \t Sort records by Last Name
                           \t 2 \t Search records by Department or Name.
                           \t 3 \t Add a new record to the file
                           \t 4 \t Create and display a binary tree of employees
                           \t 5 \t Exit""");
    }
    
}
