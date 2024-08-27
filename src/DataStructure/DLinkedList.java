package DataStructure;

public class DLinkedList {
    private Node head;
    private int size;

    public DLinkedList(){
        this.size = 0;
    }

    private class Node {
        private Node next;
        private int data;
        private Node prev;

        Node(int val) {
            this(val, null, null);
        }

        Node(int val, Node next, Node prev) {
            this.data = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val){
        if(head == null){
            Node node = new Node(val, null, null);
            head = node;
            size++;
            return ;
        }
        Node node = new Node(val, head, null);
        head.prev = node;
        head = node;
        size++;
    }

    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return ;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node node = new Node(val, null, temp);
        temp.next = node;
        size++;
    }

    public Node removeFirst(){
        if(head == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        size--;
        return temp;
    }

    public Node removeLast(){
        if(size == 1){
           return removeFirst();
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        Node delnode = temp.next;
        temp.next = null;
        delnode.prev = null;
        size--;
        return delnode;
    }

    public int size(){
        return size;
    }

    public void PrintDList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public void insertAtIndexI(int val, int index){
        if(index == 1){
            insertFirst(val);
            return ;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        while(temp != null){
            if(index == 1){
                Node node = new Node(val, temp, temp.prev);
                temp.prev.next = node;
                temp.prev = node;
            }
            temp = temp.next;
            index--;
        }
        size++;
    }

    public Node removeAtindexI(int index){
        if(index == 1){
            return removeFirst();
        }
        if(index == size){
            return removeLast();
        }
        Node temp = head;
        Node delnode = null;
        while(temp != null){
            if(index == 1){
                delnode = temp;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            temp = temp.next;
            index--;
        }
        size--;
        return delnode;
    }
}
