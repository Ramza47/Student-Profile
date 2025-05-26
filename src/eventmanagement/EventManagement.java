
package eventmanagement;

import java.util.Scanner;


public class EventManagement {

    // Stored data
    static String savedName;
    static String savedEmail;
    static String savedID;
    
    //check name contains space
    public static boolean validateName(String name) {
        return name.contains(" ");
    }
    
    // check email contains @ and .
    public static boolean validateEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
    
    // Check ID has 13 characters
    public static boolean validateID(String id) {
        return id.length() == 13;
    }
    
    // Register guest 
    public static String registerGuest(String name, String email, String id) {
        String message = "";
        
        if (validateName(name)) {
            savedName = name;
            message += "Name successfully recorded.\n";
        } else {
            message += "Name must contain both first and last name.\n";
        }
        if (validateEmail(email)) {
            savedEmail = email;
            message += "Email successfully captured.\n";
        } else {
            message += "Email format is invalid.\n";
        }

        if (validateID(id)) {
            savedID = id;
            message += "ID number successfully recorded.\n";
        } else {
            message += "Invalid ID number. It must be exactly 13 characters.\n";
        }
        return message;
    }
    
    // CHeck-in guest
    public static boolean checkIn(String name, String id) {
        return name.equals(savedName) && id.equals(savedID);
    }
    
    // Message after check-in
    public static String getCheckInMessage(String name, String id) {
        if (checkIn(name, id)) {
            return "welcome " + name + ", your badge has been created. Enjoy the event!";
        } else {
            return "Check-in failed. Name or ID incorrect.";
        }
    }
    
    public static void main(String[] args) {
       // Scans object
       Scanner input = new Scanner(System.in);
       
       // user input
       System.out.println("Welcome to the TechFast RSVP System!");
       
       System.out.print("Enter your full name: ");
       String name = input.nextLine();
       
       System.out.print("Enter your email: ");
       String email = input.nextLine();
       
       System.out.print("Enter your ID number: ");
       String id =  input.nextLine();
       
       System.out.println("\n-- Registration ---");
       System.out.println(registerGuest(name, email, id));
       
       System.out.println("--- Check In ---");
       System.out.print("Enter name for check-in: ");
       String checkName = input.nextLine();
       
       System.out.print("Enter ID for check-in: ");
       String checkID = input.nextLine();
       
       System.out.println("\n" + getCheckInMessage(checkName, checkID));
    }
}