/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inpututilities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * HDIP Feb 2025
 * 
 * InputUtiiities
 * 
 *  1) askUserForText(String) -- prompt user for text input & validate
 * 
 *  2) askUserForInt (String) -- prompt user for an integer value & validate
 * 
 *  3) askUserForInt(String, int) - prompt user for an int with a given minimum value
 * 
 *  4) askUserFOrInt (String, int, int) -- prompt user for an int within a valid range
 * 
 *  5) askUserForDouble (String prompt, double minValue, double maxValue) -- prompt user for an double within a valid range
 * 
 *  6) askUserForGender (String) -- prompt user for a valid gender
 * 
 * @author kheal
 */
public class InputUtilities {
    
    /**
     * ask the user to enter some text - no numbers!
     * @param prompt is the question or prompt for the user
     * @return valid text entered by the user 
     */
    public String askUserForText(String prompt){
        
        Scanner myKB = new Scanner(System.in);
        String userInput;
        
        do{
            // issue prompt to user and get input
            System.out.println(prompt);
            userInput = myKB.nextLine().trim();
            
            //keep going while input not valid text
        }while (!userInput.matches("[a-zA-Z]+$"));
        
        // Format: capitalize first letter, lowercase the rest
        String formatted = userInput.substring(0, 1).toUpperCase() + userInput.substring(1).toLowerCase();

        return formatted;

    }
    
    /**
     * ask the user to enter an integer value
     * @param prompt is the question or prompt to the user
     * @return a valid int entered by the user
     */
    public int askUserForInt(String prompt){
        
        Scanner myKB = new Scanner(System.in);
        String userInput;
        
        do{
            // issue prompt to user and get input
            System.out.println(prompt);
            System.out.println("You must enter an integer value.");
            userInput = myKB.nextLine();
            
            //keep going while input not valid text
        }while (!userInput.matches("[0-9]"));
        
        //input must be valid int
        return (Integer.parseInt(userInput));
    }
    
    /**
     * Ask the user to enter an integer greater than a given minimum value
     * @param prompt the question or prompt to the user
     * @param minValue the lowest value that is allowed
     * @return a valid int greater or equal to minValue 
     */
    public int askUserForInt(String prompt, int minValue){
        
        Scanner myKB = new Scanner(System.in);
        int userInput = minValue -1;  //default to a value that is definitely not allowed
        
        do {
            System.out.println(prompt);
            System.out.println("You must enter an integer bigger than " + minValue);
            try {
                userInput = myKB.nextInt();
                
            }catch(InputMismatchException IMe){
                //must be non-integer input
                System.out.println("That was not an integer value");
                myKB.nextLine();
            }
        } while ( (userInput < minValue));
        
        return userInput; // the userInput must be a number bigger or equal to minValue
    }
    
    /**
     * Ask the user to enter an integer within a certain range
     * @param prompt the question or prompt for the user
     * @param minValue the lowest value allowed
     * @param maxValue the highest value allowed
     * @return a valid integer inside the given range
     */
    public int askUserForInt(String prompt, int minValue, int maxValue){
        
        Scanner myKB = new Scanner(System.in);
        int userInput = minValue -1;  //default to a value that is definitely not allowed
        
        do {
            System.out.println(prompt);
            System.out.println("You must enter an integer between " + minValue + " and " + maxValue);
            try {
                userInput = myKB.nextInt();
                
            }catch(Exception e){
                //must be non-integer input
                System.out.println("That was not an integer value");
                myKB.nextLine();
            }
            
        } while ( (userInput < minValue) || (userInput > maxValue));
        
        return userInput; // the userInput must be inside the allowed range
    }
    
    /**
     * Ask the user to enter a double within a certain range
     * @param prompt the question or prompt for the user
     * @param minValue the lowest value allowed
     * @param maxValue the highest value allowed
     * @return a valid double inside the given range
     */
    
    public double askUserForDouble(String prompt, double minValue, double maxValue) {
    Scanner myKB = new Scanner(System.in);
    double userInput = minValue - 1; // start with invalid value

        do {
            System.out.println(prompt);
            System.out.println("You must enter a number between " + minValue + " and " + maxValue);
            try {
                userInput = myKB.nextDouble();
                myKB.nextLine(); // consume newline
            } catch (Exception e) {
                System.out.println(" That was not a valid number.");
                myKB.nextLine(); // discard invalid input
            }
        } while (userInput < minValue || userInput > maxValue);

        return userInput;
    }
    
    
    /**
     * Ask the user to enter a gender within a certain options
     * @param prompt the question or prompt for the user
     * @return a valid string inside the given range
     */
    
    public String askUserForGender(String prompt) {
        Scanner myKB = new Scanner(System.in);
        String userInput;

        do {
            System.out.println(prompt);
            System.out.println("Please enter Male, Female, or Other:");
            userInput = myKB.nextLine().trim().toLowerCase(); // normalize input

            // Accept only "male", "female", or "other"
            if (userInput.equals("male") || userInput.equals("female") || userInput.equals("other")) {
                // Capitalize first letter
                return userInput.substring(0, 1).toUpperCase() + userInput.substring(1);
            } else {
                System.out.println("Invalid input. Try again.");
            }

        } while (true);
    }
    
    
    /**
     * Ask the user to enter a email within a certain options
     * @param prompt the question or prompt for the user
     * @return a valid string inside the format
     */
    
    public String askUserForEmail(String prompt) {
        Scanner myKB = new Scanner(System.in);
        String userInput;

        // Simple regex for basic email validation
        String emailPattern = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

        do {
            System.out.println(prompt);
            userInput = myKB.nextLine().trim().toLowerCase();

            if (userInput.matches(emailPattern)) {
                return userInput; // valid email
            } else {
                System.out.println("Invalid email format. Please try again.");
            }

        } while (true);
    }
    
}
