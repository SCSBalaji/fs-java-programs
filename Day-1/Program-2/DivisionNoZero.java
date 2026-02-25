import java.util.*;
// T.C: O(n) 
// S.C: O(n)
// Not allowed according to given constraints
public class DivisionNoZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int totalProduct = 1;
        for (int i = 0; i < n; i++) {
            totalProduct *= arr[i];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(totalProduct / arr[i]);
        }
        System.out.println(list);
    }
}