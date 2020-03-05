package zDay17;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 582. Kill Process
 * @author: Zekun Zhang
 * @create: 2020-03-04 11:17
 */

public class KillProcess {
    /**
     * Graph : time limited
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Graph graph = new Graph();
        graph.addNode(new Node(0));
        for (Integer id : pid) {
            graph.addNode(new Node(id));
        }

        for (int i = 0; i < ppid.size(); i++) {
            Node parent = graph.getNode(ppid.get(i));
            if (!parent.childs.contains(graph.getNode(pid.get(i)))) {
                parent.childs.add(graph.getNode(pid.get(i)));
            }
        }

        List<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(graph.getNode(kill));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            res.add(cur.id);
            for (Node child : cur.childs) {
                queue.offer(child);
            }
        }
        return res;
    }

    class Graph  {
        List<Node> nodes;
        HashMap<Integer, Integer> map;
        public Graph() {
            this.map = new HashMap<>();
            this.nodes = new ArrayList<>();
        }

        public void addNode(Node node) {
            if (!map.containsKey(node.id)) {
                map.put(node.id, nodes.size());
                nodes.add(node);
            }
        }

        public Node getNode(int id) {
            if (map.containsKey(id)) {
                return nodes.get(map.get(id));
            }
            return null;
        }
    }

    class Node {
        List<Node> childs;
        int id;
        public Node(int id) {
            this.id = id;
            this.childs = new ArrayList<>();
        }
    }

    /**
     * Runtime fine
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public List<Integer> killProcess1(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            List<Integer> list = map.getOrDefault(parent, new ArrayList<>());
            list.add(child);
            map.put(parent, list);
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            if (map.containsKey(cur)) {
                for (Integer child : map.get(cur)) {
                    queue.offer(child);
                }
            }
        }
        return res;
    }
}
