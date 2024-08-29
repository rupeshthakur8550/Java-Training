package Searching;

public class Search {
    public static void main(String[] args) {
        Integer[] arr = {10, 20, 30, 2, 5, 90};
        System.out.println(LinearSearch(arr, 20));
    }

    public static boolean LinearSearch(Object[] arr, Object target) {
        for (Object i : arr) {
            return i == target;
        }
        return false;
    }

    private static int interpolation_search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end && arr[start] <= target && arr[end] >= target){
            int mid = start + (((end - start) * (target - arr[start])) / arr[end] - arr[start]); //mid = (startIndex + (endIndex - startIndex) * (targetVallue - arr[startIndex])) / (arr[endIndex] - arr[startIndex])
            if(arr[mid] == target){
                return mid;
            } 
            else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }  
        }
        return -1;
    }
}