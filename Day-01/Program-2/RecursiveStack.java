import java.util.*;
import java.util.Stack;
// T.C: O(n)
// S.C: O(n)
public class RecursiveStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int [] result = new int[n];

        Stack<Integer> stack = new Stack<>();
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            stack.push(leftProduct);
            leftProduct *= arr[i];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            int left = stack.pop();
            result[i] = left * rightProduct;
            rightProduct *= arr[i];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(result[i]);
        }
        System.out.println(list);
    }
}