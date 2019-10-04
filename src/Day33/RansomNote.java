package Day33;

/**
 * @program: LeetForWork
 * @description: 383. Ransom Note
 * @author: Zekun Zhang
 * @create: 2019-10-03 11:27
 */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            if (--count[ransomNote.charAt(j) - 'a'] < 0) return false;
        }
        return true;
    }
}
