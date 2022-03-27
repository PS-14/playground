package PS.leetcode.dec_2021;  
  /*   
   Bluemoon
   29/12/21 9:18 AM  
   */

public class StockPrice {


    Node head;
    Node tail;
    Node current;

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        Node node = getUpdatedNode(timestamp, price);
        insertNodeInSortedOrder(node);
        updateCurrent(node);

    }

    private void updateCurrent(Node temp) {
        if (current == null) {
            current = temp;
        } else {
            current = temp.time > current.time ? temp : current;
        }
    }

    public int current() {
        return current.price;
    }

    public int maximum() {
        return head.price;
    }

    public int minimum() {
        return tail.price;
    }

    private static class Node {
        int price;
        int time;
        Node left;
        Node right;

        Node(int p, int t) {
            this.price = p;
            this.time = t;
            this.left = null;
            this.right = null;
        }
    }

    private Node getUpdatedNode(int time, int price) {
        Node pointer = head;
        while (pointer != null) {
            if (pointer.time == time) {
                deleteNode(pointer);
                break;
            }
            pointer = pointer.right;
        }
        return new Node(price, time);
    }

    private void deleteNode(Node temp) {
        if (temp == head) {
            head = head.right;
            if (head != null) {
                head.left = null;
            }
        } else if (temp == tail) {
            tail = tail.left;
            if (tail != null) {
                tail.right = null;
            }
        } else {
            temp.left.right = temp.right;
            temp.right.left = temp.left;
        }
        temp = null;
    }

    private void insertNodeInSortedOrder(Node temp) {
        if (head == null) {
            head = temp;
            tail = temp;
        }
        if (temp.price > head.price) {
            temp.right = head;
            head.left = temp;
            head = temp;
        } else if (temp.price < tail.price) {
            tail.right = temp;
            temp.left = tail;
            tail = temp;
        } else {
            Node pointer = head;
            while (pointer.price > temp.price && pointer.right != null) {
                pointer = pointer.right;
            }
            temp.right = pointer.right;
            temp.left = pointer;
        }
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());
    }
}

