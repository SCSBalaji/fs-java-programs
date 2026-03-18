import java.util.*;
// T.C: O(n²)
// S.C: O(n) 
class Linkedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        String str = sc.next();
        for (char ch : str.toCharArray()) {
            int size = list.size();
            if (Character.isDigit(ch)) {
                list.addLast(Character.getNumericValue(ch));
            }
            else if (ch == 'R') {
                list.removeLast();
            }
            else if (ch == 'D') {
                list.addLast(list.peekLast() * 2);
            }
            else if (ch == 'A') {
                list.addLast(list.get(size - 1) + list.get(size - 2));
            }
        }
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
    }
}