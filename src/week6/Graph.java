package week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(6,8);

//        graph.dfs();
        graph.bfs();
    }

    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        public Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node node1 = nodes[i1];
        Node node2 = nodes[i2];

        if (!node1.adjacent.contains(node2)) {
            node1.adjacent.add(node2);
        }
        if (!node2.adjacent.contains(node1)) {
            node2.adjacent.add(node1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs (int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node node : r.adjacent) {
                if (node.marked == false) {
                    node.marked = true;
                    stack.push(node);
                }
            }
            visit(r);
        }
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.marked = true;

        while (!queue.isEmpty()) {
            Node r = queue.poll();
            for (Node node : r.adjacent) {
                if (node.marked == false) {
                    node.marked = true;
                    queue.offer(node);
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r) {
        if (r == null) return;
        r.marked = true;
        visit(r);
        for (Node node : r.adjacent) {
            if (node.marked == false) {
                dfsR(node);
            }
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    void dfsR() {
        dfsR(0);
    }

    void visit(Node node) {
        System.out.print(node.data + " ");
    }

}
