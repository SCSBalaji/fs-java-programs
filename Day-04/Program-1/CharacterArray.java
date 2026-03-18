import java.util.*;
// T.C: O(n) 
// S.C: O(n)
class CharacterArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char [] arr = new char[str.length()];
        int top = -1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            arr[++top] = ch;
            if (top >= 2 && arr[top] == 'r' && arr[top - 1] == 'q' && arr[top - 2] == 'p') {
                top -= 3;
            }
        }
        System.out.println(top == -1);
    }
}