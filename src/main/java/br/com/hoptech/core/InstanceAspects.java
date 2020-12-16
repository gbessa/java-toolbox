package br.com.hoptech.core;

public class InstanceAspects {
    {
        System.out.println("Instance Block");
    }
    static {
        System.out.println("Static block");
    }
    public InstanceAspects() {
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        System.out.println("Main method init");
        InstanceAspects instance = new InstanceAspects();
    }
}
