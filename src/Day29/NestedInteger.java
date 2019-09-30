package Day29;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-09-29 21:10
 */

public class NestedInteger {
    Integer value;
    List<NestedInteger> list;
    // Constructor initializes an empty nested list.
    NestedInteger() {
        value = new Integer(0);
        list = new ArrayList<>();
    };

    // Constructor initializes a single integer.
    NestedInteger(int value) {this.value = value;};

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {return value != null;};

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {return value;};

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {return list;};

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value) {
        this.value = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni) {
        list.add(ni);
    }
}
