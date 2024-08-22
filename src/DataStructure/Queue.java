package DataStructure;

public class Queue {
    protected int[] store;
    private static final int default_size = 10;
    int end = 0;

    public Queue(){
        this.store = new int[default_size];
    }

    public Queue(int size){
        this.store = new int[size];
    }

    public boolean isFull(){
        return end == store.length - 1;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    public void insert(int val){
        if(isFull()){
            System.out.println("Queur is Full");
            return ;
        }
        store[end++] = val;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed = store[0];
        for(int i = 1; i < store.length; i++){
            store[i-1] = store[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return store[0];
    }

    public void PrintQueue() {
        System.out.print("[");
        for (int i = 0; i < store.length; i++) {
            if(store[i] != 0){
                System.out.print(store[i]);
            }
            if (i < store.length - 1 && store[i + 1] != 0) {
                System.out.print(", "); 
            }
        }
        System.out.print("]");
    }

    public int size(){
        return end;
    }
}
