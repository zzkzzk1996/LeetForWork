package zDay12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 126. Word Ladder II
 * @author: Zekun Zhang
 * @create: 2020-02-24 11:56
 */

public class WordLadderII {
    List<List<String>> res = new ArrayList<>();
    HashSet<Node> visited = new HashSet<>();
    String end;
    int count;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(beginWord)) wordList.add(beginWord);
        this.end = endWord;
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
                    if (graph.getNode(temp) != null && !word.equals(temp) && !graph.getNode(word).nexts.contains(temp)) {
                        graph.getNode(word).nexts.add(graph.getNode(temp));
                    }
                }
            }
        }
        this.count = Integer.MAX_VALUE;
        visited.add(graph.getNode(beginWord));
        List<String> list = new ArrayList<>();
        list.add(graph.getNode(beginWord).word);
        helper(graph.getNode(beginWord), list, 1);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() > count) {
                res.remove(i--);
            }
        }
        return res;
    }

    private void helper(Node cur, List<String> list, int level) {
        if (cur.word.equals(end)) {
            count = Math.min(count, level);
            res.add(new ArrayList<>(list));
            return;
        }
        if (level >= count) return;
        for (Node node : cur.nexts) {
            if (!visited.contains(node)) {
                visited.add(node);
                list.add(node.word);
                helper(node, list, level + 1);
                visited.remove(node);
                list.remove(list.size() - 1);
            }
        }
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

