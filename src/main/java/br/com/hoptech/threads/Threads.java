package br.com.hoptech.threads;

public class Threads {
    public static void main(String[] args) {

        HeavyProcess heavyProcess = new HeavyProcess();
        heavyProcess.start();

        try {
            Thread.sleep(3000); //Throws a checked exception
        } catch (InterruptedException e) {}


        Thread heavyProcess2 = new Thread(new HeavyProcess2());
        heavyProcess2.start();
    }
}

class HeavyProcess extends Thread {
    @Override
    public void run() {
        System.out.println("Heavy process started!!");
    }
}

// Forma mais trabalhosa, porém mais indicada pois permite que nossa classe não perca a opção de herdar de outra classe.
class HeavyProcess2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Heavy process 02 started!!");
    }
}
