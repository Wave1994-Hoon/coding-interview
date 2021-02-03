package week3;

public class LinkedListNode {
    Node header; // start

    static class Node {
        int data;
        Node next = null;
    }

    public LinkedListNode() {
        header = new Node();
    }

    void append(int data) {
        Node endNode = new Node();
        endNode.data = data;
        Node startNode = header;

        while (startNode.next != null) {
            startNode = startNode.next;
        }
        startNode.next = endNode;
    }

    void delete(int data) {
        Node startNode = header;

        while (startNode.next != null) {
            if (startNode.next.data == data) {
                startNode.next = startNode.next.next; // 노드 끊음
            } else {
                startNode = startNode.next;
            }
        }
    }

    void retrieve() {
        Node startNode = header.next;
        while (startNode.next != null) {
            System.out.println(startNode.data + "->");
            startNode = startNode.next;
        }
        System.out.println(startNode.data);
    }

}
