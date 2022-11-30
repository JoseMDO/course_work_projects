package Muse;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("unchecked")

public class ArtisticWorkReader {

    public ArrayList<Comment> createComments(String stringComments){  // This allows all the comments to be split up and broken down to their components so swhen we read them back in we can create them again 
        ArrayList<Comment> comments = new ArrayList<Comment>();
        String [] differentComments = stringComments.split("_");
        for (String c : differentComments){
            String [] commentParts = c.split("-");
            String dateTime = commentParts[0];
            String postedBy = commentParts[1];
            String content = commentParts[2];
            Comment comment = new Comment(postedBy,dateTime,content);
            comments.add(comment);
    }
    return comments;
}

    public ArrayList<ArtisticWork> readFromTextFile(String fname) {         // this reads from a text file 
        try{
            Scanner fsc = new Scanner(new File(fname));
            ArrayList<ArtisticWork> works = new ArrayList<ArtisticWork>();
            String line;
            String [] parts;
            String title, creator, type, date, description;
            ArrayList<Comment> comments = new ArrayList<Comment>();
            while (fsc.hasNextLine()){                          // all classes have the same initial parts 
                line = fsc.nextLine();
                line = line.trim();
                parts = line.split("\t");
                title = parts[0];
                type = parts[1];
                creator = parts[2];
                date = parts[3];
                if (type.equalsIgnoreCase("movie")){            // if the type is movie then it requires these things 
                    int duration = Integer.parseInt(parts[4]);
                    String fileName = parts[5];
                    double fileSize = Double.parseDouble(parts[6]);
                    String fileResolution = parts[7];
                    int frameRate = Integer.parseInt(parts[8]);
                    description = parts[9];
                    String commentsString = parts[10];
                    Movie movie = new Movie(creator,date,title,description,duration,fileName,fileSize,frameRate,fileResolution);
                    comments = createComments(commentsString);
                    for (Comment c : comments){
                        movie.addComment(c);
                    }
                    works.add(movie);
                } else if(type.equalsIgnoreCase("song")){ // if its a song it requires these things 
                    int duration = Integer.parseInt(parts[4]);
                    String fileName = parts[5];
                    double fileSize = Double.parseDouble(parts[6]);
                    int bpm = Integer.parseInt(parts[7]);
                    String key = parts[8];
                    description = parts[9];
                    String commentsString = parts[10];
                    Song song = new Song(creator,date,title,description,duration,fileName,fileSize,bpm,key);
                    comments = createComments(commentsString);
                    for (Comment c : comments){
                        song.addComment(c);
                    }
                    works.add(song);
                } else if (type.equalsIgnoreCase("poem")){          // if its a poem then it requires these things 
                    String language = parts[4];
                    String meter = parts[5];
                    String text = parts[6];
                    description = parts[7];
                    String commentsString = parts[8];
                    Poem poem = new Poem(creator,date,title,description,language,text,meter);
                    comments = createComments(commentsString);
                    for (Comment c : comments){
                        poem.addComment(c);
                    }
                    works.add(poem);
                } else if (type.equalsIgnoreCase("short story")){       // if its a short story it requres these things 
                    String language = parts[4];
                    String setting = parts[5];
                    String text = parts[6];
                    description = parts[7];
                    String commentsString = parts[8];
                    ShortStory story = new ShortStory(creator,date,title,description,language,text,setting);
                    comments = createComments(commentsString);
                    for (Comment c : comments){
                        story.addComment(c);
                    }
                    works.add(story);
                }
            }
            return works;
        } catch (Exception ex){
            System.out.println(ex);
            return null;
        }

         
    }
    public ArrayList<ArtisticWork> readFromBinaryFile(String fname){                // reads from a binary file 
        try{
            FileInputStream fis = new FileInputStream(new File(fname));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<ArtisticWork> works = (ArrayList<ArtisticWork>)ois.readObject();
            ois.close();
            return works;
        } catch (Exception ex){
            return null;
        }
    }
    public ArrayList<ArtisticWork> readFromXmlFile(String fname){           // reads from a xml file 
        try{
            XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(new File(fname))));
            ArrayList<ArtisticWork> works = (ArrayList<ArtisticWork>)dec.readObject();
            dec.close();
            return works;
        } catch (Exception ex){
            return null;
        }
    }


}
