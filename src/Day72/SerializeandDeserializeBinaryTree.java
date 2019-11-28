package Day72;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 297. Serialize and Deserialize Binary Tree
 * @author: Zekun Zhang
 * @create: 2019-11-27 18:44
 */

public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    sb.append("null");
                } else {
                    sb.append(String.valueOf(cur.val));
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                if (i != size - 1 || !queue.isEmpty()) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.offer(root);
        for (int i = 1; i < str.length; i++) {
            TreeNode cur = queue.poll();
            if (!str[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.left);
            }
            if (!str[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
