package Storyteller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class Author {
    private int adjFreq;
    private int advFreq;
    private int prepFreq;
    private LinkedHashMap<String,ArrayList<String>> wordList;


    public int getAdjFreq() {
        return adjFreq;
    }
    public void setAdjFreq(int adjFreq) {
        if (adjFreq < 0){
            this.adjFreq = 0;
        } else{
            this.adjFreq = adjFreq;
        }
    }
    public int getAdvFreq() {
        return advFreq;
    }
    public void setAdvFreq(int advFreq) {
        if (advFreq < 0){
            this.advFreq = 0;
        } else{
            this.advFreq = advFreq;
        }
    }
    public int getPrepFreq() {
        return prepFreq;
    }
    public void setPrepFreq(int prepFreq) {
        if (prepFreq < 0){
            this.prepFreq = 0;
        } else{
            this.prepFreq = prepFreq;
        }
    }
    public LinkedHashMap<String, ArrayList<String>> getWordList() {
        return wordList;
    }
    public void setWordList(LinkedHashMap<String, ArrayList<String>> wordList) {
        this.wordList = wordList;
    }
    
    public Author(){
        adjFreq = 0;
        advFreq = 0;
        prepFreq = 0;
        wordList = new LinkedHashMap<String,ArrayList<String>>();
    }
    public Author(int adjFreq, int advFreq, int prepFreq, LinkedHashMap<String,ArrayList<String>> wordList){
        setAdjFreq(adjFreq);
        setAdvFreq(advFreq);
        setPrepFreq(prepFreq);
        setWordList(wordList);
    }

    public String getWord(String type, LinkedHashMap<String,ArrayList<String>> wordList){
        ArrayList<String> words = wordList.get(type);
        int randomIndex = (int) (Math.random() * words.size());
        String word = words.get(randomIndex);
        return word;
    }

    public String getSentence(int adjFreq, int advFreq, int prepFreq){
        int adjRan, advRan, prepRan;
        Random rand = new Random();
        adjRan = rand.nextInt(11);
        advRan = rand.nextInt(11);
        prepRan = rand.nextInt(11);
        Boolean adjChoice = false;
        Boolean advChoice = false;
        Boolean prepChoice = false;
        String adjPart = getWord("adj", wordList);
        String advPart = getWord("adv",wordList);
        String prepPart = getWord("prep", wordList);
        String result = "";

        if (adjFreq == 10){
            adjChoice = true;
            } else if (adjFreq == 0){
                adjChoice = false;
            } else if (adjFreq > 0 && adjFreq < 10){
                if (adjRan > 0 && adjRan <= adjFreq){
                    adjChoice = true;
                }
            }

        if (advFreq == 10){
            advChoice = true;
            } else if (advFreq == 0){
                advChoice = false;
            } else if (advFreq > 0 && advFreq < 10){
                if (advRan > 0 && advRan <= advFreq){
                    advChoice = true;
                }
            }
        if (prepFreq == 10){
           prepChoice = true;
            } else if (prepFreq == 0){
                prepChoice = false;
            } else if (prepFreq > 0 && prepFreq < 10){
                if (prepRan > 0 && prepRan <= prepFreq){
                    prepChoice = true;
                }
            }

        if (adjChoice == true && advChoice == true && prepChoice == true){
            result = ("The " + adjPart + " " + getWord("n", wordList) + " " + getWord("v", wordList) + " " + 
            advPart + " " + prepPart + " the " + getWord("n", wordList)+ ".");
        } else if (adjChoice == true && advChoice == true){
            result = ("The " + adjPart + " " + getWord("n", wordList) + " " + getWord("v", wordList) + " " + 
            advPart +  ".");
        } else if (adjChoice == true && prepChoice == true){
            result = ("The " + adjPart + " " + getWord("n", wordList) + " " + getWord("v", wordList) + " " 
            + prepPart + " the " + getWord("n", wordList)+ ".");
        } else if (advChoice == true && prepChoice == true){
            result = ("The " + getWord("n", wordList) + " " + getWord("v", wordList) + " " + 
            advPart + " " + prepPart + " the " + getWord("n", wordList)+ ".");
        } else if (adjChoice == true){
            result = ("The " + adjPart + " " + getWord("n", wordList) + " " + getWord("v", wordList) + ".");
        } else if (advChoice == true){
            result = ("The " + getWord("n", wordList) + " " + getWord("v", wordList) + " " + advPart + ".");
        } else if (prepChoice == true){
            result = ("The " + getWord("n", wordList) + " " + getWord("v", wordList) + " " + 
            prepPart + " the " + getWord("n", wordList)+ ".");
        } else {
            result = ("The " + getWord("n", wordList) + " " + getWord("v", wordList) + ".");
        }

        return result;
        
    }

        


    public String tellStory(int count){
        String story = "";
        for (int i = 0; i < count ; i++){
            story = (story + getSentence(adjFreq, advFreq, prepFreq) + "\n");
        }
        return story;
    }

}

