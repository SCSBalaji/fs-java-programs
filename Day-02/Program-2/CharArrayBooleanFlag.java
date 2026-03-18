import java.util.*;
// T.C: O(n)
// S.C: O(n)
class CharArrayBooleanFlag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char [] arr = s.toCharArray();
        int depth = 0;
        char [] result = new char[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '[') {
                depth++;
                if (depth > 1) {
                    result[idx++] = arr[i];
                }
            }
            else {
                depth--;
                if (depth > 0) {
                    result[idx++] = arr[i];
                }
            }
        }
        System.out.print(new String(result, 0, idx));
    }
}