/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package systemmodellingandbuild2025137;

/**
 *
 * @author Esperanza
 * each class like SortMenu, SearchMenu, etc. implements this interface.
 */
public interface MenuAction {
    void execute();    //Calls the correct logic without knowing the class type
}
