import java.util.*;
// T.C: O(n)
// S.C: O(1) 
class ArrayLoopup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int [] map = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};   // positions according to mapping like 6 -> 9, 9 -> 6
        int left = 0;
        int right = str.length() - 1;
        boolean valid = true;
        while (left <= right) {
            int l = str.charAt(left) - '0';
            int r = str.charAt(right) - '0';
            if (map[l] == -1 || map[r] == -1) {
                valid = false;
                break;
            }
            if (map[l] != r) {
                valid = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(valid);
    }
}