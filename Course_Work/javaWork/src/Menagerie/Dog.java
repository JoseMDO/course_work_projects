package Menagerie;

public class Dog extends Pet{
    public int playful;
    public int walk;

    public Dog(){
        walk = 0;
        playful = 0;
    }

    public Dog(String name, int age, double weight){
        super(name,age,weight);
    }

    @Override
    public void initialCutOffs(){
         sleep = 20;
         attention = 17;
         eat = 5;
         walk = 10;
         playful = 15;
    }

    @Override
    public String getType(){
        return "Dog";
    }
    
    public boolean isPlayful(){
        int playfulChoice = brain.nextInt(24);
        if (playfulChoice < playful){
            return true;
        } else{
            return false;
        }
    }
    public boolean isWalking(){
        int walkingChoice = brain.nextInt(24);
        if (walkingChoice < walk){
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
        String walkResult = "";
        String playResult = "";
        if (isEating() == true){
            eatResult = String.format("The %s, %s, was hungry and ate.\n", getType(), name);
        } if (isSleeping() == true){
            sleepResult = String.format("The %s, %s, was sleepy and took a nap.\n", getType(), name);
        } if (needsAttention() == true){
            attentionResult = String.format("The %s, %s, wanted your attention.\n", getType(), name);
        } if (isWalking() == true){
            walkResult = String.format("The %s, %s, went for a run in the backyard.\n", getType(), name);
        } if (isPlayful() == true){
            playResult = String.format("The %s, %s, was playful and played with its toys.\n", getType(), name);
        } else {
            result = "";
        }
        return (eatResult + sleepResult + attentionResult + walkResult + playResult + result);
        
        
    }
}

    

