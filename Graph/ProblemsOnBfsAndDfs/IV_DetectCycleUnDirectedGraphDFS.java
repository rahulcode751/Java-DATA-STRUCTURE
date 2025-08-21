package ProblemsOnBfsAndDfs;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// TC = o(v) + (2*E)
// SC = O(2*E)
public class IV_DetectCycleUnDirectedGraphDFS
{
    public boolean detectCycle(int node, int parent,List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (detectCycle(neighbor, node, adj, vis)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }
}
