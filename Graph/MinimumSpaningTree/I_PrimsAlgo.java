package MinimumSpaningTree;
import ShortestPath.VII_NetworkDeleyTime;

import java.util.*;

//  TC = O(E*logE), where E = no. of given edges.
public class I_PrimsAlgo
{
    int spanningTree(int V, ArrayList<ArrayList<Pair<Integer, Integer>>> adj) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());

        int[] vis = new int[V];
        // {wt, node}
        pq.add(new Pair(0, 0));
        int sum = 0;
        while (pq.size() > 0) {
            int wt = (int) pq.peek().getKey();
            int node = (int) pq.peek().getValue();
            pq.remove();

            if (vis[node] == 1) continue;

            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).getValue();
                int adjNode = adj.get(node).get(i).getKey();
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }
        return sum;
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

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

}
