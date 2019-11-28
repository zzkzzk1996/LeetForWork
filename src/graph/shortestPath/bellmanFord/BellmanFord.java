package graph.shortestPath.bellmanFord;

import java.util.Arrays;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-28 14:28
 */

public class BellmanFord {

    public void bellmanFord(Graph graph) {
        int[] minDist = new int[graph.vertices];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        for (int i = 1; i < graph.vertices; i++) {
            for (int j = 0; j < graph.list.size(); j++) {
                Edge edge = graph.list.get(j);
                int start = edge.start;
                int end = edge.end;
                int weight = edge.weight;
                if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                    minDist[end] = minDist[start] + weight;
                }
            }
        }

        for (int j = 0; j < graph.list.size(); j++) {
            Edge edge = graph.list.get(j);
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;
            if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                System.out.println("Negative cycle");
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
        graph.addEdge(2, 1, 1);
        graph.addEdge(3, 2, -2);
        graph.addEdge(1, 3, 2);
        graph.addEdge(4, 3, -1);
        graph.addEdge(4, 1, -4);
        graph.addEdge(5, 4, 1);
        graph.addEdge(0, 5, 8);
        graph.addEdge(0, 1, 10);
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.bellmanFord(graph);
    }
}
