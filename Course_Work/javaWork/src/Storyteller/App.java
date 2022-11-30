package Storyteller;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class App {
    public static void printHeading(){
        System.out.println("***************************************************");
        System.out.println("                 STORYTELLER V1.0                  ");
        System.out.println("***************************************************");
        System.out.println();
        System.out.println("Welcome to StoryTeller, a sophisticated electronic");
        System.out.println("author. This program reads from a list of words of");
        System.out.println("various parts of speech and creates a story from");
        System.out.println("them. You can tune the richness of the writing by");
        System.out.println("changing how frequently adjectives adverbs, and ");
        System.out.println("prepositions should be included.");
        System.out.println();
    }

    public static void main(String[] args){
        String fname;
        Scanner sc = new Scanner(System.in);
        printHeading();
        int choice2 = 0;
        int choice = 0;
        int choice3 = 0;
        int sentenceCount = 0;
        String repeat = "";
        int adjCount, advCount, prepCount = 0;

        
        do{
            try{
                System.out.print("Enter the name of the word file: ");
                fname = sc.nextLine();
                Scanner fsc = new Scanner (new File(fname));                        // tests to make sure word file was able to be read 
                System.out.println();
                LinkedHashMap <String, ArrayList<String>> words = WordFileReader.readFile(fname);     //creates linked hashmap with words and types from author class
                choice = 0;
            do{
                do{
                    try{
                        System.out.print("How many sentences would you like in your story? ");
                        sentenceCount = sc.nextInt();
                        sc.nextLine();
                        while(sentenceCount < 0){                                           // if they enter a negative number they must try again until positive is entered 
                            System.out.println("You must select a number 0 or greater.");
                            System.out.print("How many sentences would you like in your story? ");
                            sentenceCount = sc.nextInt();
                            sc.nextLine();
                        }
                        System.out.println("On a scale of 1 to 10...");

                        do{
                            try{                                        // tests to make sure they entered an integer for the sentence count or else makes them restart their selections 
                                System.out.print("  How frequently should adjectives be used? ");
                                adjCount = sc.nextInt();
                                sc.nextLine();
                                choice3 = 0;
                            while(adjCount < 0 || adjCount > 10){         // tests to make sure that integer is between 1 and 10 for all three types
                                System.out.println("You must select an integer between 1 and 10.");
                                System.out.print("  How frequently should adjectives be used? ");
                                adjCount = sc.nextInt();
                                sc.nextLine();
                                choice3 = 0;
                            }
                                System.out.print("  How frequently should adverbs be used? ");
                                advCount = sc.nextInt();
                                sc.nextLine();
                                choice3 = 0;
                                while(advCount < 0 || advCount > 10){
                                    System.out.println("You must select an integer between 1 and 10.");
                                    System.out.print("  How frequently should adverbs be used? ");
                                    advCount = sc.nextInt();
                                    sc.nextLine();
                                    choice3 = 0;
                            }
                                System.out.print("  How frequently should prepositions be used? ");
                                prepCount = sc.nextInt();
                                sc.nextLine();
                                choice3 = 0;
                                while(prepCount < 0 || prepCount > 10){
                                    System.out.println("You must select an integer between 1 and 10.");
                                    System.out.print("  How frequently should prepositions be used? ");
                                    prepCount = sc.nextInt();
                                    sc.nextLine();
                                    choice3 = 0;
                                }
                            System.out.println("Here it is:");
                            Author creator = new Author(adjCount,advCount,prepCount, words);   // creates new author object with the words and the frequencies selected 
                            System.out.println(creator.tellStory(sentenceCount));              // uses the tell story method the number of times of sentence count to make a story 
                            choice2 = 0; 
                            } catch (Exception ex){
                                System.out.println("You must select an integer between 1 and 10.");
                                sc.nextLine();
                                choice3 = -1;
                            }
                        } while(choice3 == -1);
                    } catch( Exception ex){                         // fails if they enter anything other than an integer for sentence count 
                        System.out.println("You must select an Integer.");
                        sc.nextLine();
                        choice2 = -1;
                    }
                } while (choice2 == -1);
                
                
                do{
                    System.out.print("Would you like another story (y or n)? ");
                    repeat = sc.nextLine();
                } while(!repeat.equalsIgnoreCase("y") && !repeat.equalsIgnoreCase("n"));
                
            }while(repeat.equalsIgnoreCase("y"));
            System.out.println();
            System.out.println("Thank you for using StoryTeller!");

            } catch(Exception ex){
                System.out.println("There was a problem reading that file");
                choice = -1;
            }
        } while (choice == -1);
    }
}
                  


             
        
            
            
    


