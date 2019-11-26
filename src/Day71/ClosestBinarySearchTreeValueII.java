package Day71;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 272. Closest Binary Search Tree Value II
 * @author: Zekun Zhang
 * @create: 2019-11-25 20:58
 */

public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Double>> pq = new PriorityQueue<>((a, b) -> (int) (b.getValue() - a.getValue()));
        HashMap<Integer, Double> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                root = root.left;
                stack.push(root);
            }
            root = stack.pop();
            map.put(root.val, Math.abs(root.val - target));
            root = root.right;
        }

        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Double> entry = pq.poll();
            res.add(entry.getKey());
        }

        return res;
    }


    public List<Integer> closestKValues1(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<TreeNode> pq = new PriorityQueue<>((a, b) -> Double.compare(Math.abs(b.val - target), Math.abs(a.val - target)));
        dfs(root, pq, k);
        while (!pq.isEmpty()) {
            res.add(pq.poll().val);
        }
        return res;
    }

    private void dfs(TreeNode root, PriorityQueue<TreeNode> pq, int k) {
        if (root == null) return;

        pq.add(root);
        if (pq.size() > k) {
            pq.poll();
        }

        dfs(root.left, pq, k);
        dfs(root.right, pq, k);

    }
}
