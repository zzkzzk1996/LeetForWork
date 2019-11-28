package graph.shortestPath.dijkstra;

import graph.kruskal.Kruskal;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-27 20:34
 */

public class Dijkstra {

    public void dijkstra(Graph graph) {

        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];

        /**
         * pair : minDist, vertex
         */
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[0] = 0;
        pq.offer(new Pair<>(minDist[0], 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            List<Edge> edges = graph.list[vertex];
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                if (!visited[edge.end]) {
                    int des = edge.end;
                    int curDist = minDist[vertex] + edge.weight;
                    if (curDist < minDist[des]) {
                        pq.offer(new Pair<>(curDist, des));
                        minDist[des] = curDist;
                    }
                }
            }
        }
        print(minDist);
    }

    public void print(int[] minDist) {
        for (int i = 0; i < minDist.length; i++) {
            System.out.println("Vertex 0 : "  + " - " + i + " minDist : " + minDist[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 6);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph);
    }
}
