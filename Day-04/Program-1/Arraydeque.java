import java.util.*;
// T.C: O(n)
// S.C: O(n) 
public class Arraydeque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        boolean valid = true;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'r') {
                if (deque.size() >= 2 && deque.peek() == 'q') {
                    deque.pop();
                    if (deque.peek() == 'p') {
                        deque.pop();
                    }
                    else {
                        valid = false;
                        break;
                    }
                }
                else {
                    valid = false;
                    break;
                }
            }
            else {
                deque.push(ch);
            }
        }
        if (valid && deque.isEmpty()) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}