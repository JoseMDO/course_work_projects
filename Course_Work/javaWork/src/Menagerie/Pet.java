package Menagerie;

import java.util.Random;

public abstract class Pet implements Comparable<Pet>{
    public String name;
    public int age;
    public double weight;
    public int eat;
    public int attention;
    public int sleep;
    public Random brain = new Random();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0){
            age = 0;
        } else{
            this.age = age;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0){
            weight = 0; 
        } else {
            this.weight = weight;
        }
    }


    public Pet(){
        name = "";
        age = 0;
        weight = 0.0;
    }

    public Pet(String name, int age, double weight){
        setName(name);
        setAge(age);
        setWeight(weight);

    }

    public abstract void initialCutOffs();
    public abstract String act();
    public abstract String getType();

    @Override
    public String toString() {
        return String.format("%s\t%s\t%d\t%.2f", getType(), name,  age, weight);
    }

    @Override
    public int compareTo(Pet other) {
        String myName = name;
        String otherName = other.name;
        return myName.compareTo(otherName);
    }

    public boolean isSleeping(){
        int sleepChoice = brain.nextInt(24);
        if (sleepChoice < sleep){
            return true;
        } else {
            return false;
        }
    }
    public boolean needsAttention(){
        int attentionChoice = brain.nextInt(24);
        if (attentionChoice < attention){
            return true;
        } else {
            return false;
        }

    }
    public boolean isEating(){
        int eatChoice = brain.nextInt(24);
        if (eatChoice < eat){
            return true;
        } else {
            return false;
        }
    }

}

