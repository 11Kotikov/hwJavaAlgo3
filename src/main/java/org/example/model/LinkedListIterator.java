package org.example.model;

import java.util.Iterator;

public class LinkedListIterator implements Iterator {

    private Node position;

    @Override
    public boolean hasNext() {
        return position != null;
    }

    @Override
    public Integer next() {
        try {
            Integer elem = position.value;
            position = position.next;
        } catch (NullPointerException e) {
            throw new NullPointerException("last element");
        }
        return null;
    }
}
