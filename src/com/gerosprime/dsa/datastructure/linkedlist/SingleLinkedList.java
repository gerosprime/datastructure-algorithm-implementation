package com.gerosprime.dsa.datastructure.linkedlist;

public class SingleLinkedList<T> {


    private Node<T> head;
    private Node<T> tail;

    public SingleLinkedList(T value) {
        head = new Node<>(null, value);
        tail = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public Node<T> getHead() {
        return head;
    }

    public void printAll() {

        Node<T> start = head;
        System.out.print("[");
        while (start != null) {
            System.out.print(start.value + ", ");
            start = start.next;
        }
        System.out.print("]");
    }

    static class Node<T> {

        private Node next;
        private T value;

        private Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }
    }

    public Node<T> getAt(int index) {

        Node<T> iterated = head;
        for (int i = 0; i < index; i++) {
            iterated = iterated.next;
        }
        return iterated;

    }

    public boolean addAfter(Node node, T value) {

        if (head == null || tail == null) {
            head = new Node<>(null, value);
            tail = head;
            return true;
        }

        if (node == head) {
            head.next = new Node(head.next, value);
            return true;
        }

        if (node == null || node == tail) {
            tail.next = new Node(null, value);
            tail = tail.next;
            return true;
        }

        Node<T> iterated = head.next;

        while (iterated != node) {
            iterated = iterated.next;
        }

        iterated.next = new Node<>(iterated.next, value);

        return true;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public boolean delete(Node what) {

        if (isEmpty()) {
            return true;
        }

        if (what == null) {
            return true;
        }

        if (head == what) {
            head = head.next;
            return true;
        }

        Node iterate = head;
        while (iterate.next != null && iterate.next != what) {
            iterate = iterate.next;
        }

        if (iterate.next == tail) {

        }

        if (iterate != null) {



            iterate.next = iterate.next.next;

        }

        return false;

    }


    public static void main(String[] args) {


        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>(0);
        singleLinkedList.addAfter(null, 1);
        singleLinkedList.addAfter(null, 2);
        singleLinkedList.addAfter(null, 3);
        singleLinkedList.addAfter(singleLinkedList.getHead(), 12);
        singleLinkedList.addAfter(singleLinkedList.getAt(2), 133);

        singleLinkedList.printAll();

    }

}
