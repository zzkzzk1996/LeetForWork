package AlgorithmForCourse;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-03-11 16:12
 */

public class huawei1 {
    public static void main(String[] args) {
//         输入处理
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] infos = new String[n];
        for (int i = 0; i < n; i++) {
            String temp = scanner.nextLine();
            infos[i] = temp;
        }
//        int n = 4;
//        String[] infos = new String[] {
//                "xxx=lyf/${ttt}/test",
//                "ttt=www",
//                "yyy=seeyou",
//                "aa=/aaa/${xxx}/bbb/${yyy}/ccc"
//        };
        HashMap<String, String> map = new HashMap<>();
        for (String info : infos) {
            String[] temp = info.split("=");
            if (!map.containsKey(temp[0])) {
                map.put(temp[0], temp[1]);
            }
        }

        for (int k = 0; k < infos.length; k++) {
            int start = -1, end = -1;
            String[] tempInfo = infos[k].split("=");
            for (int i = 0; i < tempInfo[1].length(); i++) {
                char c = tempInfo[1].charAt(i);
                if (c == '{' && tempInfo[1].charAt(i - 1) == '$') {
                    start = i - 1;
                    i++;
                    StringBuilder sb = new StringBuilder("");
                    while (i >= tempInfo[1].length() || tempInfo[1].charAt(i) != '}') {
                        sb.append(tempInfo[1].charAt(i));
                        i++;
                    }
                    end = i + 1;
                    String temp = map.get(sb.toString());
                    String newWord = tempInfo[1].substring(0, start) + temp + tempInfo[1].substring(end);
                    map.put(tempInfo[0], newWord);
                    infos[k] = tempInfo[0] + "=" + newWord;
                    k--;
                    break;
                }
            }
        }
        String[] t = infos[n - 1].split("=");
        System.out.println(map.get(t[0]));
    }

}
