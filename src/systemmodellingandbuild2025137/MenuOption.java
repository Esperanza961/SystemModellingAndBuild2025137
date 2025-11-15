package systemmodellingandbuild2025137;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Esperanza
 * Objective - Defines all valid menu choices
 * An Enum (short for enumeration) is a special Java type used to define a fixed set of constants. 
 * Each menu option (like SORT, SEARCH, ADD RECORDS) becomes a named constant.
 * Instead of using raw numbers like 1, 2, 3, we use meaningful names like SORT, SEARCH, etc.

 */


public enum MenuOption {  //we create a enum class for the menu option that will be used in the main clas
    SORT,           //this is the option 1 Sort records by last name
    SEARCH,         //this is the option 2 Search records by department or name
    ADD_RECORDS,    //this is the option 3 Add a new record to the file
    CREATE_TREE,    //this is the option 4 Create and display a binary tree
    EXIT            //this is the option 5 Exit the program

}
