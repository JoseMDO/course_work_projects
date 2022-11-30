package Muse;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ArtisticWorkWriter {
    public void writeToScreen(ArrayList<ArtisticWork> works){               // writes to the screen when user wnats to print the works 
        for (ArtisticWork work : works){
            System.out.println(work);
        }
    }

    public boolean writeToTextFile(ArrayList<ArtisticWork> works , String fname){               // writes to a text file 
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
                for (ArtisticWork work : works){
                pw.println(work.toTabDelimitedString());
            }
            pw.close();
            return true;       
        } catch (Exception ex){ 
            return false;
        }
    }

    public boolean writeToBinaryFile(ArrayList<ArtisticWork> works, String fname){          // writes to a binary file 
        try {
            FileOutputStream fos = new FileOutputStream(new File(fname));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(works);
            oos.close();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public boolean writeToXmlFile(ArrayList<ArtisticWork> works, String fname){         // writes to an xml file 
        try{
            XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(fname))));
            enc.writeObject(works);
            enc.close();
            return true;
        } catch(Exception ex){
            return false; 
        }
    }
        
}
