/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmodellingandbuild2025137;

import java.util.ArrayList;

/**
 *
 * @author Esperanza
 * Dispatcher class that routes the selected menu option
 * to the corresponding class that implements MenuAction.
 */
public class MenuDispatcher {
    /**
     * Dispatches the selected menu option to the appropriate action.
     *
     * @param option  the selected menu option (enum)
     * @param records the list of records loaded from the file
     */
    public static void dispatch(MenuOption option, ArrayList<String[]> records) {
        MenuAction action; // Interface reference to hold the selected action

        switch (option) {
            /**case SORT:
                action = new SortData(records); // Calls SortMenu class
                break;
            case SEARCH:
                action = new SearchMenu(records); // Calls SearchMenu class
                break;
            case ADD_RECORDS:
                action = new AddRecordMenu(records); // Calls AddRecordMenu class
                break;
            case CREATE_TREE:
                action = new TreeMenu(records); // Calls TreeMenu class
                break;*/
            case EXIT:
                return; // Do nothing, main loop will exit
            default:
                System.out.println("Invalid option selected.");
                return;
        }

        //action.execute(); // Run the selected menu action
    }

}
