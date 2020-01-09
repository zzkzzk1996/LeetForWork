package graph;

import graph.prim.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2020-01-08 18:33
 */

public class BidirectionalBFS {
    public int BidirectionalBFS(GraphNode start, GraphNode end) {
        Queue<GraphNode> startQueue = new LinkedList<>();
        HashSet<GraphNode> startVisited = new HashSet<>();
        startQueue.offer(start);
        startVisited.add(start);

        Queue<GraphNode> endQueue = new LinkedList<>();
        HashSet<GraphNode> endVisited = new HashSet<>();
        endQueue.offer(end);
        endVisited.add(end);

        int res = 0;

        while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
            int startSize = startQueue.size();
            res++;
            for (int i = 0; i < startSize; i++) {
                GraphNode node = startQueue.poll();
                for (GraphNode neighbor : node.neighbors) {
                    if (endVisited.contains(neighbor)) return res;
                    if (!startVisited.contains(neighbor)) {
                        startVisited.add(neighbor);
                        startQueue.offer(neighbor);
                    }
                }
            }

            int endSize = endQueue.size();
            res++;
            for (int i = 0; i < endSize; i++) {
                GraphNode node = endQueue.poll();
                for (GraphNode neighbor : node.neighbors) {
                    if (startVisited.contains(neighbor)) return res;
                    if (!endVisited.contains(neighbor)) {
                        endQueue.offer(neighbor);
                        endVisited.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }
}
