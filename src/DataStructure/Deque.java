package DataStructure;

public class Deque {
    int default_size = 10;
    int front, rear;
    int[] arr;

    Deque() {
        arr = new int[default_size];
        front = -1;
        rear = -1;
    }

    public Deque(int size) {
        default_size = size;
        arr = new int[default_size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % default_size == front;
    }

    public void insertFirst(int val) {
        if (isFull()) {
            System.out.println("Deque is Full");
            return;
        }
        if (front == -1) { 
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + default_size) % default_size; 
        }
        arr[front] = val;
    }

    public int deleteFirst() {
        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return -1;
        }
        int element = arr[front];
        if (front == rear) { 
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % default_size;
        }
        return element;
    }

    public void insertLast(int val) {
        if (isFull()) {
            System.out.println("Deque is Full");
            return;
        }
        if (front == -1) { 
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % default_size; 
        }
        arr[rear] = val;
    }

    public int deleteLast() {
        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return -1;
        }
        int element = arr[rear];
        if (front == rear) { 
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + default_size) % default_size; 
        }
        return element;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }
        for(int i = front; i != rear; i = (i+1) % default_size){
            System.out.print(arr[i]+"->");
        }
        System.out.print(arr[rear]);
    }
}
