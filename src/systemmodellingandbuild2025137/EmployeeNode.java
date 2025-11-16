/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

/**
 * Stores individual employee data for the binary tree.
 * Each node stores Name, Manager Type, and Department.
 * 
 * @author Esperanza
 */
public class EmployeeNode {
    
    String name;        //Full name of the employee
    String managerType; //Position (e.g., Junior, Senior, Manager)
    String department;  //Department name
    EmployeeNode left;  //Left child in the tree
    EmployeeNode right; //Right child in the tree

    /**
     * Constructor to initialize the node with employee data.
     */
    public EmployeeNode(String name, String managerType, String department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
        this.left = null;
        this.right = null;
    }

    
    
}
