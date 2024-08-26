import java.util.Scanner;

import DataStructure.CQueue;
import DataStructure.Linkedlist;
import DataStructure.Queue;
import DataStructure.Stack;
import DataStructure.Deque;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Main Menu:");
            System.out.println("1. Linked List");
            System.out.println("2. Stack");
            System.out.println("3. Queue");
            System.out.println("4. Circular Queue");
            System.out.println("5. Dequeue");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> linkedListMenu(scanner);
                case 2 -> stackMenu(scanner);
                case 3 -> queueMenu(scanner);
                case 4 -> cqueueMenu(scanner);
                case 5 -> dqueue(scanner);
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }

    private static void dqueue(Scanner scanner) {
        Deque deque = new Deque(5);
        boolean running = true;
        while (running) {
            System.out.println("\nDequeue Menu:");
            System.out.println("1. Insert First");
            System.out.println("2. Remove First");
            System.out.println("3. Insert Last");
            System.out.println("4. Remove Last");
            System.out.println("5. Print Dequeue");
            System.out.println("6. Back to Main Menu");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            System.out.println();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter value to add into Dequeue at Front of dequeue:");
                    deque.insertFirst(scanner.nextInt());
                }
                case 2 -> {
                    try {
                        System.out.println("Delete value from first position of Dequeue: " + deque.deleteFirst());
                    } catch (Exception e) {
                        System.out.println("Dequeue is empty.");
                    }
                }
                case 3 -> {
                    System.out.println("Enter value to add into Dequeue  at Last of dequeue:");
                    deque.insertLast(scanner.nextInt());
                }
                case 4 -> {
                    try {
                        System.out.println("Delete value from Last position of Dequeue: " + deque.deleteLast());
                    } catch (Exception e) {
                        System.out.println("Dequeue is empty.");
                    }
                }
                case 5 -> deque.display();
                case 6 -> running = false;
                case 7 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void stackMenu(Scanner scanner) {
        Stack stack = new Stack();
        boolean running = true;
        while (running) {
            System.out.println("\nStack Menu:");
            System.out.println("1. Push Element");
            System.out.println("2. Pop Element");
            System.out.println("3. Peek Element");
            System.out.println("4. Print Stack");
            System.out.println("5. Stack size");
            System.out.println("6. Back to Main Menu");
            System.out.println("7. Exit");
            System.out.println();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter value to add into stack:");
                    stack.Push(scanner.nextInt());
                }
                case 2 -> {
                    try {
                        System.out.println("Popped value: " + stack.Pop());
                    } catch (Exception e) {
                        System.out.println("Stack is empty.");
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Top value: " + stack.Peek());
                    } catch (Exception e) {
                        System.out.println("Stack is empty.");
                    }
                }
                case 4 -> stack.PrintStack();
                case 5 -> System.out.println(stack.size());
                case 6 -> running = false;
                case 7 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void linkedListMenu(Scanner scanner) {
        Linkedlist demo = new Linkedlist();
        boolean running = true;

        while (running) {
            System.out.println("\nLinked List Menu:");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Insert at index i");
            System.out.println("4. Remove First");
            System.out.println("5. Remove Last");
            System.out.println("6. Remove Value");
            System.out.println("7. Print List");
            System.out.println("8. LinkedList Size");
            System.out.println("9. Clear List");
            System.out.println("10. Back to Main Menu");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            System.out.println();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert at the beginning: ");
                    int valueFirst = scanner.nextInt();
                    demo.insertFirst(valueFirst);
                }
                case 2 -> {
                    System.out.print("Enter value to insert at the end: ");
                    int valueLast = scanner.nextInt();
                    demo.insertLast(valueLast);
                }
                case 3 -> {
                    System.out.print("Enter value to insert at index i (First specify value then space then index): ");
                    demo.insertAtLocation(scanner.nextInt(), scanner.nextInt());
                    System.out.println("Value added at entered index.");
                }
                case 4 -> {
                    try {
                        demo.removeFirst();
                        System.out.println("First element removed.");
                    } catch (Exception e) {
                        System.out.println("List is empty.");
                    }
                }
                case 5 -> {
                    try {
                        demo.removeLast();
                        System.out.println("Last element removed.");
                    } catch (Exception e) {
                        System.out.println("List is empty.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter value to remove: ");
                    int value = scanner.nextInt();
                    boolean removed = demo.removedVal(value);
                    if (removed) {
                        System.out.println("Value removed.");
                    } else {
                        System.out.println("Value not found.");
                    }
                }
                case 7 -> demo.PrintList();
                case 8 -> System.out.println("Size of the list: " + demo.size());
                case 9 -> demo.clear();
                case 10 -> running = false;
                case 11 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void queueMenu(Scanner scanner) {
        Queue queue = new Queue();
        boolean running = true;
        while (running) {
            System.out.println("\nQueue Menu:");
            System.out.println("1. Insert Element");
            System.out.println("2. Remove Element");
            System.out.println("3. Front Element");
            System.out.println("4. Print Queue");
            System.out.println("5. Queue size");
            System.out.println("6. Back to Main Menu");
            System.out.println("7. Exit");
            System.out.println();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert into queue: ");
                    queue.insert(scanner.nextInt());
                }
                case 2 -> {
                    try {
                        System.out.println("Removed value: " + queue.remove());
                    } catch (Exception e) {
                        System.out.println("Queue is empty.");
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Front value: " + queue.front());
                    } catch (Exception e) {
                        System.out.println("Queue is empty.");
                    }
                }
                case 4 -> queue.PrintQueue();
                case 5 -> System.out.println(queue.size());
                case 6 -> running = false;
                case 7 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void cqueueMenu(Scanner scanner) {
        CQueue cqueue = new CQueue(5);
        boolean running = true;
        while (running) {
            System.out.println("\nCircular Queue Menu:");
            System.out.println("1. Insert Element");
            System.out.println("2. Remove Element");
            System.out.println("3. Front Element");
            System.out.println("4. Print Circular Queue");
            System.out.println("5. Back to Main Menu");
            System.out.println("6. Exit");
            System.out.println();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert into queue: ");
                    cqueue.enqueue(scanner.nextInt());
                }
                case 2 -> {
                    try {
                        System.out.println("Removed value: " + cqueue.dequeue());
                    } catch (Exception e) {
                        System.out.println("Queue is empty.");
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Front value: " + cqueue.frontValue());
                    } catch (Exception e) {
                        System.out.println("Queue is empty.");
                    }
                }
                case 4 -> cqueue.display();
                case 5 -> running = false;
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
