package ShortestPath;

import java.util.*;

// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
public class I_ShortestPathInUndirectedUnitWeightGraph
{
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] weight = new int[n];
        Arrays.fill(weight, -1);

        Queue<Integer> q = new LinkedList<>();
        weight[src] = 0;
        q.offer(src);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                if (weight[neighbor] == -1) {
                    weight[neighbor] = weight[node] + 1;
                    q.offer(neighbor);
                }
            }
        }

        return weight;
    }
}
