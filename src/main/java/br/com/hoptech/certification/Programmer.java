package br.com.hoptech.certification;

abstract class Writer {
    public static void write() {
        System.out.println("Writing...");
    }
}
   
public class Programmer extends Writer {
    
    public static void write() {
        System.out.println("Writing code");
    }
    
    public static void main(String[] args) {
        Writer w = new Programmer();
        w.write();
    }
}
   