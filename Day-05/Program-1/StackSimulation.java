import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class StackSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Integer> stack = new Stack<>();
        for(char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            }
            else if (ch == 'R') {
                stack.pop();
            }
            else if (ch == 'D') {
                int dig = stack.peek();
                stack.push(dig * 2);
            }
            else if (ch == 'A') {
                int n = stack.size();
                int d1 = stack.peek();
                int d2 = stack.get(n - 2);
                stack.push(d1 + d2);
            }
        }
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}