package DataStructure;

public class CQueue {
    int default_size = 10;
    int front, rear;
    int[] arr;

    CQueue(){
        arr = new int[default_size];
        front = -1;
        rear = -1;
    }

    public  CQueue(int size){
        default_size = size;
        arr = new int[default_size];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return (rear + 1) % default_size == front;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("Circular Queue is Full");
            return ;
        }
        rear = (rear + 1) % default_size;
        // System.out.println(rear);
        arr[rear] = val;
        if(front == -1){
            front = 0;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Circular Queue is Empty");
            return -1;
        }
        if(front == rear){
            front = -1;
            rear = -1;
        }
        int element = arr[front];
        front = (front + 1) % default_size;
        return element;
    }

    public void display(){
        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }
        // System.out.println(front+" "+rear);
        for(int i = front; i != rear; i = (i+1) % default_size){
            System.out.print(arr[i]+"->");
        }
        System.out.print(arr[rear]);
    }

    public int frontValue(){
        return arr[front];
    }
}
