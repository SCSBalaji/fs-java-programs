import java.util.*;
// T.C: O(n)
// S.C: O(1) 
class Simulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rollno = sc.nextInt();
        System.out.println(valid(rollno));
    }

    public static boolean valid(int rollno) {
        int num = rollno;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 0);
        hm.put(1, 1);
        hm.put(8, 8);
        hm.put(6, 9);
        hm.put(9, 6);
        int res = 0;
        while (num > 0) {
            int dig = num % 10;
            if (!hm.containsKey(dig)) {
                return false;
            }
            res = res * 10 + hm.get(dig);
            num /= 10;
        }
        return res == rollno;
    }
}