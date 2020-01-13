package Day77;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 133. Clone Graph
 * @author: Zekun Zhang
 * @create: 2020-01-13 13:59
 */

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        HashMap<Node, Node> map = new HashMap<>();
        List<Node> nodes = getNodes(node);
        for (Node cur : nodes) {
            map.put(cur, new Node(cur.val, new ArrayList<>()));
        }
        for (Node cur : nodes) {
            Node newNode = map.get(cur);
            for (Node neighbor : cur.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    List<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
