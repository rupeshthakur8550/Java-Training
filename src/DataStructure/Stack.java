package DataStructure;

public class Stack {

    protected int[] store;
    private static final int default_size = 10;
    int top = -1;

    public Stack(){
        this.store = new int[default_size];
    }

    public Stack(int size){
        this.store = new int[size];
    }

    public boolean isFull(){
        return top == store.length - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void Push(int val){
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
        top++;
        store[top] = val;
    }

    public int Pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is Empty"); 
        }
        return store[top--];
    }

    public int Peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }
        return store[top];
    }

    public void PrintStack() {
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
        return top;
    }
    
}
