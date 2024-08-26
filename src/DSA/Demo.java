package DSA;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        WindowSort(arr, arr.length - 1, 3);
        System.out.println(Arrays.toString(arr));
    }

    private static void WindowSort(int[] arr, int n, int k) {
        int i = 0;
        int j = i + (k - 1);
        while (i < n) {
            QuickSort(i, i + (k - 1), arr);
            i = j + k + 1;
            j = i + (k - 1);
        }
    }

    private static void QuickSort(int start, int end, int[] arr) {
        if (start > end) {
            return;
        }
        int nstart = start, nend = end; 
        int mid = nstart + (nend - nstart) / 2;
        int pivote = arr[mid];
        while (nstart <= nend) {
            while (arr[nstart] < pivote) {
                nstart++;
            }
            while (arr[nend] > pivote) {
                nend--;
            }
            if (nstart <= nend) {
                int temp = arr[nstart];
                arr[nstart++] = arr[nend];
                arr[nend--] = temp;
            }
        }
        QuickSort(start, nend, arr);
        QuickSort(nstart, end, arr);
    }
}
