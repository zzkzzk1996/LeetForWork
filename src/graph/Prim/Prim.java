package graph.Prim;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-27 15:48
 */

public class Prim {
    public void primMST(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];
        int[] parents = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);

        /**
         * Pair : weight, vertex
         */
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        minDist[0] = 0;
        pq.offer(new Pair<>(minDist[0], 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            List<Edge> list = graph.list[vertex];
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if (!visited[edge.end]) {
                    int des = edge.end;
                    int curDist = edge.weight;
                    if (curDist < minDist[des]) {
                        pq.offer(new Pair<>(curDist, des));
                        minDist[des] = curDist;
                        parents[des] = vertex;
                    }
                }
            }
        }
        print(parents, minDist, graph.vertices);
    }

    public void print(int[] parents, int[] minDist, int vertices) {
        int total = 0;
        for (int i = 1; i < parents.length; i++) {
            System.out.println("Edge : " + i + " - " + parents[i] + " minDist : " + minDist[i]);
            total += minDist[i];
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 6);
        Prim prim = new Prim();
        prim.primMST(graph);
    }
}
