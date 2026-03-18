import java.util.*;
// T.C: O(n²) 
// S.C: O(n)
class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        while (str.contains("pqr")) {
            str = str.replace("pqr", "");
        }
        System.out.println(str.isEmpty());
    }
}