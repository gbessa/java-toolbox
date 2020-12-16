package br.com.hoptech.core.accessmodifiers.pack2;

import br.com.hoptech.core.accessmodifiers.pack1.A;

public class D extends A {
    public static void main(String[] args) {
        A a = new A();
        a.attAPublic = "Visible";
        //a.attADefault = "Invisible";
        //a.attAProtected = "Invisible";

        D d = new D();
        a.attAPublic = "Visible";
        //d.attADefault = "Invisible";
        d.attAProtected = "Visible";

    }
}
