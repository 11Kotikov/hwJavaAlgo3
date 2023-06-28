package org.example.model;

public class LinkedList {
    Node head;

    public void revert() {
        if (head != null && head.next != null) {
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }

    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        // previousNode.next = null; или см revert() выше
    }

    public void push(int value) { //добавляет значение в начало списка (стека ЛИФО)
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public Integer pop() { // извлекает значение из начала списка (стека ЛИФО)
        Integer result = null;
        if (head != null) {
            result = head.value;
        }
        return result;
    }
}
