package br.com.hoptech.collections;

interface ILinkedList {
    void addAtFront(MyLinkedList.Node node);
    void addAtEnd(MyLinkedList.Node node);
    void removeFront();
    void print();
}

public class MyLinkedList implements ILinkedList {

    public static void main(String[] args) {

        ILinkedList list = new MyLinkedList();
        list.removeFront();
        list.addAtEnd(new Node(1));
        list.addAtFront(new Node(1));
        list.addAtFront(new Node(2));
        list.addAtFront(new Node(3));
        list.addAtEnd(new Node(0));
        list.removeFront();
        list.print();
    }

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node first = null;

    @Override
    public void addAtFront(Node node) {
        node.next = first;
        first = node;
    }

    @Override
    public void addAtEnd(Node node) {
        if (first == null) {
            first = node;
        } else{
            Node currentNode = first;
            while (currentNode.next != null) currentNode = currentNode.next;
            currentNode.next = node;
        }
    }

    @Override
    public void removeFront() {
        if (first != null) first = first.next;
    }

    @Override
    public void print() {
        Node currentNode = first;
        while (currentNode != null) {
            System.out.print(currentNode.value + " -> ");
            currentNode = currentNode.next;
        }

    }

}

