package br.com.hoptech.various;

import br.com.hoptech.reflection.ManipuladorMetodo;

public class AnonymousClassesBehavior {

    public static void main(String[] args) {

        Bird pigeon = new Bird();

        Bird hawk = new Bird() {
            @Override
            void fly() {
                System.out.println("Fly high");
            }
        };

        hawk.fly();
        pigeon.fly();
    }

}

class Bird {
    void fly() {
        System.out.println("Fly low!!");
    }
}

