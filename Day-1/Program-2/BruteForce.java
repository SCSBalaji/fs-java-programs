import java.util.*;
// T.C: O(n²) 
// S.C: O(n)
public class BruteForce{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int pro = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                pro *= arr[j];
            }
            list.add(pro);
        }
        System.out.println(list);
    }
}