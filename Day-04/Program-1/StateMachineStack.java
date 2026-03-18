import java.util.*;
// T.C: O(n)
// S.C: O(n) 
class StateMachineStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Integer> stack = new Stack<>();
        boolean valid = true;
        for (int i = 0; i < str.length() && valid; i++) {
            char ch = str.charAt(i);
            if (ch == 'p') {
                stack.push(0);
            }
            else if (ch == 'q') {
                if (stack.isEmpty() || stack.peek() != 0) {
                    valid = false;
                }
                else {
                    stack.pop();
                    stack.push(1);
                }
            }
            else if (ch == 'r') {
                if (stack.isEmpty() || stack.peek() != 1) {
                    valid = false;
                }
                else {
                    stack.pop();
                }
            }
            else {
                valid = false;
            }
        }
        if (valid && stack.isEmpty()) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}