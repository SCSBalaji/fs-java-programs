import java.util.*;
// T.C: O(n) 
// S.C: O(n)
class Arraylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String str = sc.next();
        for(char ch : str.toCharArray()) {
            int size = list.size();
            if (Character.isDigit(ch)) {
                list.add(Character.getNumericValue(ch));
            }
            else if (ch == 'R') {
                list.remove(size - 1);
            }
            else if (ch == 'D') {
                list.add(list.get(size - 1) * 2);
            }
            else if (ch == 'A') {
                list.add(list.get(size - 1) + list.get(size - 2));
            }
        }
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
    }
}