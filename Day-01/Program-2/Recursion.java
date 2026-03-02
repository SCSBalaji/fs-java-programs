import java.util.*;
// T.C: O(n) 
// S.C: O(n)
public class Recursion {
    public static int solve(int [] arr, int [] result, int index, int leftProduct) {
        if (index == arr.length) {
            return 1;
        }
        int rightProduct = solve(arr, result, index + 1, leftProduct * arr[index]);

        result[index] = leftProduct * rightProduct;

        return rightProduct * arr[index];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int [] result = new int[n];
        solve(arr, result, 0, 1);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(result[i]);
        }
        System.out.println(list);
    }
}