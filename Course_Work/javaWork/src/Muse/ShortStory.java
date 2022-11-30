package Muse;

import java.util.LinkedHashMap;

public class ShortStory extends WrittenArtisticWork {       
    public String setting;
    public String getSetting() {
        return setting;
    }
    public void setSetting(String setting) {
        this.setting = setting;
    }
    public ShortStory() {
        setting = "";
    }
    public ShortStory(String creator, String date, String title, String description,            // things needed to create a short story 
            String language, String text, String setting) {
        super(creator,date,title,description,language,text);
        setSetting(setting);
    }
    public ShortStory(LinkedHashMap<String,String> settings) {
        super(settings);
        setSetting(settings.get("setting"));
    }
    @Override
    public String getType() {           // gets the type of work 
        return "short story";
    }
    @Override
    public String getSpecificInfoString() {             // specific info for short story 
        return String.format("Setting: %s\n%s", setting, super.getSpecificInfoString());
    }
  
    @Override
    public String toTabDelimitedString(){
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",          // tab del for short story 
        getTitle(),getType(),getCreator(),getDate(),getLanguage(),getSetting(),super.getSpecificInfoString(),getDescription(),getCommentsAsDelimitedString());
    }
}
