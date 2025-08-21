package TopoSortAndProblems;

import java.util.*;

// https://leetcode.com/problems/find-eventual-safe-states/description/
public class VI_FindEventualSafeState
{
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int outdegree[] = new int[V];

        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i=0; i<V; i++){
            revAdj.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int j=0; j<graph[i].length; j++){
                revAdj.get(graph[i][j]).add(i);
            }
        }

        for (int i = 0; i < V; i++) {
            for (int it : revAdj.get(i)) {
                outdegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < V; i++) {
            if (outdegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);

            for (int it : revAdj.get(node)) {
                outdegree[it]--;
                if (outdegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        Collections.sort(topo);
        return topo;
    }
}
