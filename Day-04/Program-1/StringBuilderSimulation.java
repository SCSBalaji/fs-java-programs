import java.util.*;
// T.C: O(n) 
// S.C: O(n)
public class StringBuilderSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            int len = sb.length();
            if (len >= 3 && sb.charAt(len - 3) == 'p' && sb.charAt(len - 2) == 'q' && sb.charAt(len - 1) == 'r') {
                sb.delete(len - 3, len);
            }
        }
        System.out.println(sb.length() == 0);
    }
}