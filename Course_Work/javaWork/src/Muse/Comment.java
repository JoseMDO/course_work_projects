package Muse;
import java.io.Serializable;


public class Comment implements Serializable {
    private String postedBy;
    private String dateTime;
    private String content;
    public String getPostedBy() {                 // This class creates the comments and how they work. 
        return postedBy;
    }
    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Comment() {              // defualt creator 
        postedBy = "";
        dateTime = "";
        content = "";
    }
    public Comment(String postedBy, String dateTime, String content) {      // non defualt creator 
        setPostedBy(postedBy);
        setDateTime(dateTime);
        setContent(content);
    }
    @Override
    public String toString() {                      // creates a string version of the comment      // prints comments as as a string 
        return String.format("On %s, %s commented ...\n\t\"%s\"", dateTime, postedBy, content);
    }

    public String toDelimitedString() {                     // prints the comments as a delimited file to break them up and read them back in 
        return String.format("%s-%s-%s_", dateTime,postedBy, content);
    }
}
