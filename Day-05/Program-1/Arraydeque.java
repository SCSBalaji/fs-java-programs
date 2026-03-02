import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class Arraydeque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        String str = sc.next();
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                deque.push(Character.getNumericValue(ch));
            }
            else if (ch == 'R') {
                deque.pop();
            }
            else if (ch == 'D') {
                deque.push(deque.peek() * 2);
            }
            else if (ch == 'A') {
                int first = deque.pop();
                int second = deque.peek();
                deque.push(first);
                deque.push(first + second);
            }
        }
        int sum = 0;
        for (int i : deque) {
            sum += i;
        }
        System.out.println(sum);
    }
}