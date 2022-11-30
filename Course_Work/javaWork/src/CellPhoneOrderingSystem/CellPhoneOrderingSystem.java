package CellPhoneOrderingSystem;
import java.util.Scanner;

public class CellPhoneOrderingSystem{

    public static String printHeading(String h){
        String res = "";
        String details = "******************************************************";
        res = res + details + "\n" + "         " + h + "\n" + details;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String heading = "CORPORATE CELL PHONE ORDERING SYSTEM";
        String newHeading = printHeading(heading);
        System.out.println(newHeading);
        System.out.println("Welcome to the corporate cell phone ordering system.");
        System.out.println("Here you can order multiple phones of different kinds");
        System.out.println("with various add-ons for your employees");
        System.out.println("");
        //System.out.print("How many phones will you purchase? ");
        int choice = 0, phoneCount = 0;
        double phoneTotal = 0 , everythingTotal = 0;
        double sizeChoice = 0;
        int storageChoice = 0;
        String addOns, phoneChoice, orderSummary = "", phoneTotalString = "", finalOrderSummary = "";
        do{
            try{
                System.out.print("How many phones will you purchase? ");
                phoneCount = sc.nextInt();
                choice = 0;
            } catch(Exception ex) {
                System.out.println("You must enter an integer.");
                sc.nextLine();
                choice = -1;
            }
        }while (choice == -1);
        
        sc.nextLine();
        for (int i = 0; i < phoneCount; i++) {      // Starts the for loop to go through every phone for th enumber the user choose
            System.out.printf("Lets configure phone #%d... \n", i + 1);
            do{
                System.out.print("Enter 'A' for Andriod or 'I' for iPhone: \n");
                phoneChoice= sc.nextLine();
            } while(!phoneChoice.equalsIgnoreCase("a") & !phoneChoice.equalsIgnoreCase("i"));
            
            if (phoneChoice.equalsIgnoreCase("a")){ // chooses the kind of phone and the price
                phoneTotal = 799;
                orderSummary = "Android";
            } else if (phoneChoice.equalsIgnoreCase("i")){
                phoneTotal = 849;
                orderSummary = "IPhone";
            } 

            do{
                try{
                    do{
                        System.out.print("What size screen? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": \n");
                        sizeChoice = sc.nextInt();
                        sc.nextLine();
                    } while (sizeChoice != 1 & sizeChoice != 2 & sizeChoice != 3);
                    choice = 0;
                } catch (Exception ex){
                    System.out.println("You must enter either 1, 2, or 3. Please try again.");
                    sc.nextLine();
                    choice = -1;
                } 
            }while (choice == -1);
        
        
            if (sizeChoice == 2){ // goes through size choices and proper prices 
                phoneTotal = (phoneTotal * .20) + phoneTotal;
                orderSummary = orderSummary + " 6.2\"";
            } else if (sizeChoice == 3){
                phoneTotal = (phoneTotal * .40) + phoneTotal;
                orderSummary = orderSummary + " 6.7\"";
            } else {
                orderSummary = orderSummary + " 5.6\"";
            }
            do{
                try{
                    do{
                        System.out.print("How much storage? Enter 64, 128, or 256: \n"); // choosing the storage size and adding cost to the total
                        storageChoice = sc.nextInt();
                        sc.nextLine();
                    } while (storageChoice != 64 & storageChoice != 128 & storageChoice != 256);
                    choice = 0;
                } catch(Exception ex){
                    System.out.println("You must enter either 64, 128, or 256. Please try again.");
                    sc.nextLine();
                    choice = -1;
                }
            } while (choice == -1);
                
            if (storageChoice == 128){
                phoneTotal = phoneTotal + 100;
                orderSummary = orderSummary + " 128GB";
             } else if (storageChoice == 256){
                phoneTotal = phoneTotal + 250;
                orderSummary = orderSummary + " 256GB";
             } else{
                orderSummary = orderSummary + " 64GB";
             }
            do { // do while loop to go through the menu as many times as the user wants to add accesories
                System.out.println("What add-on do you want?");
                System.out.println("  [C]ase ($49)");
                System.out.println("  [S]creen protector ($15)");
                System.out.println("  [E]ar buds ($99)");
                System.out.println("  [W]ireless charger ($59)");
                System.out.println("  [F]inish order");
                System.out.print("Enter the lettter of your choice: ");
                addOns = sc.next();
                sc.nextLine();

                if (addOns.equalsIgnoreCase("c")){
                    phoneTotal = phoneTotal + 49;
                    orderSummary = orderSummary + " / case";
                } if (addOns.equalsIgnoreCase("s")){
                    phoneTotal = phoneTotal + 15;
                    orderSummary = orderSummary + " / screen protector";
                } if (addOns.equalsIgnoreCase("e")){
                    phoneTotal = phoneTotal + 99;
                    orderSummary = orderSummary + " / ear buds";
                } if (addOns.equalsIgnoreCase("w")){
                    phoneTotal =   phoneTotal + 59;
                    orderSummary = orderSummary + " / wireless charger";
                } if (!addOns.equalsIgnoreCase("c") & !addOns.equalsIgnoreCase("s") &
                !addOns.equalsIgnoreCase("e") & !addOns.equalsIgnoreCase("w") & 
                !addOns.equalsIgnoreCase("f")){
                    System.out.println("You must select one of the letters of your choice.");
                }
                
            } while (!addOns.equalsIgnoreCase("f")); // changes the total to a string to add to the summary
            phoneTotalString = Double.toString(phoneTotal);
            orderSummary = orderSummary + " ($" + phoneTotalString + ")\n";
            finalOrderSummary = finalOrderSummary + orderSummary;
            everythingTotal = everythingTotal + phoneTotal;
            
        }
            
            System.out.println();
            System.out.println("Here is a summary of your order: ");
            System.out.println(finalOrderSummary);
            System.out.println("");
            System.out.printf("Your total cost is $%.2f.\n", everythingTotal);
            System.out.println("");
            System.out.println("Thank you for your order.");
            
        }

    }
    
    
