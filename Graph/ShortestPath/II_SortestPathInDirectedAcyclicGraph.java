package ShortestPath;


import java.security.KeyPair;
import java.util.*;

// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/0
public class II_SortestPathInDirectedAcyclicGraph
{
    private void topoSort(int node, ArrayList <ArrayList<Pair>> adj, int vis[], Stack < Integer > st) {

        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = (int) adj.get(node).get(i).getKey();
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }
    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList < ArrayList <Pair>> adj = new ArrayList < > ();
        for (int i = 0; i < N; i++) {
            ArrayList <Pair> temp = new ArrayList < Pair > ();
            adj.add(temp);
        }
        //We create a graph first in the form of an adjacency list.

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int vis[] = new int[N];

        Stack < Integer > st = new Stack < > ();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }
        int dist[] = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = (int)(1e9);
        }

        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = (int) adj.get(node).get(i).getKey();
                int wt = (int) adj.get(node).get(i).getValue();

                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
            return value != null ? value.equals(pair.value) : pair.value == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }

}
