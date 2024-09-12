package br.com.hoptech.certification;

public class Question02 {
    @FunctionalInterface
    interface IFather {
        abstract float footballSkill();
    }

    @FunctionalInterface
    interface ISon extends IFather {
        //abstract float swimSkill();
        public static void run() {
            System.out.println("running");
        }
    }
}
