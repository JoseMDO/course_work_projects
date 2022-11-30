package Muse;

import java.util.LinkedHashMap;

public class Poem extends WrittenArtisticWork {
    private String meter;
    public String getMeter() {
        return meter;
    }
    public void setMeter(String meter) {
        this.meter = meter;
    }
    public Poem() {
        meter = "N/A";
    }
    public Poem(String creator, String date, String title, String description,              // things needed to create a poem 
            String language, String text, String meter) {
        super(creator,date,title,description,language,text);
        setMeter(meter);
    }
    public Poem(LinkedHashMap<String,String> settings) {
        super(settings);
        setMeter(settings.get("meter"));
    }
    @Override
    public String getType() {                   // gets the type 
        return "poem";
    }
    @Override
    public String getSpecificInfoString() {             // specific info for a poem 
        return String.format("Meter: %s\n%s", meter, super.getSpecificInfoString());
    }
 
    @Override
    public String toTabDelimitedString(){               // tab delimited for a poem 
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
        getTitle(), getType(), getCreator(), getDate(), getLanguage(), getMeter(),super.getSpecificInfoString(),getDescription(), getCommentsAsDelimitedString());
    }

}
