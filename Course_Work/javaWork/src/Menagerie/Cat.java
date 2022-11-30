package Menagerie;

public class Cat extends Pet {
    public int climbing;
    public int playful;
    public int purring;

    public Cat(){
        climbing = 0;
        playful = 0;
        purring = 0;
    }
    public Cat(String name, int age, double weight){
        super(name,age,weight);
    }

    @Override
    public void initialCutOffs(){
        sleep = 19;
        attention = 15;
        eat = 7;
        climbing = 13;
        playful = 16;
        purring = 10;
    }
    @Override
    public String getType(){
        return "Cat";
    }
    public boolean isClimbing(){
        int climbingChoice = brain.nextInt(24);
        if (climbingChoice < climbing){
            return true;
        } else {
            return false;
        }
    }

    public boolean isPlayful(){
        int playfulChoice = brain.nextInt(24);
        if (playfulChoice < playful){
            return true;
        } else {
            return false;
        }
    }

    public boolean isPurring(){
        int purringChoice = brain.nextInt(24);
        if (purringChoice < purring){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public String act(){
        String result = "";
        String sleepResult = "";
        String attentionResult = "";
        String eatResult = "";
        String climbResult = "";
        String playResult = "";
        String purrResult = "";
        if (isEating() == true){
            eatResult = String.format("The %s, %s, was hungry and ate.\n", getType(), name);
        } if (isSleeping() == true){
            sleepResult = String.format("The %s, %s, was sleepy and took a nap.\n", getType(), name);
        } if (needsAttention() == true){
            attentionResult = String.format("The %s, %s, wanted your attention.\n", getType(), name);
        } if (isClimbing() == true){
            climbResult = String.format("The %s, %s, was climbing in places they should not be climbing on.\n", getType(), name);
        } if (isPlayful() == true){
            playResult = String.format("The %s, %s, was playful and played with its toys.\n", getType(), name);
        } if (isPurring() == true){ 
            purrResult = String.format("The %s, %s, was feeling love and started purring.\n" , getType(), name);
        } else {
            result = "";
        }
        return eatResult + sleepResult + attentionResult + climbResult + playResult + purrResult + result;
    }
}
