package zDay07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 170. Two Sum III - Data structure design
 * @author: Zekun Zhang
 * @create: 2020-02-14 20:29
 */

public class TwoSumIIIDatastructuredesign {

    /**
     * Time excess
     */
//    private HashSet<Integer> set;
//    private List<Integer> list;
//    /** Initialize your data structure here. */
//    public TwoSumIIIDatastructuredesign() {
//        this.set = new HashSet<>();
//        this.list = new ArrayList<>();
//    }
//
//    /** Add the number to an internal data structure.. */
//    public void add(int number) {
//        if (list.contains(number)) {
//            set.add(number + number);
//        } else {
//            for (int i = 0; i < list.size(); i++) {
//                int sum = list.get(i) + number;
//                set.add(sum);
//            }
//        }
//        list.add(number);
//    }
//
//    /** Find if there exists any pair of numbers which sum is equal to the value. */
//    public boolean find(int value) {
//        return set.contains(value);
//    }


    private boolean sorted;
    private List<Integer> list;
    /** Initialize your data structure here. */
    public TwoSumIIIDatastructuredesign() {
        this.list = new ArrayList<>();
        this.sorted = false;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        this.list.add(number);
        this.sorted = false;
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (!this.sorted) {
            Collections.sort(list);
            this.sorted = true;
        }
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int sum = list.get(low) + list.get(high);
            if (sum < value) {
                low++;
            } else if (sum > value) {
                high--;
            } else return true;
        }
        return false;
    }
}
