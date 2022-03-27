package PS.bluemoon_2022.microsoft;  
  /*   
   Bluemoon
   01/01/22 12:28 AM  
   */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteAndAddNodeAtFirst(node);
            return node.data;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.data = value;
            deleteAndAddNodeAtFirst(node);
            map.put(key, node);
        } else {
            if (capacity == map.size()) {
                removeLastNode();
            }
            node = new Node(key, value);
            addNodeAtFirst(node);

        }
        map.put(key, node);
    }

    private void deleteAndAddNodeAtFirst(Node node) {
        if (node == head) {
            return;
        } else if (node == tail) {
            removeLastNode();
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            addNodeAtFirst(node);
        }
    }


    private void removeLastNode() {
        if (tail == null) {
            return;
        } else if (tail == head) {
            head = null;
            tail = null;
        } else {
            Node prevNode = tail.prev;
            prevNode.next = null;
            tail.prev = null;
            tail = prevNode;
        }

    }

    private void addNodeAtFirst(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }

    private static class Node {
        int key;
        int data;
        Node next;
        Node prev;

        Node(int key, int data) {
            this.data = data;
            this.key = key;
        }
    }
}
