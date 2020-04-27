
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 *         Samuel Crouch
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

            store.addCustomerToList(cust);
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
                    System.out.println("4. See the Status of an Item");
                    System.out.println("5. Something Else");
                    System.out.println("6. Return an Item");
                    System.out.println("7. Rent an Item");
                    System.out.println("8. Something else");

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

                        // Business Requirement 2.1
                        boolean choosing_item = false;
                        Item chosen_item = null;

                        while(!choosing_item) {

                            System.out.println("Here are the list of titles we have: ");
                            ArrayList<Item> items_list = store.getInventoryList();
                            for (int i = 0; i < items_list.size(); i++) {
                                System.out.println(i + ". " + items_list.get(i).getName());
                            }

                            System.out.print("\nPlease write the number that you wish to reserve: ");
                            input = scanner.nextLine();

                            if (Integer.parseInt(input) < items_list.size()) {
                                choosing_item = true;
                                chosen_item = items.get(Integer.parseInt(input));
                            } else {
                                System.out.println("Sorry that's not an option, please try again!");
                            }
                        }

                        if(chosen_item.getCustomerPlace(cust) == -1) {
                            if (cust.reserveItem(chosen_item)) {
                                System.out.println("\nWe successfully reserved that item for you! You are position " +
                                        (chosen_item.getCustomerPlace(cust) + 1) + " for " + chosen_item.getName());
                            }
                        } else {
                            System.out.println("\nYou are already on the reservation list and are position " +
                                    (chosen_item.getCustomerPlace(cust) + 1) + " for " + chosen_item.getName());
                        }

                    } else if (input.equals("3")) {
                        // Business Requirement 2.2

                        if (cust.getReservedItems().size() != 0) {

                            System.out.println("\nHere are the item's you current are reserving:");
                            for (int i = 0; i < cust.getReservedItems().size(); i++) {
                                System.out.println(i + ". " + cust.getReservedItems().get(i).getName());
                            }
                            System.out.println("\nWhich item would you like to cancel your reservation for?");
                            System.out.print("\nInput: ");
                            input = scanner.nextLine();
                            if (Integer.parseInt(input) < cust.getReservedItems().size()) {
                                if (cust.cancelReservation(cust.getReservedItems().get(Integer.parseInt(input)))) {
                                    System.out.println("\nWe have successfully removed your reservation.");
                                } else {
                                    System.out.println("\nWe were unable to cancel your reservation at this time, please " +
                                            "try again later");
                                }
                            } else {
                                System.out.println("\nYou currently don't have any items reserved!");
                            }

                        }

                    } else if (input.equals("4")) {

                        System.out.println("Here are the items we have in the store, please choose one to get information on it:");

                        items = store.getInventoryList();
                        for(int i = 0; i < items.size(); i++) {
                            System.out.println(i + ". " + items.get(i).getName());
                        }

                        System.out.print("\nInput: ");
                        input = scanner.nextLine();

                        System.out.println("\n" + items.get(Integer.parseInt(input)));

                    } else if (input.equals("5")) {

                    } else if (input.equals("6")) {

                        // Business Requirement 4.1 and 3.2

                        if(cust.getRentedItems().isEmpty()) {

                            System.out.println("\nYou don't have any items rented right now!");

                        } else {

                            System.out.println("\nHow many items would you like to return?");
                            System.out.println("\nHere are all of your items that you're renting: ");
                            for (int i = 0; i < cust.getRentedItems().size(); i++) {
                                System.out.println(i + ". " + cust.getRentedItems().get(i).getName());
                            }

                            System.out.print("Input: ");
                            input = scanner.nextLine();

                            try {
                                int num = Integer.parseInt(input);
                                System.out.println("Please input the numbers that correspond with the items you wish to return, one at a time: ");
                                for(int i = 0; i < num; i++){
                                    System.out.print("\nInput: ");
                                    input = scanner.nextLine();

                                    if (Integer.parseInt(input) < cust.getRentedItems().size()) {
                                        if(cust.returnItem(cust.getRentedItems().get((Integer.parseInt(input))))) {
                                            System.out.println("\nThere was a late fee that was applied to your account because " +
                                                    "you didn't return the item before the return due date.");
                                        }
                                        System.out.println("\nYou successfully returned that item!");
                                    } else {
                                        System.out.println("\nSorry, I don't think that's the correct input. Try again.");
                                        i--;
                                    }
                                }

                            } catch(Exception e){
                                System.out.println("That's not a number I can process, sorry.");
                            }
                        }

                    } else if (input.equals("7")) {

                        // Business Requirement 3.1, 4.2, 4.3, 4.4, 4.5 (Except 4.5.6)

                        // Business Requirement 4.3
                        boolean notPaid = true;
                        while(notPaid) {
                            if (cust.getAccountBalance() >= 50) {

                                System.out.printf("\nBe known that you have $%4.2f worth of fees " +
                                        "that must be paid off now before a new rental process. Would you like to continue?", cust.getAccountBalance());
                                System.out.print("\nInput (Y/N): ");
                                input = scanner.nextLine();

                                if (input.equalsIgnoreCase("y")) {

                                    System.out.println("\nWould you like to see the charges before?");
                                    System.out.print("\nInput (Y/N): ");
                                    input = scanner.nextLine();

                                    if (input.equalsIgnoreCase("y")) {
                                        System.out.println(cust.showInquiry());
                                    }

                                    System.out.printf("Would you like to pay off these charges of $%4.2f?\n", cust.getAccountBalance());
                                    System.out.print("\nInput(Y/N): ");
                                    input = scanner.nextLine();

                                    if (input.equalsIgnoreCase("y")) {

                                        System.out.println("\nHow would you like to pay? Cash, creditcard, or debitcard?");
                                        System.out.print("\nInput: ");
                                        input = scanner.nextLine();

                                        if (cust.payFees(input, cust.getAccountBalance(), "USD")) {
                                            System.out.println("\nAwesome, you paid off your fees! Now onto renting your item");
                                            notPaid = false;
                                        }
                                    } else {
                                        System.out.println("\nI'm sorry, but you have to pay your fees before renting another item. Please comply");
                                    }
                                } else {
                                    System.out.println("\nI'm sorry, but you have to pay your fees before renting another item. Please comply");
                                }
                            } else {
                                notPaid = false;
                            }
                        }

                        System.out.println("\nHere are the titles you can choose from: ");

                        items = store.getInventoryList();

                        for(int i = 0; i < items.size(); i++) {
                            if(items.get(i).isAvailable() || items.get(i).getCustomerPlace(cust) == 0) {
                                System.out.println(i + ". " + items.get(i).getName());
                            }
                        }
                        System.out.println("\nPlease choose your item.");
                        System.out.print("\nInput: ");
                        String item_selection = scanner.nextLine();

                        System.out.println("How would you like to pay? Cash, creditcard, or debitcard?");
                        System.out.print("\nInput: ");
                        String method = scanner.nextLine();

                        boolean success;

                        try {
                            // Business Requirement 4.2 - Allow customer to pay fees while renting item
                            if(cust.getAccountBalance() > 0) {
                                System.out.println("I see you have some fees applied to your account, would you like to view them?");
                                System.out.print("\nInput(Y/N): ");
                                input = scanner.nextLine();
                                if(input.equalsIgnoreCase("y")) {
                                    System.out.println(cust.showInquiry());
                                }
                                System.out.println("Would you like to pay your fees during this time?");
                                System.out.print("\nInput(Y/N): ");
                                input = scanner.nextLine();
                                if(input.equalsIgnoreCase("y")) {
                                    // Business Requirement 8/8.1
                                    success = cust.rentItem(items.get(Integer.parseInt(item_selection)), true, method, store.getStoreId());
                                } else {
                                    // Business Requirement 8/8.1
                                    success = cust.rentItem(items.get(Integer.parseInt(item_selection)), false, method, store.getStoreId());
                                }
                            } else {
                                // Business Requirement 8/8.1
                                success = cust.rentItem(items.get(Integer.parseInt(item_selection)), false, method, store.getStoreId());
                            }

                            if(success) {
                              System.out.println("You have successfully rented the title " + items.get(Integer.parseInt(item_selection)).getName() + "!");
                            } else {
                                System.out.println("\nI'm sorry, we couldn't rent you the item at this time, please try again later");
                            }

                        } catch(Exception e) {
                            System.out.println("That wasn't a valid input, please try again\n");
                        }

                    } else if (input.equals("8")) {

                    }
                }

            // Manager Actions
            // this is where we are going to add all the actions managers can perform
            } else if(input.equals("2")) {
                doneUsingManager = false;

                while(!doneUsingManager) {

                    System.out.println("\nHere are your menu actions:\n");
                    System.out.println("0. Exit to main menu");
                    System.out.println("1. Create Customer Report");
                    System.out.println("2. Create Inventory Report");
                    System.out.println("3. Set Retail Period");
                    System.out.println("4. Set Retail Rate");
                    System.out.println("5. Add Item(s)");
                    System.out.println("6. Delete Item");

                    System.out.print("\nInput: ");
                    input = scanner.nextLine();

                    if(input.equals("0")) {

                        doneUsingManager = true;

                    } else if (input.equals("1")) {

                        // Business Requirement 10
                        System.out.println("\nChoose a report type:\n");
                        System.out.println("1. All customers");
                        System.out.println("2. Customers with overdue items");
                        System.out.println("3. Customers with fines");

                        System.out.print("\nInput: ");
                        input = scanner.nextLine();

                        String file_name = "";
                        if (input.equals("1")) {
                            file_name = manager.createCustomerReport("all");
                        } else if (input.equals("2")) {
                            file_name = manager.createCustomerReport("overdue");
                        } else if (input.equals("3")) {
                            file_name = manager.createCustomerReport("fines");
                        }

                        if(!file_name.equals("")) {
                            System.out.println("\nCustomer report ("+file_name+") created");
                        } else {
                            System.out.println("\nThe customer report could not be created, try again");
                        }

                    } else if (input.equals("2")) {

                        // Business Requirement 11
                        String file_name = manager.createInventoryReport();
                        if(!file_name.equals("")) {
                            System.out.println("\nInventory report ("+file_name+") created");
                        } else {
                            System.out.println("\nThe inventory report could not be created, try again");
                        }

                    } else if (input.equals("3")) {

                        // Business Requirement 7.1

                        System.out.println("\nEnter a title to update the retail period of");
                        System.out.print("\nInput: ");
                        String title_name = scanner.nextLine();
                        // If needed, update format to expected format!!!
                        System.out.println("\nEnter a retail period in terms of milliseconds: ");
                        System.out.print("\nInput: ");
                        String periodString = scanner.nextLine();
                        try {
                            if(manager.setRentalPeriod(title_name, Double.parseDouble(periodString))) {
                                System.out.println("\nThe retail period of "+title_name+" was successfully updated to "+periodString + " milliseconds!");
                            } else {
                                System.out.println("\nThe retail period could not be updated. Check the input title");
                            }
                        } catch (Exception e) {
                            System.out.println("\nThe retail period was not formatted correctly, try again");
                        }

                    } else if (input.equals("4")) {

                        // Business Requirement 7.2

                        System.out.println("\nEnter a title to update the retail rate of");
                        System.out.print("\nInput: ");
                        String title_name = scanner.nextLine();
                        System.out.println("\nEnter a retail rate");
                        System.out.print("\nInput: ");
                        String rateString = scanner.nextLine();
                        try {
                            double retail_rate = Double.parseDouble(rateString);
                            if (manager.setRetailRate(title_name, retail_rate)) {
                                System.out.println("\nThe retail rate of " + title_name + " was successfully updated to " + retail_rate);
                            } else {
                                System.out.println("\nThe retail rate could not be updated. Check the input title");
                            }
                        } catch (NumberFormatException e){
                            System.out.println("\nThe retail rate was not formatted correctly, try again");
                        }

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
                           //Debug :System.out.println("You have entered a " + type + ": " + title);
                           //Debug: System.out.println("There are " + inventoryAmount + " in stock.");
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
                        selection = selection.toUpperCase();
                        
                        /*for(int i=0; i < items.size(); i++){
                           if(i.equals(selection))
                        
                        }*/
                        
                        Iterator<Item> itr = items.iterator(); 
                        while(itr.hasNext()){
                           Item nxt = itr.next();
                           
                           try{
                              if(nxt.getName().toUpperCase().equals(selection)){
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
