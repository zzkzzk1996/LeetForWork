package graph.kruskal;

import unionFind.Implement.PathCompressionImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-27 16:30
 */

public class Kruskal {

    public void kruskalMST(Graph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.addAll(graph.list);

        List<Edge> res = new ArrayList<>();
        PathCompressionImplement unionFind = new PathCompressionImplement(graph.vertices);
        int components = graph.vertices;

        while (!pq.isEmpty()) {
            if (components <= 1) {
                break;
            }
            Edge edge = pq.poll();
            if (unionFind.connected(edge.start, edge.end)) {
                continue;
            }
            unionFind.union(edge.start, edge.end);
            components--;
            res.add(edge);
        }
        print(res);
    }

    public void print(List<Edge> res) {
        int total = 0;
        for (int i = 0; i < res.size(); i++) {
            System.out.println("Edge : " + res.get(i).start + " - " + res.get(i).end + " Weight : " + res.get(i).weight);
            total += res.get(i).weight;
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
        Kruskal kruskal = new Kruskal();
        kruskal.kruskalMST(graph);
    }
}
