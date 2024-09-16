package DSA;

import java.util.Scanner;

public class SwitchCasing {
    public static void main(String[] args) {
        System.out.println("Enter choice : ");
        try (Scanner sc = new Scanner(System.in)) {
            int ch = sc.nextInt();
            while (true) {
                switch (ch) {
                    case 1 ->
                        System.out.println("case 1");
                    case 2 ->{
                        System.out.println("case 2");
                        if (ch > 0) {
                            ch = 3; // Change ch to 3 to jump to case 3
                            continue; // Skip the rest of the switch and re-evaluate
                        }}
                    case 3 ->
                        System.out.println("case 3");
                    default ->
                        System.out.println("Wrong Input");
                }
                break; 
            }
        }
    }
}
