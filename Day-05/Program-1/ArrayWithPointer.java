import java.util.*;
// T.C: O(n) 
// S.C: O(n)
class ArrayWithPointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int [] arr = new int[str.length()];
        int top = -1;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                arr[++top] = Character.getNumericValue(ch);
            }
            else if (ch == 'R') {
                top--;
            }
            else if (ch == 'D') {
                arr[top + 1] = arr[top] * 2;
                top++;
            }
            else if (ch == 'A') {
                arr[top + 1] = arr[top] + arr[top - 1];
                top++;
            }
        }
        int sum = 0;
        for (int i = 0; i <= top; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}