package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-11-21 21:04
 */

public class GraphNode {
    public int label;

    public List<GraphNode> neighbors;

    public GraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}
