import java.util.*;
// T.C: O(n)
// S.C: O(n) 
class HashmapApproach {
    static Map<Character, Character> hm = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        hm.put('0', '0');
        hm.put('1', '1');
        hm.put('8', '8');
        hm.put('6', '9');
        hm.put('9', '6');
        System.out.println(solve(str, 0, str.length() - 1));
    }

    public static boolean solve(String str, int left, int right) {
        if (left > right) {
            return true;
        }
        if (!hm.containsKey(str.charAt(left)) || !hm.containsKey(str.charAt(right))) {
            return false;
        }
        if (hm.get(str.charAt(left)) != str.charAt(right)) {
            return false;
        }
        return solve(str, left + 1, right - 1);
    }
}