package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   20/01/22 7:31 PM  
   */

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
            map.put(key, node);
            return;
        }
        if (map.size() >= capacity) {
            Node node = removeNodeFromTail();
            map.remove(node.key);
        }
        Node node = new Node(key, value);
        addToHead(node);
        map.put(key, node);

    }

    private Node removeNodeFromTail() {
        Node node = null;
        if (head == tail) {
            node = head;
            head = null;
            tail = null;
            return node;
        } else {
            node = tail;
            tail = tail.prev;
            tail.next = null;
            return node;
        }
    }

    private void removeNode(Node node) {
        if (node == head) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            }
            node = null;
            return;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
            node = null;
            return;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node = null;
        }
    }

    private void addToHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        cache.get(1);
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
