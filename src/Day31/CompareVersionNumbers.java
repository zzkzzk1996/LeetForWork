package Day31;

/**
 * @program: LeetForWork
 * @description: 165. Compare Version Numbers
 * @author: Zekun Zhang
 * @create: 2019-10-01 23:19
 */

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int vInt1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int vInt2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (vInt1 > vInt2) return 1;
            else if (vInt1 < vInt2) return -1;
        }
        return 0;
    }
}
