/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Represents the binary tree structure for employee hierarchy.
 * 
 * Represents the employee hierarchy as a binary tree.
 * Uses Level Order Traversal (Breadth-First Search) for insertion and display.
 *
 * METHODS IN THIS CLASS:
 *  1. insert(String name, String jobTitle, String department)
 *     -Adds a new node using level-order insertion.
 *
 *  2. levelOrderRec(EmployeeNode node, int level, ArrayList<ArrayList<String>> res)
 *     -Recursive helper for level-order traversal, grouping nodes by depth.
 *
 *  3. levelOrder()
 *     -Public method that returns a list of levels with employee info.
 *
 *  4. getHeight()
 *     -Calculates the height of the tree (levels from root to deepest leaf).
 *
 *  5. calculateHeight(EmployeeNode node)
 *     -Recursive helper to compute height.
 *
 *  6. getNodeCount()
 *     -Counts total nodes in the tree.
 *
 *  7. countNodes(EmployeeNode node)
 *     -Recursive helper to count nodes.

 * @author Esperanza
 */
public class EmployeeTree {
    
   /** Root of the binary tree (top of the hierarchy) */
    private EmployeeNode root;

    /** Constructor initializes an empty tree */
    public EmployeeTree() {
        this.root = null;
    }

    /**
     * Inserts a new employee node using level-order (breadth-first) insertion.
     * Ensures each node gets at most two children: left first, then right.
     *
     * @param name     Full name of the employee
     * @param jobTitle Employee's job title
     */
    public void insert(String name, String jobTitle) {
        EmployeeNode newNode = new EmployeeNode(name, jobTitle);

        // Case 1: Tree is empty → new node becomes root
        if (root == null) {
            root = newNode;
            return;
        }

        // Case 2: Tree is not empty → perform level-order insertion
        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            EmployeeNode current = queue.poll();

            // Try to insert as left child
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            // Try to insert as right child
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    /**
     * Performs Level Order Traversal (Breadth-First Search).
     * Groups employees by their depth level in the tree.
     *
     * @return List of levels, each containing employee info
     */
    public List<List<String>> levelOrder() {
        List<List<String>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<String> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                EmployeeNode current = queue.poll();
                String info = current.name + " (" + current.jobTitle + ")";
                level.add(info);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            result.add(level);
        }
        return result;
    }

    /** Calculates the height of the tree */
    public int getHeight() {
        return calculateHeight(root);
    }

    /** Recursive helper to calculate height */
    private int calculateHeight(EmployeeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }

    /** Counts the total number of nodes in the tree */
    public int getNodeCount() {
        return countNodes(root);
    }

    /** Recursive helper to count nodes */
    private int countNodes(EmployeeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }


}
