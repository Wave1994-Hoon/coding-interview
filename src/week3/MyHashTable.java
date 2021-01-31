package week3;

import java.util.LinkedList;

public class MyHashTable {
    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String getValue() {
            return value;
        }

        void setValue(String value) {
            this.value = value;
        }
    }

    /* 데이터를 저장할 링크드 리스트 */
    LinkedList<Node>[] data;

    /* 생성자 */
    MyHashTable(int size) {
        this.data = new LinkedList[size];
    }

    /* 해쉬 알거리즘, key를 받아서 해쉬 코드 반환 */
    int getHashCode(String key) {
        int hashcode = 0; // init
        for (char c : key.toCharArray()) {
            hashcode += c; // 아스키 코드 값을 더해줌
        }
        return hashcode;
    }

    /* 해쉬코드를 인덱스로 변환 */
    int convertToIndex(int hashcode) {
        return hashcode % data.length; // 해쉬 코드를 배열의 크기로 나눈거의 나머지
    }

    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) {
            return null;
        }

        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    /* 데이터를 받아서 저장 */
    void put(String key, String value) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];

        if (list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }

        Node node = searchKey(list, key);

        if (node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }
    String get(String key) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "Not found" : node.value;
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(3);
        hashTable.put("java", "spring");
        hashTable.put("python", "django");
        hashTable.put("php", "lalavel");
        hashTable.put("js", "node");

        System.out.println(hashTable.get("java"));
        System.out.println(hashTable.get("python"));
        System.out.println(hashTable.get("php"));
        System.out.println(hashTable.get("js"));
        System.out.println(hashTable.get("go"));
    }
}
