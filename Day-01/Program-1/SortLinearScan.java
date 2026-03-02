import java.util.*;
// T.C: O(n log n)
// S.C: O(1) 
public class SortLinearScan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        boolean found = false;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                found = true;
                break;
            }
        }
        System.out.println(found);
    }
}
