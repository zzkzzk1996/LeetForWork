package graph.shortestPath.bellmanFord;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-27 20:31
 */

public class Graph {

    int vertices;

    ArrayList<Edge> list;

    public Graph(int vertices) {
        this.vertices = vertices;
        list = new ArrayList<>();
    }

    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        list.add(edge);
    }
}
