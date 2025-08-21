package ProblemsOnBfsAndDfs;

import java.util.*;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// TC = o(V) + o(2*E)
// SC = O(2*E) + O(N) + O(N)
public class IV_DetectCycleUndirectedGraphBFS
{
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCycleCheck(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfsCycleCheck(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(new Pair<>(start, -1));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.poll();
            int node = current.getKey();
            int parent = current.getValue();

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new Pair<>(neighbor, node));
                }
                else if (neighbor != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
