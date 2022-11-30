package Menagerie;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class PetWriter {
    public void writeToScreen(ArrayList<Pet> pets){
        Collections.sort(pets);
        for (Pet p : pets){
            System.out.println(p);
        }
    }
    public boolean writeToFile(ArrayList<Pet> pets, String fname){
        try{
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))))) {
                Collections.sort(pets);
                for (Pet p : pets){
                    pw.println(p);
                }
            } 
                return true;
            
        } catch (Exception ex){
            return false;
        }
    }
}
