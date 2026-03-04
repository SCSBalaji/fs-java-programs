import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class StackParsing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (stack.empty()) {
                stack.push(ch);
            }
            else if (stack.size() == 1 && ch == ']') {
                stack.pop();
            }
            else {
                if (ch == '[') {
                    stack.push(ch);
                }
                else {
                    stack.pop();
                }
                System.out.print(ch);
            }
        }
    }
}