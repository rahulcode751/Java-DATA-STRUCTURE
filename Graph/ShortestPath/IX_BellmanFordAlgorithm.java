package ShortestPath;

import java.util.ArrayList;

// help us to detect negative weight cycle
// if its a undirected graph convert into directed graph with two edges with same weight that u->v and v->u with same weight
// relax all the edges n-1 times sequentially
// Time Complexity: O(V*E), where V = no. of vertices and E = no. of Edges.
public class IX_BellmanFordAlgorithm
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int)(1e8);
        dist[S] = 0;
        // V x E
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
