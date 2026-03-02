import java.util.*;
// T.C: O(n)
// S.C: O(2n) 
public class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<Integer> list = new ArrayList<>();

        solve(str, 0, list);

        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void solve(String str, int index, List<Integer> list) {
        if (index == str.length()) {
            return;
        }

        char ch = str.charAt(index);
        int size = list.size();
        if (Character.isDigit(ch)) {
            list.add(Character.getNumericValue(ch));
        }
        else if (ch == 'R') {
            list.remove(size - 1);
        }
        else if (ch == 'D') {
            list.add(list.get(size - 1) * 2);
        }
        else if (ch == 'A') {
            list.add(list.get(size - 1) + list.get(size - 2));
        }
        solve(str, index + 1, list);
    }
}