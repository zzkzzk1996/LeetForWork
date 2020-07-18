package AlgorithmForCourse;

import java.util.*;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-03-11 17:30
 */

public class huawei3 {
    private static HashSet<Node> set = new HashSet<>();
    private static List<List<String>> circles = new ArrayList<>();
    private static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] infos = scan.nextLine().split(";");

        Graph graph = new Graph();
        for (String info : infos) {
            String[] temp = info.split(" ");
            if (graph.getNode(temp[0]) == null) {
                graph.addNode(new Node(temp[0]));
            }
            if (graph.getNode(temp[1]) == null) {
                graph.addNode(new Node(temp[1]));
            }
            graph.getNode(temp[0]).children.add(graph.getNode(temp[1]));
        }

    }

    private static void helper(List<String> list, Node cur) {

    }

    static class Graph {
        List<Node> nodes;
        HashMap<String, Integer> map;

        public Graph() {
            this.nodes = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public void addNode(Node node) {
            if (!map.containsKey(node.id)) {
                map.put(node.id, nodes.size());
                nodes.add(node);
            }
        }

        public Node getNode(String id) {
            if (map.containsKey(id)) {
                return nodes.get(map.get(id));
            }
            return null;
        }
    }

    static class Node {
        String id;
        List<Node> children;
        public Node(String id) {
            this.id = id;
            this.children = new ArrayList<>();
        }
    }
}
