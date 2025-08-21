package learning;

import java.util.ArrayList;

public class III_DFS
{
    // SC = O(3*N)
    // TC = O(N) + O(2*E) for undirected and for directed its O(N) + O(E)
    public static  ArrayList<Integer> main(ArrayList<ArrayList<Integer>> adj, int v)
    {
        boolean [] vis = new boolean[v+1];
        vis[0] = true;
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(0,vis,dfs,adj);
        return dfs;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = true;
        dfs.add(node);

        for(Integer nodes: adj.get(node)){
            if(vis[nodes] == false){
                dfs(nodes,vis,dfs,adj);
            }
        }

    }
}
