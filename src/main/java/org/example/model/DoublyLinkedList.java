package org.example.model;

import java.util.Iterator;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else { // ни хэд ни тейл, а то NullPointerException
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    public void push(int value) { //добавляет значение в начало списка (очереди ФИФО)
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peek() { //удаляет последний элемент списка (очереди ФИФО)
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    public int get(int index) {
        Node currentNode = head;
        try {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
        return currentNode.value;
    }

    @Override
    public String toString() {
        StringBuilder showMeList = new StringBuilder("[");
        Node currentNode = head;
        while (currentNode!=null) {
            showMeList.append(currentNode.value);
            if (currentNode.next != null){
                showMeList.append(", ");
            }
            currentNode = currentNode.next;
        }
        showMeList.append("]");
        return showMeList.toString();
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }
}
