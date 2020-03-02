package zDay12;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 127. Word Ladder
 * @author: Zekun Zhang
 * @create: 2020-02-24 17:57
 */

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        Graph graph = new Graph();
        for (String word : wordList) {
            graph.addNode(new Node(word));

        }

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                char[] charArr = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    charArr[i] = j;
                    String temp = new String(charArr);
                    if (graph.getNode(temp) != null && !word.equals(temp) && !graph.getNode(word).nexts.contains(graph.getNode(temp))) {
                        graph.getNode(word).nexts.add(graph.getNode(temp));
                    }
                }
            }
        }

        HashSet<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();


        visited.add(graph.getNode(beginWord));
        queue.offer(graph.getNode(beginWord));

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.word.equals(endWord)) return res;
                for (Node node : cur.nexts) {
                    if (visited.contains(node)) continue;
                    queue.offer(node);
                    visited.add(node);
                }
            }
        }
        return 0;

    }
    class Graph {

        List<Node> nodes;
        HashMap<String, Integer> map;

        public Graph() {
            this.nodes = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public void addNode(Node node) {
            map.put(node.word, nodes.size());
            nodes.add(node);
        }

        public Node getNode(String word) {
            if (map.containsKey(word)) {
                return nodes.get(map.get(word));
            }
            return null;
        }
    }
    class Node {

        String word;
        List<Node> nexts;

        public Node(String word) {
            this.word = word;
            this.nexts = new ArrayList<>();
        }
    }
}
