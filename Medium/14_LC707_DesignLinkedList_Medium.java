class MyLinkedList {
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node current = head.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }

        if (index > size) {
            return;
        }

        Node previous = head;

        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }

        Node newNode = new Node(val);
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node previous = head;

        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }

        previous.next = previous.next.next;
        size--;
    }
}