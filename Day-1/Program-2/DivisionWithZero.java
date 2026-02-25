import java.util.*;
// T.C: O(n) 
// S.C: O(n)
// Not allowed according to given constraints
public class DivisionWithZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int totalProduct = 1;
        int zeroCount = 0;
        int zeroIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            }
            else {
                totalProduct *= arr[i];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (zeroCount > 1) {
            for (int i = 0; i < n; i++) {
                list.add(0);
            }
        }
        else if (zeroCount == 1) {
            for (int i = 0; i < n; i++) {
                if (i == zeroIndex) {
                    list.add(totalProduct);
                }
                else {
                    list.add(0);
                }
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                list.add(totalProduct / arr[i]);
            }
        }
        System.out.println(list);
    }
}