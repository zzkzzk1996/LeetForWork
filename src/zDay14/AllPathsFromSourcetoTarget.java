package zDay14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 797. All Paths From Source to Target
 * @author: Zekun Zhang
 * @create: 2020-03-01 21:49
 */

public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0) return res;
        Graph g = new Graph();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] != null || graph[i].length != 0) {
                g.addNode(new Node(i));
            }
        }

        for (int i = 0; i < graph.length; i++) {
            int[] edges = graph[i];
            for (int edge : edges) {
                if (g.getNode(edge) != null && !g.getNode(i).neighbors.contains(g.getNode(edge))) {
                    g.getNode(i).neighbors.add(g.getNode(edge));
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        helper(res, list, g.getNode(0), g.getNode(graph.length - 1));
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, Node node, Node target) {
        if (node == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (Node neighbor : node.neighbors) {
            list.add(neighbor.val);
            helper(res, list, neighbor, target);
            list.remove(list.size() - 1);
        }
    }

    class Graph {

        List<Node> nodes;
        HashMap<Integer, Integer> map;
        public Graph() {
            this.map = new HashMap<>();
            this.nodes = new ArrayList<>();
        }

        public void addNode(Node node) {
            map.put(node.val, nodes.size());
            nodes.add(node);
        }

        public Node getNode(Integer val) {
            if (map.containsKey(val)) {
                return nodes.get(map.get(val));
            }
            return null;
        }
    }

    class Node {
        int val;
        List<Node> neighbors;
        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
}
