package StarlightCoffee;
import java.util.Scanner;


public class StarlightCoffee {
    public static String printHeading(String h){
        String res = "";
        String details = "*********************************************";
        res = res + details + "\n" + "    " + h + "\n" + details;
        return res;
    }
    public static void main(String[] args) {
        String heading = "STARLIGHT COFFEE POINT OF SALE SYSTEM";
        String newHeading = printHeading(heading);
        System.out.println(newHeading);
        Scanner sc = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = sc.nextLine();
        System.out.println("");
        System.out.println("What kind of coffee do you want?");
        System.out.println("1. Americano");
        System.out.println("2. Italiano");
        System.out.println("3. Espresso");
        System.out.println("4. Cappuccino");
        System.out.print("Enter the number of your choice: ");
        int coffeeChoice = sc.nextInt();
        sc.nextLine();
        double total = 0; 
        double drinkCost = 0;
        if (coffeeChoice == 1){
            total = 2.25;
            drinkCost = 2.25;
        } else if (coffeeChoice == 2) {
            total = 2.75;
            drinkCost = 2.75;
        } else if (coffeeChoice == 3){
            total = 3.50;
            drinkCost = 3.50;
        } else if (coffeeChoice == 4){
            total = 3.75;
            drinkCost = 3.75;
        }
        System.out.println("What size do you want?");
        System.out.println("1. Tall");
        System.out.println("2. Grande");
        System.out.println("3. Venti");
        System.out.print("Enter the number of your choice: ");
        int sizeChoice = sc.nextInt();
        sc.nextLine();
        double upcharge = 0;
        if (sizeChoice == 2){
            upcharge = drinkCost *.20;
            total = total + upcharge;
            drinkCost = drinkCost + upcharge;
        } else if (sizeChoice == 3){
            upcharge = drinkCost *.40;
            total = total + upcharge;
            drinkCost = drinkCost + upcharge;
        }
        System.out.println("How many extra shots of espresso would you like? ");
        int espressoShots = sc.nextInt();
        sc.nextLine();
        double espressoPrice = espressoShots * .50;
        total = total + espressoPrice;
        drinkCost = drinkCost + espressoPrice;
        System.out.print("Are you a member of Starlight Stars (y or n)? ");
        String starlightMember = sc.next();
        double discount = 0;
        if (starlightMember.equalsIgnoreCase("y")){
            discount = total * .10;
            total = total - discount;
        }
        System.out.println("What size tip would you like to leave?");
        System.out.println("1. Good service - 10%%");
        System.out.println("2. Great service - 15 %%");
        System.out.println("3. Outstanding service - 20 %%");
        System.out.print("Enter the number of your choice: ");
        int tipChoice = sc.nextInt();
        double tip = 0;
        sc.nextLine();
        if (tipChoice == 1){
            tip = drinkCost * .10;
            total = total + tip;
        } else if (tipChoice == 2){
            tip = drinkCost* .15;
            total = total + tip;
        } else if (tipChoice == 3){
            tip = drinkCost * .20;
            total = total + tip;
        }
        double taxes = 0;
        taxes =  (drinkCost - discount) * .0875;
        total = total + taxes;
        System.out.printf("Here is your bill, %s: \n", (name));
        System.out.printf("Beverage       $%5.2f \n", drinkCost);
        System.out.printf("Club Discount  $%5.2f \n", discount);
        System.out.printf("Tip Amount     $%5.2f \n", tip);
        System.out.printf("Taxes          $%5.2f \n", taxes);
        System.out.printf("Total          $%5.2f \n\n", total);
        System.out.println("Thank you for choosing Starlight Coffee!");
    }
}
