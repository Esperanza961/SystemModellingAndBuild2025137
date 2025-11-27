/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import java.util.ArrayList;

/**
 * CLASS EmployeeNode
 * ------------------
 * Represents a single employee in the binary tree.
 * Each node stores:
 *   - Employee's full name
 *   - Job Title (e.g., Manager, Developer, Clerk)
 *   - References to left and right child nodes
 *
 * Author: Esperanza
 */
public class EmployeeNode {

    // Full name of the employee
    String name;

    //Job Title of the employee 
    String jobTitle;

    // Left child in the binary tree 
    EmployeeNode left;

    // Right child in the binary tree 
    EmployeeNode right;

    /**
     * Constructor to initialize the node with employee data.
     * @param name     Full name of the employee
     * @param jobTitle Employee's job title
     */
    public EmployeeNode(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.left = null;
        this.right = null;
    }

}
