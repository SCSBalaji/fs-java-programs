import java.util.*;
// T.C: O(n) 
// S.C: O(1)
public class TwoPointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<Character, Character> hm = new HashMap<>();
        hm.put('0', '0');
        hm.put('1', '1');
        hm.put('8', '8');
        hm.put('6', '9');
        hm.put('9', '6');
        int left = 0;
        int right = str.length() - 1;
        boolean valid = true;
        while (left <= right) {
            if (!hm.containsKey(str.charAt(left)) || !hm.containsKey(str.charAt(right))) {
                valid = false;
                break;
            }
            if (hm.get(str.charAt(left)) != str.charAt(right)) {
                valid = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(valid);
    }
}