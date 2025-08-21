package ProblemsOnBfsAndDfs;

import java.util.ArrayList;

// https://leetcode.com/problems/number-of-provinces/
public class I_NumberOfProvinces
{
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean[] vis = new boolean[v];

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<v; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }


        int count = 0;

        for(int i=0; i<v; i++){
            if(vis[i] == false){
                count++;
                dfs(vis,adjList,i);
            }
        }

        return count;
    }

    public void dfs(boolean[] vis, ArrayList<ArrayList<Integer>> adjList,int u){
        vis[u] = true;

        for(Integer node: adjList.get(u)){
            if(vis[node] == false){
                dfs(vis,adjList,node);
            }
        }
    }
}
