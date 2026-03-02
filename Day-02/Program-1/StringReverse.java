import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<Character, Character> hm = new HashMap<>();
        hm.put('0', '0');
        hm.put('1', '1');
        hm.put('8', '8');
        hm.put('6', '9');
        hm.put('9', '6');
        StringBuilder sb = new StringBuilder();
        boolean valid = true;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!hm.containsKey(ch)) {
                valid = false;
                break;
            }
            sb.append(hm.get(ch));
        }
        if (valid) {
            sb.reverse();
            System.out.println(sb.toString().equals(str));
        }
        else {
            System.out.println(false);
        }
    }
}