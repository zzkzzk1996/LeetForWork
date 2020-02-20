package zDay09;

import java.util.Stack;

/**
 * @program: LeetForWork
 * @description: 251. Flatten 2D Vector
 * @author: Zekun Zhang
 * @create: 2020-02-16 16:35
 */

/**
 * Check 341. Flatten Nested List Iterator, same question
 */
public class Flatten2DVector {

    private Stack<int[]> stack;
    public Flatten2DVector(int[][] v) {
        stack = new Stack<>();
        for (int i = v.length - 1; i >= 0; i--) {
            stack.push(v[i]);
        }
    }

    public int next() {
        if (stack.peek().length == 1) {
            return stack.pop()[0];
        }
        while (!stack.isEmpty()) {
            int[] temp = stack.pop();
            if (temp.length == 0) continue;
            if (temp.length == 1) return temp[0];
            for (int i = temp.length - 1; i >= 0; i--) {
                stack.push(new int[] {temp[i]});
            }
        }
        return -1;
    }

    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().length == 0) {
                stack.pop();
                continue;
            }
            return true;
        } return false;
    }

/**
 * Two pointer
 */
//    private int indexList, indexInteger;
//    private int[][] vector;
//    public Vector2D(int[][] v) {
//        this.vector = v;
//        this.indexList = 0;
//        this.indexInteger = 0;
//    }
//
//    public int next() {
//        while (vector[indexList].length <= indexInteger) {
//            indexList++;
//            indexInteger = 0;
//        }
//        return vector[indexList][indexInteger++];
//    }
//
//    public boolean hasNext() {
//        while (indexList < vector.length) {
//            if (vector[indexList].length <= indexInteger) {
//                indexList++;
//                indexInteger = 0;
//            } else return true;
//        }
//        return false;
//    }
}
