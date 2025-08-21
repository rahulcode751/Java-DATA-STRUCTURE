package MinimumSpaningTree;

import java.util.*;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class IV_NumberOfOperationToMakeConnected
{
        class Edge {
            int src;
            int dest;

            public Edge(int src, int dest){
                this.src = src;
                this.dest = dest;
            }
        }
        public int makeConnected(int V, int[][] adj) {
            List<Edge> edges = new ArrayList<Edge>();
            for (int[] it: adj) {
                int u = it[0];
                int v = it[1];
                Edge temp = new Edge(u, v);
                edges.add(temp);
            }
            II_DisjointSetRank ds = new II_DisjointSetRank(V);

            int cnt = 0;
            for (int i = 0; i < edges.size(); i++) {
                int u = edges.get(i).src;
                int v = edges.get(i).dest;

                if (ds.findUPar(u) != ds.findUPar(v)) {
                    ds.unionByRank(u, v);
                }
                else cnt++;
            }

            int s = 0;
            for(int i=0; i<V; i++){
                if(ds.parent.get(i) == i) s++;
            }

            if(s == 1) return 0;

            System.out.println(s + " " + cnt + " " + (s-cnt));
            if(cnt >= s - 1) return s - 1;
            return -1;

        }
        class II_DisjointSetRank
        {
            List<Integer> rank = new ArrayList<>();
            List<Integer> parent = new ArrayList<>();
            public II_DisjointSetRank(int n) {
                for (int i = 0; i < n; i++) {
                    rank.add(0);
                    parent.add(i);
                }
            }

            public int findUPar(int node) {
                if (node == parent.get(node)) {
                    return node;
                }
                int ulp = findUPar(parent.get(node));
                parent.set(node, ulp);
                return parent.get(node);
            }

            public void unionByRank(int u, int v) {
                int ulp_u = findUPar(u);
                int ulp_v = findUPar(v);
                if (ulp_u == ulp_v) return;
                if (rank.get(ulp_u) < rank.get(ulp_v)) {
                    parent.set(ulp_u, ulp_v);
                } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                    parent.set(ulp_v, ulp_u);
                } else {
                    parent.set(ulp_v, ulp_u);
                    int rankU = rank.get(ulp_u);
                    rank.set(ulp_u, rankU + 1);
                }
            }
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
