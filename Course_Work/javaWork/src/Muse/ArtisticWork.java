package Muse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.io.Serializable;

public abstract class ArtisticWork implements Serializable{                // every artistic work will extend from this one. All these getters and setter will be the same for all 
    private String creator;
    private String date;
    private String title;
    private String description;
    private ArrayList<Comment> comments;

    public ArrayList<Comment> getComment(){
        return comments;
    }
    public void setComment(ArrayList<Comment> comments){
        this.comments = comments;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ArtisticWork() {                     // defualt class setup 
        date = "1/1/1900";
        title = "title";
        creator = "anonymous";
        description = "description";
        comments = new ArrayList<Comment>();
    }
    public ArtisticWork(String creator, String date, String title, String description) {        // non defualt class creator 
        setCreator(creator);
        setDate(date);
        setTitle(title);
        setDescription(description);
        comments = new ArrayList<Comment>();
    }
    public ArtisticWork(LinkedHashMap<String,String> settings) {    
        this(settings.get("creator"),settings.get("date"),settings.get("title"),settings.get("description"));
    }
    public abstract String getType();           // all classes will use this to get theit ype of work

    public String getGeneralInfoString() {          //we use these functions to create the string for the artistic work
        return String.format("%s, a %s by %s, posted on %s",title,getType(),creator,date);
    }
    public abstract String getSpecificInfoString();     // all classes will use this to get specific infor from the work

    public String getCommentsAsString() {       // this allows the commemnts to be shows as a string 
        String result = "";
        for (Comment comment : comments) {
            result = result + comment + "\n";
        }
        if (result.isBlank()) {
            return "No comments";
        }
        return result;
    }
    @Override
    public String toString() {                  // this is where those earlier fucntions are used  to create a string versionm of a piece fo work       
        return getGeneralInfoString() + "\n" + getSpecificInfoString() + "\nComments: \n" + getCommentsAsString();
    }
    public void addComment(String postedBy, String date, String content) {
        Comment comment = new Comment(postedBy, date, content);
        comments.add(comment);
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public String getShortString() {
        return String.format("\"%s\", a %s by %s", title, getType(), creator);
    }

    public String getCommentsAsDelimitedString(){           // allows the comments to be attained as tab delimited format
        String result = "";
        for (Comment comment : comments){
            result = result + comment.toDelimitedString();
        }
        if (result.isBlank()){
            return "No Comments";
        }
        return result;
    }

    public abstract String toTabDelimitedString();          // all classses will implement this to get a tab delimited format 
}
