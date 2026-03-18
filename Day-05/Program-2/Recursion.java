import java.util.*;
// T.C: O(n)
// S.C: O(n) 
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        removeDuplicates(arr, 0, Integer.MIN_VALUE, list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static void removeDuplicates(int [] arr, int index, int prev, List<Integer> list) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] != prev) {
            list.add(arr[index]);
        }
        removeDuplicates(arr, index + 1, arr[index], list);
    }
}