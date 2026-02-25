import java.util.*;
// T.C: O(n²)
// S.C: O(1)
public class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean found = false;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j]) {
                    found = true;
                    break;
                }
            }
            if (found) {    // early stop for outer loop
                break;
            }
        }
        System.out.println(found);
    }
}
