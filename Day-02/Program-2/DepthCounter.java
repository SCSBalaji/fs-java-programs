import java.util.*;
// T.C: O(n)
// S.C: O(1) 
class DepthCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int depth = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '[') {
                depth++;
                if (depth > 1) {
                    sb.append(ch);
                }
            }
            else {
                depth--;
                if (depth > 0) {
                    sb.append(ch);
                }
            }
        }
        System.out.println(sb);
    }
}