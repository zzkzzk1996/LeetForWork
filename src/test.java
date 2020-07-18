import java.util.Scanner;
public class test {
    private static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String t = in.nextLine();
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
                arr[t.charAt(i) - 'a']--;
            }
            for (int i : arr) {
                if (i != 0) {
                    System.out.println("-1");
                    return;
                }
            }
            helper(s, t, 0);
            System.out.println(res);
        }
    }

    private static void helper(String s, String t, int steps) {
        if (s.equals(t) || steps >= s.length()) {
            res = Math.min(res, steps);
            return;
        }
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == t.charAt(index)) index++;
            else break;
        }
        for (int i = index; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            char c = s.charAt(i);
            sb.delete(i, i + 1);
            sb.append(c);
            helper(sb.toString(), t, steps + 1);
        }
    }
}