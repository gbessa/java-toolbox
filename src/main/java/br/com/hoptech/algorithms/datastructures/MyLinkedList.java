package br.com.hoptech.algorithms.datastructures;

public class MyLinkedList<T> {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        myLinkedList.print();
    }

    private Node<T> root;
    private Node<T> last;

    public void add(T value) {
        Node<T> newNode = new Node<>();
        newNode.setValue(value);
        if (root==null) {
            root = newNode;
        } else {
           last.setNext(newNode);
        }
        last = newNode;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> curNode = root;

        while (curNode!=null) {
            sb.append(curNode.getValue());
            curNode = curNode.getNext();
            if (curNode!= null) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

}

class Node<T> {
    private T value;
    private Node next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}