package br.com.hoptech.challenges;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.LinkedList;
import java.util.Queue;

public class LoianeFilas01 {
    public static void main(String[] args) {

        Printer printer = new Printer();
        for (int i = 1; i<= 4; i++) {
            printer.queue.add(new Document("Doc." + String.valueOf(i), i));
        }

        printer.startPrinting();

        //System.out.println(printer.queue.peekLast());
    }
}

@Getter
@AllArgsConstructor
class Document {
    private String name;
    private int pages;
}

class Printer {
    public Printer() {
        this.queue = new LinkedList<>();
    }

    Queue<Document> queue;

    public void startPrinting() {
        while (queue.size() > 0) {
            this.print(queue.remove());
        }
    }

    private void print(Document doc) {
        try {
            Thread.sleep(doc.getPages() * 200); //Throws a checked exception
        } catch (InterruptedException e) {}
        System.out.printf("Printing %s\n", doc.getName());
    }

}
