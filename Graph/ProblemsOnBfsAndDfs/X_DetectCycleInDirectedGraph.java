package ProblemsOnBfsAndDfs;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class X_DetectCycleInDirectedGraph
{
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] item: edges){
            adj.get(item[0]).add(item[1]);
        }

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i=0; i<V; i++){
            if(vis[i] == false){
                if(dfs(vis,pathVis,adj,i) == true){
                    return true;
                }
            }
        }

        return false;
    }
    public boolean dfs(boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj,int node){
        vis[node] = true;
        pathVis[node] = true;

        for(int n: adj.get(node)){
            if(vis[n] == false){
                if(dfs(vis,pathVis,adj,n) == true) return true;
            }else if(pathVis[n] == true){
                return true;
            }
        }

        pathVis[node] = false;
        return false;
    }
}
