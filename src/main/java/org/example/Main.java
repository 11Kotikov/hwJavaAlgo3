package org.example;

import org.example.model.DoublyLinkedList;
import org.example.model.LinkedList;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(19);
        list.add(16);
        list.add(17);
        list.add(18);
        list.add(12);
        for (int i = 0; i<5; i++) {
            System.out.format("element " + i + " = " + list.get(i)+"\n");
        }
        list.revert();
        System.out.println("After revert: ");
        for (int i = 0; i<5; i++) {
            System.out.format("element " + i + " = " + list.get(i)+"\n");
        }

    }
}