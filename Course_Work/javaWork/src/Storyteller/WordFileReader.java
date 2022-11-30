package Storyteller;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class WordFileReader {
    public static LinkedHashMap<String, ArrayList<String>> readFile(String fname){
        try{
            LinkedHashMap<String, ArrayList<String>> wordsAndType = new LinkedHashMap<String, ArrayList<String>>();
            Scanner fsc = new Scanner(new File(fname));
            Scanner sc = new Scanner(System.in);
            String line, word, type = "";
            String[] parts;
            ArrayList<String> wordsNouns = new ArrayList<String>();
            ArrayList<String> wordsAdj = new ArrayList<String>();
            ArrayList<String> wordsAdv = new ArrayList<String>();
            ArrayList<String> wordsVerb = new ArrayList<String>();
            ArrayList<String> wordsPrep = new ArrayList<String>();

            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                parts = line.split(" ");
                word = parts[0];
                type = parts[1];
                if (type.equalsIgnoreCase("n")){
                    wordsNouns.add(word);
                    wordsAndType.put(type,wordsNouns);
                } else if( type.equalsIgnoreCase("adj")){
                    wordsAdj.add(word);
                    wordsAndType.put(type,wordsAdj);
                } else if (type.equalsIgnoreCase("adv")){
                    wordsAdv.add(word);
                    wordsAndType.put(type,wordsAdv);
                } else if (type.equalsIgnoreCase("v")){
                    wordsVerb.add(word);
                    wordsAndType.put(type,wordsVerb);
                }else if (type.equalsIgnoreCase("prep")){
                    wordsPrep.add(word);
                    wordsAndType.put(type,wordsPrep);
                }
            }
            fsc.close();
            return wordsAndType;
        } catch(Exception ex){
            return null;
        }
        
    }
    
}

