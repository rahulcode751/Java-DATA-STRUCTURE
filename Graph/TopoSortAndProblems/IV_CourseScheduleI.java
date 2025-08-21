package TopoSortAndProblems;

import java.util.*;

// https://leetcode.com/problems/course-schedule/
public class IV_CourseScheduleI
{
    public boolean canFinish(int V, int[][] prerequisites) {
        int indegree[] = new int[V];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] item: prerequisites){
            adj.get(item[1]).add(item[0]);
        }

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            i++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return (i == V)? true: false;
    }
}
