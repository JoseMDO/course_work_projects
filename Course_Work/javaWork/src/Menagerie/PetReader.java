package Menagerie;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PetReader {
    public ArrayList<Pet> readFromFile(String fname){
        try{
            Scanner fsc = new Scanner (new File(fname));
            ArrayList<Pet> pets = new ArrayList<Pet>();
            String line;
            String[] parts;
            String petType, name;
            int age;
            double weight;
            Dog dog;
            Cat cat;
            Fish fish;
            while (fsc.hasNextLine()){
                line = fsc.nextLine();
                line = line.trim();
                parts = line.split("\t");
                petType = parts[0];
                name = parts[1];
                age = Integer.parseInt(parts[2]);
                weight = Double.parseDouble(parts[3]);

                if (petType.equalsIgnoreCase("dog")){
                    dog = new Dog(name, age, weight);
                    pets.add(dog);
                } else if (petType.equalsIgnoreCase("cat")){
                    cat = new Cat(name, age, weight);
                    pets.add(cat);
                } else if (petType.equalsIgnoreCase("fish")){
                    fish = new Fish(name, age, weight);
                    pets.add(fish);
                }
            }
            return pets;
        } catch (Exception ex){
            return null;
        }
    }
}
