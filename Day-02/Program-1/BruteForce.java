import java.util.*;
// T.C: O(n) 
// S.C: O(n)
class BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        char[] flipped = new char[arr.length];
        boolean valid = true;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '0':
                    flipped[i] = '0';
                    break;
                case '1':
                    flipped[i] = '1';
                    break;
                case '8':
                    flipped[i] = '8';
                    break;
                case '6':
                    flipped[i] = '9';
                    break;
                case '9':
                    flipped[i] = '6';
                    break;
                default:
                    valid = false;
                    break;
            }
            if (!valid) {
                break;
            }
        }
        if (valid) {
            for (int i = 0; i < flipped.length / 2; i++) {
                char temp = flipped[i];
                flipped[i] = flipped[flipped.length - 1 - i];
                flipped[flipped.length - 1 - i] = temp;
            }
            System.out.println(Arrays.equals(arr, flipped));
        }
        else {
            System.out.println(false);
        }
    }
}