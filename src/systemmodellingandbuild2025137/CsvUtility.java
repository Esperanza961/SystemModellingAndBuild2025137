/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;


import java.io.File;                            //Used to open and read files
import java.io.FileNotFoundException;           //Handles missing file errors
import java.util.ArrayList;                     //Stores dynamic lists of records
import java.util.Scanner;                       //Reads lines from the file

/**
 *  METHODS in this class
 * 
 * 1.   readCsvRecords(String filename): Loads CSV data into ArrayList<String[]>
 * 
 * 2.   displayRecords(ArrayList<String[]> records, int count: Prints formatted table of employee data
 * 
 * 3.   saveRecords(String filename, ArrayList<String[]> records): Saves updated data back to file
 * 
 * 4.   appendRecord(String filename, String[] newRecord)
 * 
 * @author Esperanza
 * 
 * Utility class for loading and displaying CSV-style data.
 * This class is shared across all menu options (Sort, Search, etc.) This will:
 * 1. Read the CSV-style  file ()
 * 2. Display the first N records in a clean table format
 * This will Keep the main class tidy by offloading file logic here
 */
public class CsvUtility {
    /**
     * Reads a CSV-style .txt file and returns a list of records.
     * Each record is stored as a String array with 9 fields.
     *
     * @param filename the name of the file to read
     * @return a list of records (each record is a String[9])
     */
    
    //String[]: Each record is split into fields (columns)
    public static ArrayList<String[]> readCsvRecords(String filename) {
        ArrayList<String[]> records = new ArrayList<>(); // Create an empty list to store records

        try (Scanner scanner = new Scanner(new File(filename))) { // Try to open the file safely
            if (scanner.hasNextLine()) scanner.nextLine(); // Skip the header line (titles)

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

    
    
    
    /**
     * Displays the first N records in a formatted table.
     * This helps the user preview the data before choosing an action.
     *
     * @param records the list of records to display
     * @param count how many records to show (e.g., 10)
     */
    
    //Uses printf to align columns like a table
    public static void displayRecords(ArrayList<String[]> records, int count) {
        // Print table headers with aligned columns
        System.out.printf("%-15s %-15s %-8s %-30s %-10s %-15s %-15s %-25s %-20s%n",
            "First Name", "Last Name", "Gender", "Email", "Salary", "Department", "Position", "Job Title", "Company");

        // Print a separator line (Java 8 compatible)
        for (int i = 0; i < 170; i++) {
            System.out.print("=");
        }
        System.out.println();

    // Print up to 'count' records
        for (int i = 0; i < Math.min(count, records.size()); i++) {
            String[] row = records.get(i);
            System.out.printf("%-15s %-15s %-8s %-30s %-10s %-15s %-15s %-25s %-20s%n",
                    row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]);
        }
    
    }
       
}
