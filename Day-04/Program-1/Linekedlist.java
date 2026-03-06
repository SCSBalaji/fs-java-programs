import java.util.*;
// T.C: O(n)  
// S.C: O(n)
public class Linekedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
            int size = list.size();
            if (size >= 3 && list.get(size - 3) == 'p' && list.get(size - 2) == 'q' && list.get(size - 1) == 'r') {
                list.removeLast();
                list.removeLast();
                list.removeLast();
            }
        }
        System.out.println(list.isEmpty());
    }
}