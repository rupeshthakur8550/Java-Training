package DataStructure;

public class CLinkedList {
    private Node head;
    private int size;

    public CLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int data;
        private Node next;

        Node(int val) {
            this.data = val;
        }

        Node(int val, Node next) {
            this.data = val;
            this.next = next;
        }
    }

    public void insertFirst(int val) {
        if (head == null) {
            Node node = new Node(val);
            head = node;
            node.next = head;
            size++;
            return;
        }
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next != head);
        Node node = new Node(val, head);
        temp.next = node;
        head = node;
        size++;
    }

    public void insertLast(int val) {
        if (head == null) {
            insertFirst(val);
        }
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next != head);
        Node node = new Node(val, head);
        temp.next = node;
        size++;
    }

    public void PrintCList() {
        Node temp = head;
        System.out.print("Start->");
        do {
            if (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
        } while (temp != head);
        System.out.println("End");
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        }
        Node delnode = head;
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next != head);
        temp.next = head.next;
        head = head.next;
        delnode.next = null;
        size--;
        return delnode;
    }

    public Node removeLast() {
        if (size == 1) {
            return removeFirst();
        }
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next.next != head);
        Node delnode = temp.next;
        temp.next = head;
        delnode.next = null;
        size--;
        return delnode;
    }

    public int size() {
        return size;
    }
}
