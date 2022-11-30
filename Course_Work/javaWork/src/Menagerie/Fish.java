package Menagerie;

public class Fish extends Pet{
    public int swimming;
    public int playing;

    public Fish(){
        swimming = 0;
        playing = 0;
    }
    public Fish(String name, int age, double weight){
        super(name, age, weight);
    }

    @Override
    public void initialCutOffs(){
        sleep = 15;
        attention = 3;
        eat = 5;
        swimming = 10;
        playing = 8;
    }
    @Override
    public String getType(){
        return "Fish";
    }
    
    public boolean isSwimming(){
        int swimmingChoice = brain.nextInt(24);
        if (swimmingChoice < swimming){
            return true;
        } else {
            return false;
        }
    }
    public boolean isPlayful(){
        int playfulChoice = brain.nextInt(24);
        if (playfulChoice < playing){
            return true;            
        } else {
            return false;
        }
    }

    @Override
    public String act(){
        String result = "";
        String eatResult = "";
        String sleepResult = "";
        String attentionResult = "";
        String swimResult = "";
        String playResult = "";
        if (isEating() == true){
            eatResult = String.format("The %s, %s, was hungry and ate.\n", getType(), name);
        } if (isSleeping() == true){
            sleepResult = String.format("The %s, %s, was sleepy and took a nap.\n", getType(), name);
        } if (needsAttention() == true){
            attentionResult = String.format("The %s, %s, wanted your attention.\n", getType(), name);
        } if (isSwimming() == true){
            swimResult = String.format("The %s, %s, was swimming arounbd in its fishbowl.\n", getType(), name);
        } if (isPlayful() == true){
            playResult = String.format("The %s, %s, was playing and hanging around in the castle.\n", getType(), name);
        } else {
            result = "";
        }
        return eatResult + sleepResult + attentionResult + swimResult + playResult + result;
    }
}


