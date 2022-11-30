package WNBA;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class WNBA{
    public static String printHeading(String h){
        String res = "";
        String details = "***********************************";
        res = res + details + "\n" + "         " + h + "\n" + details + "\n";
        return res;
    }

    public static void printConference(String [] array, String conference){
            String[] parts;
            String teamName;
            int wins, losses;
            double pct, gb;
            System.out.printf("Standings for the %s\n", conference);
            System.out.printf("%s%20s%10s%10s%10s\n","Team Name","Wins","Losses","PCT","GB");
        for(String lines: array){
            parts = lines.split("\t");
            teamName = parts[0];
            wins = Integer.parseInt(parts[1]);
            losses = Integer.parseInt(parts[2]);
            pct = (double)(wins / 36.00);
            gb = Math.abs(wins - 26);
            System.out.printf("%-20s%9s%10s%10.3f%10.1f\n",teamName,wins,losses,pct,gb);
        }
        System.out.println("");

    }

    public static void combinedConfrences(ArrayList<String> array){
        String [] combinedConfrences = new String [12];
        combinedConfrences[0] = array.get(0);
        combinedConfrences[1] = array.get(6);
        combinedConfrences[2] = array.get(1);
        combinedConfrences[3] = array.get(2);
        combinedConfrences[4] = array.get(7);
        combinedConfrences[5] = array.get(8);
        combinedConfrences[6] = array.get(3);
        combinedConfrences[7] = array.get(9);
        combinedConfrences[8] = array.get(4);
        combinedConfrences[9] = array.get(10);
        combinedConfrences[10] = array.get(11);
        combinedConfrences[11] = array.get(5);
        String[] parts;
        String teamName;
        int wins, losses;
        double pct, gb;
        System.out.println("Combined Conference Standings");
        System.out.printf("%s%20s%10s%10s%10s\n","Team Name","Wins","Losses","PCT","GB");
        for(String lines: combinedConfrences){
            parts = lines.split("\t");
            teamName = parts[0];
            wins = Integer.parseInt(parts[1]);
            losses = Integer.parseInt(parts[2]);
            pct = (double)(wins / 36.00);
            gb = Math.abs(wins - 26);
            System.out.printf("%-20s%9s%10s%10.3f%10.1f\n",teamName,wins,losses,pct,gb);
        }
        System.out.println("");
        

    }




    public static void main(String[] Args){
        String heading = "2022 WNBA STANDINGS";
        String newHeading = printHeading(heading);
        System.out.println(newHeading);        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the standings filename: ");
        String fname = sc.nextLine();
        String line;
        String [] easternConference = new String [6];
        String [] westernConference = new String [6];
        String conference = "";
        int choice = 0, menuChoice = 0;
        ArrayList<String> stringFile = new ArrayList<String>();

        try{
            Scanner fsc = new Scanner (new File(fname));
            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                    if (line.equalsIgnoreCase("conference: eastern")){
                        conference = "Eastern Conference";
                    }else if (line.equalsIgnoreCase("conference: western")){
                        conference = "Western Conference";
                    } else if (line.length() > 0) {
                       stringFile.add(line);
                    }
                }
                for (int i = 0; i < stringFile.size() /2; i++){
                    easternConference[i] = stringFile.get(i);
                }
               for (int i = 0; i < stringFile.size()/2; i++){
                    westernConference[i] = stringFile.get(i + 6);
                }
            System.out.println("The teams have been read.");
        do {
            System.out.println("What would you like to see?");
            System.out.println("1. Eastern Conference");
            System.out.println("2. Western Conference");
            System.out.println("3. Combined");
            System.out.println("4. Exit");
            do{
                try{
                System.out.print("Enter the number of your choice: ");
                menuChoice = sc.nextInt();
                sc.nextLine();
                while(menuChoice != 1 & menuChoice != 2 & menuChoice != 3 & menuChoice != 4){
                    System.out.println("That is an invalid choice");
                    System.out.print("Enter the number of your choice: ");
                    menuChoice = sc.nextInt();
                    sc.nextLine();
                    choice = 0;
                }
                } catch(Exception ex){
                System.out.println("That is an invalid choice");
                menuChoice = 0;
                sc.nextLine();
                choice = -1;
                }
                if (menuChoice == 1){
                    System.out.println("");
                    conference = "Eastern Conference";
                    printConference(easternConference, conference);
                } else if (menuChoice == 2){
                    System.out.println("");
                    conference = "Western Conference";
                    printConference(westernConference, conference);
                } else if(menuChoice == 3){
                    System.out.println("");
                    conference = "Combined Conferences";
                    combinedConfrences(stringFile);
               }
            }while(menuChoice != 4);
            }while (choice == -1);
            
            

        System.out.println("Thank you for using this program.");
        }catch(Exception ex){
        System.out.println("That is an invalid choice.");
        System.out.println(ex);
        }

        
    }


    }


