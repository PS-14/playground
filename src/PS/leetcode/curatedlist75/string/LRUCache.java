package PS.leetcode.curatedlist75.string;  
  /*   
   Bluemoon
   06/12/21 8:32 AM  
   */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        int val = -1;
        if (cache.containsKey(key)) {
            val = cache.get(key).data;
            removeNodeAndAddToHead(cache.get(key));
        }
        return val;
    }

    private void removeNodeAndAddToHead(Node node) {
        if (node == head) {
            return;
        }
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        addNodeToHead(node);
    }

    public void put(int key, int value) {
        if (cache.size() == capacity) {
            removeLRUNode();
        }
        Node newNode = new Node(value);
        addNodeToHead(newNode);
        cache.put(key, newNode);
    }

    private void addNodeToHead(Node newNode) {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    private void removeLRUNode() {
        if (head == tail) {
            head = null;
        }
        tail.prev.next = null;
    }

    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int val) {
            this.data = val;
        }
    }
}
