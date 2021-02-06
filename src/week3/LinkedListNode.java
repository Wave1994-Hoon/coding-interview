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

    /* 단방향 링크드 리스트 중복 제거 */
    void removeDuplicated() {
        Node start = header;
        while (start.next != null) {
            Node runner = start;
            while (runner.next != null) {
                if (start.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            start = start.next;
        }
    }

    /* 단방향 리스트, 뒤에서 k 번째 노드 찾기 */
    Node searchKthFromLastNode(Node first, int k) {
        Node start = first;
        int total = 1;
        /* count total size */
        while (start.next != null) {
            total ++;
            start = start.next;
        }
        start = first;

        for (int i = 0; i < total - k + 1; i++) {
             start = start.next;
        }
        return start;
    }

    /* 단방향 리스트, 재귀를 사용하여 뒤에서 k 번째 노드 찾기 */
//    Integer searchKthFromLastNodeWithRecursive(Node target, int k) {
//        if (target == null) {
//            return 0;
//        }
//
//        int count = searchKthFromLastNodeWithRecursive(target.next, k) + 1;
//        if (count == k) {
//            System.out.println(k);
//        }
//    }

    /* 중간 노드 삭제, 단 중간 노드는 앞에 노드 정보 모름 */
    private static boolean deleteSomethingNode(Node targetNode) {
        if (targetNode == null || targetNode.next == null) {
            return false;
        }
        Node nextNode = targetNode.next;
        nextNode.data = targetNode.data;
        nextNode.next = targetNode.next.next;
        return true;
    }

}
