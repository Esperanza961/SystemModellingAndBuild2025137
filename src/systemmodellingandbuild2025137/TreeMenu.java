/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import java.util.ArrayList; //ger the list 
import java.util.List;

/**
 *  CLASS TreeMenu
 * --------------
 * Menu action that builds and displays the HR hierarchy tree.
 * Reads employee data from applicants-form.txt and inserts them
 * into the correct node based on their Job Title.
 *
 * @author Esperanza
 */
public class TreeMenu implements MenuAction {
    
    //Shared list of employee records loaded from applicants-form.txt 
    private ArrayList<String[]> records;

    // Constructor receives the shared employee data 
    public TreeMenu(ArrayList<String[]> records) {
        this.records = records;
    }

    // Executes the tree-building and display logic
    @Override
    public void execute() {
        EmployeeTree tree = new EmployeeTree();

        System.out.println("\n BUILDING EMPLOYEE HIERARCHY TREE...");

        // Adequate order of job titles for hierarchy
        String[] hierarchyOrder = {
            "Head Manager", "Senior Manager", "Manager", "Assistant Manager",
            "Team Lead", "Frontend Developer", "Backend Developer", "Full-stack Developer",
            "Mobile Developer", "DevOps", "AI Developer", "QA",
            "HR Specialist", "HR Analyst", "Finance Analyst", "Marketing Specialist",
            "Client Relations Specialist", "Client Relations Coordinator",
            "Bookkeeper", "Junior Bookkeeper", "Clerk", "Junior Clerk",
            "Office Worker", "Desk Jockey", "White-collar Worker",
            "Sales Clerk", "Support Clerk"
        };

        int count = 0;

        // Insert employees into the binary tree following the hierarchy order
        for (String[] row : records) {
            if (row.length >= 8 && count < hierarchyOrder.length) {
                String name = row[0] + " " + row[1];   // FirstName + LastName
                String jobTitle = hierarchyOrder[count]; // Assign job title by order

                tree.insert(name, jobTitle);
                count++;

                if (count >= 20) break; // limit to 20 records
            }
        }

        // Display hierarchy level by level
        List<List<String>> levels = tree.levelOrder();
        System.out.println("\n EMPLOYEE HIERARCHY (Level Order):");
        int levelNum = 0;
        for (List<String> level : levels) {
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
