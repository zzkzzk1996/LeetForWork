package Day34;

/**
 * @program: LeetForWork
 * @description: 345. Reverse Vowels of a String
 * @author: Zekun Zhang
 * @create: 2019-10-04 23:30
 */

public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            while (i < j && vowels.indexOf(str[i]) == -1) i++;
            while (i < j && vowels.indexOf(str[j]) == -1) j--;
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
        return new String(str);
    }
}
