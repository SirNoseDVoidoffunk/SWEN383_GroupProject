import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Main class that's used to run the program
 * @version 4/26/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */
public class FinalProjectMain {

    public static void main(String[] args) {

        ////////////////////////////////////////////////
        // To go into developer mode, set dev to true //
        ////////////////////////////////////////////////

        boolean dev = true;

        // create all Store, Inventory, and item objects here

        Item item1 = new Item(true, false, true, 3, "Star Wars: The Clone Wars", "DVD");
        Item item2 = new Item(true, false, true, 2, "James Bond: Skyfall", "DVD");
        Item item3 = new Item(true, false, true, 1, "Indiana Jones: The Lost Arch", "DVD");
        Item item4 = new Item(true, false, true, 4, "Classical Music", "CD");
        Item item5 = new Item(true, false, true, 3, "1990's Hits", "CD");
        Item item6 = new Item(true, false, true, 3, "2000's Hits", "CD");
        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        Inventory inventory = new Inventory(items);
        Store store = new Store(inventory, "Rochester, NY");


        // Start of CLI

        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        String input;

        Customer cust;
        Manager manager;

        // if not in developer mode, go through all the progression steps
        if(!dev) {

            System.out.println("SWEN-383 Store POC:\n");

            // Business Requirement 1.1

            System.out.println("You are new! Fill in the data to create your account:");
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

            // create both a customer and a manager object so that the user can tamper with both sets of actions

            int id = (int) (Math.random() * 10000000); // user_id
            cust = new Customer(id, name, addr, mobile_phone, home_phone, email, credit_info, password);
            manager = new Manager(store, inventory, id, name, addr, mobile_phone, home_phone, email, credit_info, password);

            store.addCustomerToList(cust);

            System.out.println("\nThanks! We created you account. Your ID is: " + id + ". Use that with " +
                    "your password to log in below:\n");

            // Business Requirement 1.2
            boolean loginDone = false;
            while (!loginDone) {
                System.out.print("User ID: ");
                String user_id = scanner.nextLine();
                System.out.print("Password: ");
                String pass = scanner.nextLine();

                // validate credentials
                boolean result = cust.verify(Integer.parseInt(user_id), pass);
                if (result) {
                    System.out.println("You've logged in!");
                    loginDone = true;
                } else {
                    System.out.println("Login failed, try again");
                }
            }

        // if you are in dev mode, create the hardcoded objects and skip the above interaction
        } else {
            int id = (int) (Math.random() * 10000000); // user_id
            cust = new Customer(id, "name", "addy", "978", "978", "email", "info", "pass");
            manager = new Manager(store, inventory, id, "name", "addy", "978", "978", "email", "info", "pass");
        }

        boolean doneUsingCustomer = false;
        boolean doneUsingManager  = false;

        // This is the main menu where the user will be able to choose certain person's actions
        while(!done) {
            System.out.println("\nWould you like to access Customer or Manager actions?");
            System.out.println("\n1. Customer");
            System.out.println("2. Manager");
            System.out.println("3. Exit program");
            System.out.print("\nInput (1, 2, or 3): ");
            input = scanner.nextLine();

            // Customer Actions
            // this is where we are going to add all the actions customers can perform
            if(input.equals("1")) {
                doneUsingCustomer = false;

                while(!doneUsingCustomer) {

                    System.out.println("\nHere are your menu actions:\n");
                    System.out.println("0. Exit to main menu");
                    System.out.println("1. Change your account's name");
                    System.out.println("2. Reserve a Title");
                    System.out.println("3. Cancel Reservation");
                    System.out.println("4. Something else");
                    System.out.println("5. Something else");
                    System.out.println("6. Something else");

                    System.out.print("\nInput: ");
                    input = scanner.nextLine();

                    if(input.equals("0")) {

                        doneUsingCustomer = true;

                    } else if (input.equals("1")) {

                        // Business Requirement 1.3

                        System.out.println("\nOkay, enter your name to update our system");
                        System.out.print("\nInput: ");
                        String update_name = scanner.nextLine();
                        cust.updateInfo(update_name);
                        System.out.println("Thanks! Your name now is: " + cust.getName());

                    } else if (input.equals("2")) {

                    } else if (input.equals("3")) {

                    } else if (input.equals("4")) {

                    } else if (input.equals("5")) {

                    } else if (input.equals("6")) {

                    }
                }

            // Manager Actions
            // this is where we are going to add all the actions managers can perform
            } else if(input.equals("2")) {
                doneUsingManager = false;

                while(!doneUsingManager) {

                    System.out.println("\nHere are your menu actions:\n");
                    System.out.println("0. Exit to main menu");
                    System.out.println("1. Something Else");
                    System.out.println("2. Something else");
                    System.out.println("3. Something else");
                    System.out.println("4. Something else");
                    System.out.println("5. Add Item(s)");
                    System.out.println("6. Delete item");

                    System.out.print("\nInput: ");
                    input = scanner.nextLine();

                    if(input.equals("0")) {

                        doneUsingManager = true;

                    } else if (input.equals("1")) {

                        // action code goes here

                    } else if (input.equals("2")) {

                        // action code goes here

                    } else if (input.equals("3")) {

                        // action code goes here

                    } else if (input.equals("4")) {
                    
                        // action code goes here

                    } else if (input.equals("5")) {

                        // Business Requirement 5.1 and 6.1
                        // Manager can add item(s)
                        boolean cont = true;
                        
                        while(cont){
                           System.out.println("\nEnter Information below.");
                           System.out.print("\nTitle: ");
                           String title = scanner.nextLine();
                           System.out.print("\nInventory Amount: ");
                           int inventoryAmount = scanner.nextInt();
                           scanner.nextLine();    // Fix cursor
                           System.out.print("\nType: ");
                           String type = scanner.nextLine();
                           type = type.toUpperCase();
                           System.out.println("You have entered a " + type + ": " + title);
                           System.out.println("There are " + inventoryAmount + " in stock.");
                           Item item = new Item(true, false, true, inventoryAmount, title, type);
                           items.add(item);
                           
                           System.out.println("\nHere is the complete list of titles in your inventory:\n");
                           System.out.format("%-25s%25s%10s", "Title", "Inventory Amount", "Type\n");
                           System.out.println("--------------------------------------------------------------");
                            for(Item num:items){
                               //this call may vary depending on the book implementation
                               System.out.format("%-30s%12d%18s", num.getName(), num.getInventoryAmount(), num.getType() + "\n");
                            }
                           
                           System.out.print("\nWould you like to add another selection? (y/n) ");
                           String ans = scanner.nextLine();
                           ans = ans.toUpperCase();
                           if(ans.equals("Y") || ans.equals("YES")){
                              // Debug: System.out.println("You answered yes");
                              cont = true;  
                           }
                           else{
                              //Debug: System.out.println("You answered something other than yes");
                              cont = false;
                           }
                        }

                    } else if (input.equals("6")) {

                        //Business Requirement 5.2 and 6.2
                        String selection ="";
                        
                        System.out.println("Enter the name of item:");
                        selection = scanner.nextLine();
                        
                        /*for(int i=0; i < items.size(); i++){
                           if(i.equals(selection))
                        
                        }*/
                        
                        Iterator<Item> itr = items.iterator(); 
                        while(itr.hasNext()){
                           Item nxt = itr.next();
                           
                           try{
                              if(nxt.getName().equals(selection)){
                                 items.remove(nxt);
                                 System.out.println("Success!");
                                 break;
                              }
                           }
                           catch(Exception e){
                              System.out.println("No item by that title");
                           }
                        }
                        

                    }
                }
            } else if(input.equals("3")) {
                System.out.println("Thanks for using our system! Goodbye!");
                System.exit(0);
            }
        }
    }
}
