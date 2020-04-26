import java.util.Scanner;

/**
 * Main class that's used to run the program
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */
public class FinalProjectMain {

    public static void main(String[] args) {

        // Business Requirement 1 Testing
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        System.out.println("SWEN-383 Store Input Menu, select a person (1 or 2):\n");
        System.out.println("1. Customer");
        System.out.println("2. Manager\n");
        System.out.print("Input: ");

        while(!done) {
            String input = scanner.nextLine();
            if(input.equals("1")) {
                System.out.println("\nYou are new! Fill in the customer data:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Home Address: ");
                String addr = scanner.nextLine();
                System.out.print("Home Phone Number: ");
                String home_phone = scanner.nextLine();
                System.out.print("Mobile Phone Number: ");
                String mobile_phone = scanner.nextLine();
                System.out.print("Email Address: ");
                String email = scanner.nextLine();
                System.out.print("Credit Card Info: ");
                String credit_info = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                int id = (int)(Math.random() * 10000000);

                Customer cust = new Customer(id, name, addr, mobile_phone, home_phone, email, credit_info, password);

                // add customer account to store class list here

                System.out.println("\nThanks! We created you account. Your ID is: " + id + ". Use that with " +
                                    "your password to log in below:\n");

                System.out.print("User ID: ");
                String user_id = scanner.nextLine();
                System.out.print("Password: ");
                String pass = scanner.nextLine();

                // validate credentials
                boolean result = cust.verify(Integer.parseInt(user_id), pass);
                if(result) {
                    System.out.println("You've logged in!");
                } else {
                    System.out.println("Login failed");
                }
            }
            
            else if(input.equals("2")) {
                System.out.println("\nYou are new! Fill in the manager data:");
                //Manager Credentials Below
                
                
            }
            
            else{
               //if input does not equal 1 or 2
               System.out.print("\nNot a valid selection. Select 1 or 2:");
               //scanner cursor still needs to be fixed
               scanner.nextLine();
               scanner.nextLine();
               input = scanner.nextLine(); 
               
               
            }

            
            
            
        }


        // Business Requirement 2 Testing
    }
}
