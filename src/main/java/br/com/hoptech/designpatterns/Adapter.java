package br.com.hoptech.designpatterns;

public class Adapter {

    public static void main(String[] args) {
        //Before
        ClasseB cbOld = new ClasseB();
        cbOld.print("Hi old world!");
        //Can use ClasseB, but not ClassC without modifications

        //After
        IB cb = new ClasseB();
        cb.print("Hi world !!!!!");
        IB cc = new AdapterCToB(new ClasseC());
        cc.print("Hi adapted world !!!!!");

    }

}

class ClasseB implements IB{

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}

class ClasseC {
    public void imprimir(String s) {
        System.out.println(s);
    }
}

class AdapterCToB implements IB {
    private ClasseC classeC;

    public AdapterCToB(ClasseC classeC) {
        this.classeC = classeC;
    }
    @Override
    public void print(String s) {
        this.classeC.imprimir(s);
    }
}

interface IB {
    public void print(String s);
}
