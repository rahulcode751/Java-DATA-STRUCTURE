package ProblemsOnBfsAndDfs;

import java.util.Arrays;

// https://leetcode.com/problems/is-graph-bipartite/description/
/*
Bipartite Graph = DFS
1. A graph that can be coloured with exactly two colors and no adjacent node should have same color
2. If an graph has odd length cycle it cannot be bipartite
3. Any linear graph is bipartite graph
 */
public class IX_BipartiteGraph
{
    public boolean isBipartite(int[][] graph) {
        int r = graph.length;

        int[] color = new int[r];
        Arrays.fill(color,-1);

        for(int i=0; i<r; i++){
            if(color[i] == -1){
                if(dfs(color,0,graph,i) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[] color, int col,int[][] graph, int node){
        color[node] = col;

        for(int i=0; i<graph[node].length; i++){
            int n = graph[node][i];

            if(color[n] == -1){
                if(dfs(color, 1-col, graph, n) == false) return false;
            }else if(color[n] == col){
                return false;
            }
        }
        return true;
    }
}
