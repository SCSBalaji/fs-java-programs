import java.util.*;
// T.C: O(n)
// S.C: O(n) 
class StackBasedReduction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'p') {
                stack.push(ch);
            }
            else if (ch == 'q') {
                stack.push(ch);
            }
            else if (ch == 'r') {
                int n = stack.size();
                if (stack.peek() == 'q' && stack.get(n - 2) == 'p') {
                    stack.pop();
                    stack.pop();
                }
                else {
                    System.out.println(false);
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}