package Muse;

import java.util.ArrayList;

public class SampleArtisticWorks {
    public ArrayList<ArtisticWork> generate(){
        ArrayList<ArtisticWork> works =new ArrayList<ArtisticWork>();
        Song song;
        Poem poem;
        ShortStory story;
        Movie movie;
        song =new Song("Joe Johnson","October 12, 2022","Unbearable Likeness","A song about unrequited love",
                    181,"unbearablelikeness.wav",12.8,128,"C major");
                song.addComment("Ray Klump","10/13/22","This song hits hard.");
                song.addComment("Mary Johnson","October 15, 2022", "Haunting and raw");
                works.add(song);


        poem = new Poem("Phoebe B.","2022-11-04","Roses Are Blue", "A poem about hazy confusion and the meaninglessness of it all.",
                        "English","This poem is flowin' like phloem // and I be knowin what be stolen from you.","iambicpentameter");
                poem.addComment("Manny Roeper","Nov. 6, 2022","Groundbreaking and real.");
                works.add(poem);


        story = new ShortStory("Al Johnson","Sept. 28, 2022","Goats on the Roof","A story about the homeland in spring",
            "English","This is a story about goats. But more importantly, it's a story about hope.","Sweden in Springtime");
                story.addComment("Jasmine Yobar","2022-10-03","I'm not from Sweden, but I sure could connect with this.");
                works.add(story);


        movie = new Movie("Steven Yeats","October 15, 2022","Dubliner in Paris","Seamus takes holiday in Paris and hilarity ensues.",
                    137,"dubliner.mp4",182.43,30,"1080p");
                movie.addComment("Roger Egbert","October 18, 2022","I'm not sure if this was supposed to be comedy or drama.");
                movie.addComment("Katie Kline","Oct. 26, 2022", "I laughed, I cried, I vomited because I was sick.");
                movie.addComment("Patrice Mulhaven","11-1-22","I don't know about the bad comments. Haters gonna hate.");
                works.add(movie);

        return works;
    }
}

