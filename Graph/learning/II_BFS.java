package learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class II_BFS
{
    // SC = O(3*N)
    // TC = O(N) + O(2*E)
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int v)
    {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean [] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it: adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}
