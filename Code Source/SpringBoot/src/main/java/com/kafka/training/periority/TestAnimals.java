package com.kafka.training.periority;

public class TestAnimals {

    private static void checkTypeAnimal(Animals an){
        System.out.println("This is "+an.getName());
    }

    private static void checkTypeAnimal(Cat cat){
        System.out.println("This is "+cat.getName());
    }


    private static void checkNbe(double v){
        System.out.println("this is a double");
    }

    private static void checkNbe(float v){
        System.out.println("this is a flout");
    }

    public static void main(String[] args) {
        Animals animals = new Animals();
        animals.setName("An animal");

        Cat cat = new Cat();
        cat.setName("A Cat");
        checkTypeAnimal(animals);

        checkNbe(1.1);

        Animals animals1 = new Cat();
        checkTypeAnimal(cat);
    }

    private static void checkObject(Object o){
        System.out.println("This is an object ---");
    }

    private static void checkObject(Animals animals){
        System.out.println("This is an object animals");
    }
}
