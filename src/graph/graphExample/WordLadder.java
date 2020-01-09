package graph.graphExample;

import java.util.*;

/**
 * @program: LeetForWork
 * @description: 127. Word Ladder
 * @author: Zekun Zhang
 * @create: 2020-01-09 15:50
 */

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Graph graph = new Graph();
        for (String word : wordList) {
            graph.addNode(new Node(word));
        }

        if (!wordList.contains(beginWord)) {
            graph.addNode(new Node(beginWord));
            wordList.add(beginWord);
        }

        for (String word : wordList) {
            Node node = graph.getNode(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordArr = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordArr[i] = j;
                    String temp = new String(wordArr);
                    if (graph.getNode(temp) != null && !temp.equals(word) && !node.neighbors.contains(temp)) {
                        node.neighbors.add(graph.getNode(temp));
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
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.word.equals(endWord)) return res;
                for (Node neighbor : node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
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
        List<Node> neighbors;

        public Node(String word) {
            this.word = word;
            this.neighbors = new ArrayList<>();
        }
    }
}
