package br.com.hoptech.various;

public class InherenceBehavior {

    public static void main(String[] args) {
        Animal cat1 = new Cat();
        cat1.makeSound();
        System.out.println(cat1.getClass().getName());

        Animal cat2 = (Animal) cat1;
        cat2.makeSound();
        System.out.println(cat2.getClass().getName());

        Animal cat3 = new Animal();
        cat3.makeSound();
        System.out.println(cat3.getClass().getName());

        Cat cat4 = (Cat) cat3;
        cat4.makeSound();
        System.out.println(cat4.getClass().getName());
    }

}

class Animal {
    public void makeSound() {
        System.out.println("Make animal sound");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meauuuu!!!!!");
    }
}