package DataStructure;

public class Linkedlist {

    private Node head;
    private int size;

    public Linkedlist() {
        this.size = 0;
    }

    private class Node {
        private Node next;
        private int data;

        Node(int val) {
            this.data = val;
        }

        Node(int val, Node temp) {
            this.data = val;
            this.next = temp;
        }
    }

    public void insertFirst(int data) {
        if (head == null) {
            Node newNode = new Node(data);
            head = newNode;
        } else {
            Node newNode = new Node(data, head);
            head = newNode;
        }
        size += 1;
    }

    public void insertLast(int data) {
        if (head == null) {
            insertFirst(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        size += 1;
    }

    public void PrintList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public Node deleteFirst() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            return temp;
        }
        size -= 1;
        return null;
    }

    public Node deleteLast() {
        if (head.next == null || head == null) {
            return deleteFirst();
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node deleteNode = temp.next;
        temp.next = null;
        size -= 1;
        return deleteNode;
    }

    public int size(){
        return size;
    }

    public void insertAtLocation(int data, int index){
        if(index > size){
            System.out.println("Please provide proper index");
            return;
        }
        if(index == 1){
            insertFirst(data);
            return;
        }
        if(index == size){
            insertLast(data);
            return;
        }
        Node temp = head;
        while(temp != null){
            index--;
            if(index == 0){
                temp = new Node(data, temp.next);
            }
        }
    }

    public Node removeFirst(){
        if(head == null){
            return null;
        }
        Node removed = head;
        head = head.next;
        return removed;
    }

    public Node removeLast(){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        Node removed = temp.next;
        temp = null;
        return removed;
    }

    public boolean removedVal(int val){
        if(head == null){
            return false;
        }
        Node temp = head;
        if(temp.data == val){
            removeFirst();
            return true;
        }
        while(temp.next != null){
            if(temp.next.data == val){
                temp.next = temp.next.next;
            }
        }
        return true;
    }

    public void clear(){
        head = null;
        size = 0;
    }
}
