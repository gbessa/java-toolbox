package br.com.hoptech.playground.neetcode;

import lombok.var;

import java.util.ArrayList;

class LinkedList {

    private Node head;

    public LinkedList() {

    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }

        Node targetNode = head;
        for (int i=0; i<index; i++) {
            targetNode = targetNode.nextNode;
            if (targetNode == null) return -1;
        }

        return targetNode.value;
    }

    public void insertHead(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            var newHead = new Node(val);
            newHead.nextNode = head;
            head = newHead;
        }
    }

    public void insertTail(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            var lastNode = head;
            while (lastNode.nextNode != null) {
                lastNode = lastNode.nextNode;
            }
            lastNode.nextNode = new Node(val);
        }
    }

    public boolean remove(int index) {
        if (head == null) {
            return false;
        }

        Node previousNode = null;
        Node targetNode = head;
        for (int i=0; i<index; i++) {
            previousNode = targetNode;
            targetNode = targetNode.nextNode;
            if (targetNode == null) return false;
        }

        if (previousNode != null) {
            previousNode.nextNode = targetNode.nextNode;
        } else {
            head = targetNode.nextNode;
        }
        return true;
    }

    public ArrayList<Integer> getValues() {
        var output = new ArrayList<Integer>();

        if (head == null) {
            return output;
        }

        Node lastNode = head;
        while (lastNode != null) {
            output.add(lastNode.value);
            lastNode = lastNode.nextNode;
        }

        return output;
    }

    class Node {
        Node nextNode;
        int value;

        Node(int value) {
            this.value = value;
        }
    }
}
