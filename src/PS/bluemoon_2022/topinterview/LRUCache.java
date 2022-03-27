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
        this.map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            putNodeAtHead(key);
            return map.get(key).data;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.data = value;
            putNodeAtHead(key);
        } else {
            if (map.size() == capacity) {
                removeLruNode();
            }
            node = new Node(value);
            addNodeToHead(node);
        }
        map.put(key, node);
    }

    private void removeLruNode() {
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;

    }

    private void addNodeToHead(Node node) {
        if (head == node) {
            return;
        } else if (head == null) {
            head = node;
            tail = node;
        } else {
            if (node == tail) {
                tail = node.prev;
                tail.next = null;
            }
            changeHead(node);
        }

    }

    private void putNodeAtHead(int key) {
        Node node = map.get(key);
        if (head == node) {
            return;
        }
        if (node.next == null) {
            node.prev.next = null;
            tail = node.prev;
            node.prev = null;
            changeHead(node);
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            changeHead(node);
        }
    }

    private void changeHead(Node node) {
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
    }

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        cache.get(1);
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
