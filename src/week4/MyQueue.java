package week4;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyQueue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> addNode = new Node<T>(item);

        if (last != null) {
            last.next = addNode;
        }
        last = addNode;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }
}
