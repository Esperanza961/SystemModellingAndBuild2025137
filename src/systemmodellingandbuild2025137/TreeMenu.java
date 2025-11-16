/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import java.util.ArrayList; //ger the list 

/**
 * TreeMenu is a menu action that builds and displays an employee hierarchy
 * using a binary tree. It reads from the shared applicants-form.txt data,
 * inserts the first 20 records using level-order insertion, and displays
 * the tree level by level, along with its height and total node count.
 * 
 * @author Esperanza
 */
public class TreeMenu implements MenuAction {
    
    // Shared list of employee records loaded from applicants-form.txt
    private ArrayList<String[]> records;

    /**
     * Constructor receives the shared employee data.
     * @param records the list of String[] rows from the CSV file
     */
    public TreeMenu(ArrayList<String[]> records) {
        this.records = records;
    }

    /**
     * Executes the tree-building and display logic.
     * - Extracts name, manager type, and department from each record
     * - Inserts up to 20 records into the binary tree
     * - Displays the hierarchy using recursive level-order traversal
     * - Prints the tree height and total number of nodes
     */
    @Override
    public void execute() {
        // Create a new binary tree instance
        EmployeeTree tree = new EmployeeTree();

        System.out.println("\n BUILDING EMPLOYEE HIERARCHY TREE...");

        int count = 0;

        // Loop through the records and insert the first 20 into the tree
        for (String[] row : records) {
            if (row.length >= 7) {
                // Extract relevant fields from the CSV row
                String name = row[0] + " " + row[1];     // FirstName + LastName
                String managerType = row[6];             // Position (e.g., Junior, Senior)
                String department = row[5];              // Department (e.g., IT, HR)

                // Insert into the binary tree
                tree.insert(name, managerType, department);
                count++;

                // Stop after inserting 20 records
                if (count >= 20) break;
            }
        }

        // Perform recursive level-order traversal and group by level
        ArrayList<ArrayList<String>> levels = tree.levelOrder();

        // Display the hierarchy level by level
        System.out.println("\n EMPLOYEE HIERARCHY (Level Order):");
        int levelNum = 0;
        for (ArrayList<String> level : levels) {
            System.out.println("Level " + levelNum + ":");
            for (String info : level) {
                System.out.println("  - " + info);
            }
            levelNum++;
        }

        // Display tree statistics
        System.out.println("\n Tree Height: " + tree.getHeight());
        System.out.println(" Total Nodes: " + tree.getNodeCount());
    }
    
}
