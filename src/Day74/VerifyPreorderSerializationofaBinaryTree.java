package Day74;

/**
 * @program: LeetForWork
 * @description: 331. Verify Preorder Serialization of a Binary Tree
 * @author: Zekun Zhang
 * @create: 2019-12-01 20:20
 */

//TODO SO AMAZING

public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return true;
        String[] vals = preorder.split(",");
        int diff = 1;
        for (String val : vals) {
            if (--diff < 0) return false;
            if (!val.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
