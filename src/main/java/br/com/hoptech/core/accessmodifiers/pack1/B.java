package br.com.hoptech.core.accessmodifiers.pack1;

public class B {
    public static void main(String[] args) {
        A a = new A();
        //a.attAPrivate - not visible
        a.attAPublic = "Visible";
        a.attADefault = "Visible";
        a.attAProtected = "Visible";
    }
}
