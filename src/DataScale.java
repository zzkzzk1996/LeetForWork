/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-01 15:44
 */

public class DataScale {
    private static void dataScale() {
        for (int i = 0; i < 1; i++) {
            double num = Math.pow((double)10, i);
            int sum = 0;
            long before = System.currentTimeMillis();
            for (int j = 0; j < num; j++) {
                sum += j;
            }
            long end = System.currentTimeMillis();
            long per = end - before;
            System.out.println(i + ":" + per);

        }
        System.out.println(2 << 2);
    }
//    public static void main(String[] args) {
//        dataScale();
//    }
}
