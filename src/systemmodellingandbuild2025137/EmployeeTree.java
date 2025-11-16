/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import java.util.ArrayList;

/**
 * Represents the binary tree structure for employee hierarchy.
 * Uses level-order (breadth-first) insertion to ensure each node gets at most two children.
 * 
 * METHODS IN THIS CLASS
 * 
 * 1.   insert(String name, String managerType, String department): Adds a new node using level-order insertion
 * 
 * 2.   [Helper] levelOrderRec(EmployeeNode node, int level, ArrayList<ArrayList<String>> res): Recursive traversal grouped by level
 * 
 * 3.   levelOrder(): Returns a list of levels with employee info.
 * 
 * 4.   getHeight(): Calculates the height of the tree
 * 
 * 5.   [Helper] calculateHeight(): Recursively computes tree height 
 * 
 * 6.   [Helper] getNodeCount(): Counts total nodes in the tree
 * 
 * 7.   [Helper] countNodes(): Recursively counts nodes
 * 
 * @author Esperanza
 */
public class EmployeeTree {
    
    // The root node of the tree (top-level employee, calling the class)
    private EmployeeNode root;

    /**
     * Constructor initializes an empty tree.
     */
    public EmployeeTree() {
        this.root = null;
    }

    
    /**
     * Inserts a new employee node using level-order (breadth-first) insertion.
     * This ensures each node gets at most two children: left first, then right.
     * 
     * @param name         Full name of the employee
     * @param managerType  Position or role (e.g., Junior, Senior, Manager)
     * @param department   Department name (e.g., Accounting, HR)
     */
    public void insert(String name, String managerType, String department) {
        EmployeeNode newNode = new EmployeeNode(name, managerType, department);

        // If the tree is empty, set the new node as root
        if (root == null) {
            root = newNode;         //create new
            return;
        }

        // Use a queue to perform level-order insertion
        ArrayList<EmployeeNode> queue = new ArrayList<>();
        queue.add(root);

        //Level-order insertion: Used a queue to insert nodes in breadth-first order
        while (!queue.isEmpty()) {
            EmployeeNode current = queue.remove(0); // dequeue

            // Try to insert as left child
            if (current.left == null) {
                current.left = newNode;   //create new
                return;
            } else {
                queue.add(current.left); // enqueue left child
            }

            // Try to insert as right child
            if (current.right == null) {
                current.right = newNode; //create new
                return;
            } else {
                queue.add(current.right); // enqueue right child
            }
        }
    }

    
    
    /**
     * Recursive helper method to perform level-order traversal.
     * Groups nodes by their depth level in the tree.
     * 
     * @param node   Current node being visited
     * @param level  Current depth level (starting from 0)
     * @param res    List of levels, each containing employee info strings
     */
    private void levelOrderRec(EmployeeNode node, int level, ArrayList<ArrayList<String>> res) {
        if (node == null) return;

        // If this level doesn't exist yet, add a new list
        if (res.size() <= level)
            res.add(new ArrayList<>());

        // Format employee info and add to current level
        String info = node.name + " (" + node.managerType + ", " + node.department + ")";
        res.get(level).add(info);

        // Recur for left and right children, increasing level
        levelOrderRec(node.left, level + 1, res);
        levelOrderRec(node.right, level + 1, res);
    }

    
    
    /**
     * Public method to perform level-order traversal.
     * Returns a list of levels, each containing employee info.
     * 
     * @return List of levels with employee data
     */
    public ArrayList<ArrayList<String>> levelOrder() {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        levelOrderRec(root, 0, res);
        return res;
    }

    
    
    /**
     * Calculates the height of the tree.
     * Height = number of levels from root to deepest leaf.
     * 
     * @return Tree height
     */
    public int getHeight() {
        return calculateHeight(root);
    }

    
    
    /**
     * Recursive helper to calculate height.
     * 
     * @param node Current node
     * @return Height from this node downward
     */
    private int calculateHeight(EmployeeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }

    
    
    /**
     * Counts the total number of nodes in the tree.
     * 
     * @return Total node count
     */
    public int getNodeCount() {
        return countNodes(root);
    }

    
    /**
     * Recursive helper to count nodes.
     * 
     * @param node Current node
     * @return Number of nodes under this node
     */
    private int countNodes(EmployeeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

}
