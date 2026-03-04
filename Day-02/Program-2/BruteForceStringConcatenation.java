import java.util.*;
// T.C: O(n²)
// S.C: O(n)
public class BruteForceStringConcatenation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String result = "";
        int depth = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                depth++;
            }
            else {
                depth--;
            }
            if (depth == 0) {
                result = result + s.substring(start + 1, i);
                start = i + 1;
            }
        }
        System.out.println(result);
    }
}