package OtherAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//  AP is a vertex so if you remove that vertex the graph is broken into two or more components
// tin[] = time of insertion
// low[] = min of all adjacent node apart from its parent and visited nodes
// articulation points: the edge whose removal makes the graph splits into diff components
public class ArticulationPoint
{
    private int timer = 1;

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        Set<Integer> apSet = new HashSet<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, adj, tin, low, apSet);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(apSet);
        Collections.sort(ans);
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }

    private void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low, Set<Integer> apSet) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        int child = 0;

        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, adj, tin, low, apSet);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] >= tin[node] && parent != -1) {
                    apSet.add(node);
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (parent == -1 && child > 1) {
            apSet.add(node);
        }
    }
}
