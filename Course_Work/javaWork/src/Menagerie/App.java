package Menagerie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String animalChoice = "";
        String name;
        int age;
        double weight;
        ArrayList<Pet> pets = new ArrayList<Pet>();
        ArrayList<Pet> petsFromFile = new ArrayList<Pet>();
        PetWriter pw = new PetWriter();
        PetReader pr = new PetReader();
        Dog dog = new Dog();
        Cat cat = new Cat();
        Fish fish = new Fish();
        Boolean dogChoice = false;
        Boolean catChoice = false; 
        Boolean fishChoice = false;
        int choice2 = 0;

        System.out.println("**********************************************");
        System.out.println("       Menagerie V1.0: The Pet Simulator      ");
        System.out.println("**********************************************");
        System.out.println("");

        do {          // menu that keeps going until user enters appropriate digits
            System.out.println("What would you like to do?");
            System.out.println("1. Add a new pet.");
            System.out.println("2. Print list of pets.");
            System.out.println("3. Save pets to a file");
            System.out.println("4. Load pets from a file.");
            System.out.println("5. Simulate a day in the life of your pets.");
            System.out.println("6. Clear your list of pets.");
            System.out.println("7. Exit");
            do{
                do{
                    try{
                        System.out.print("Enter the number of your choice: ");
                        choice = sc.nextInt();
                        sc.nextLine();
                        choice2 = 0;
                    } catch (Exception ex){
                        System.out.println("You must select an integer between 1 - 7.");
                        sc.nextLine();
                        choice2 = 1;
                    }
                }while (choice2 == 1);
                
            }while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7);    
            System.out.println("");

            if (choice == 1){
                do{ // makes the user type in either d c or f
                    System.out.print("Enter d for dog, c for cat, f for fish: ");
                    animalChoice = sc.nextLine();
                } while(!animalChoice.equalsIgnoreCase("d") && !animalChoice.equalsIgnoreCase("c") && !animalChoice.equalsIgnoreCase("f"));
                if (animalChoice.equalsIgnoreCase("d")){       // creates each type of pet 
                    System.out.print("Enter name, age, and weight: ");
                    name = sc.next();
                    age = sc.nextInt();
                    weight = sc.nextDouble();
                    sc.nextLine();
                    dog = new Dog(name, age, weight);
                    pets.add(dog);
                    choice = 0;
                    dogChoice = true;
                } else if (animalChoice.equalsIgnoreCase("c")){
                    System.out.print("Enter name, age, and weight: ");
                    name = sc.next();
                    age = sc.nextInt();
                    weight = sc.nextDouble();
                    sc.nextLine();
                    cat = new Cat(name, age, weight);
                    pets.add(cat);
                    choice = 0;
                    catChoice = true;
                } else if (animalChoice.equalsIgnoreCase("f")){
                    System.out.print("Enter name, age, and weight: ");
                    name = sc.next();
                    age = sc.nextInt();
                    weight = sc.nextDouble();
                    sc.nextLine();
                    fish = new Fish(name, age, weight);
                    pets.add(fish);
                    choice = 0;
                    fishChoice = true;
                }
                System.out.println("");

            } if (choice == 2){     // calls pet writer to print to screen 
                System.out.println("Here is your list of pets:");
                pw.writeToScreen(pets);
                System.out.println("");
                choice = 0;

            } if (choice == 3){ // calls pet writer to print to a text file 
                System.out.print("Enter name of file to save: ");
                String fileWriteChoice = sc.nextLine();
                if (pw.writeToFile(pets, fileWriteChoice) == true){
                    System.out.println("The pets were saved to the file");
                } else {
                    System.out.println("There was a problem saving the file.");
                }
                System.out.println("");
                choice = 0;

            } if (choice == 4){  /// calls petreader to read from a text file 
                String fileReadChoice, petType;
                System.out.print("Enter name of file to load: ");
                fileReadChoice = sc.nextLine();
                petsFromFile = pr.readFromFile(fileReadChoice);
                if (petsFromFile == null){
                    System.out.println("There was a problem reading the file.");
                } else{
                    for (Pet p : petsFromFile){
                        pets.add(p);
                        petType = p.getType();
                        if (petType.equalsIgnoreCase("dog")){
                            dogChoice = true;
                        } else if (petType.equalsIgnoreCase("cat")){
                            catChoice = true;
                        } else if (petType.equalsIgnoreCase("fish")){
                            fishChoice = true;
                        }
                    }  
                    System.out.println("The pets were read from the file.");
                    System.out.println("");
                }
                choice = 0;
                
            } if (choice == 5){ // goes through every pet in the list 24 times and calls their own act function to se what they are doing
                Collections.sort(pets);
                if (dogChoice == false && catChoice == false && fishChoice == false){
                    System.out.println("You have no pets in your collection. So there was no activity. Please go get a pet. Everyone needs at least one.");
                    System.out.println("");
                } else {
                    for (int i = 0; i < 24; i++){
                        System.out.printf("HOUR %d\n", i + 1);
                        System.out.println("-------");
                        for (Pet pet : pets){
                            pet.initialCutOffs();
                            System.out.print(pet.act());
                        }
                        System.out.println("");
                    }
                }
                System.out.println("");

            } if (choice == 6){  // clears the list of pets 
                pets.clear();
                dogChoice = false;
                catChoice = false;
                fishChoice = false;
                choice = 0;
            }
                
        } while (choice != 7);
        System.out.println("");
        System.out.println("Thank you for using Menagerie. We hope you had fun.");
    }
}
