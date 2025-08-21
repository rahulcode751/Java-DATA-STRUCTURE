package MinimumSpaningTree;

import java.util.*;

// TC = O(N+E) + O(E logE) +  O(E*4α*2)
class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt= wt;
    }

    @Override
    public int compareTo(Edge o)
    {
        return this.wt = o.wt;
    }
}
public class III_KrushkalAlgorithm
{
    static int spanningTree(int V, ArrayList<ArrayList<Pair<Integer,Integer>>> adj) {

        List<Edge> edges = new ArrayList<Edge>();
        // O(N + E)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).getKey();
                int wt = adj.get(i).get(j).getValue();
                int node = i;
                Edge temp = new Edge(i, adjNode, wt);
                edges.add(temp);
            }
        }
        II_DisjointSetRank ds = new II_DisjointSetRank(V);
        // M log M
        Collections.sort(edges);

        int mstWt = 0;
        // M x 4 x alpha x 2
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).wt;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;
                ds.unionByRank(u, v);
            }
        }

        return mstWt;
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

            I_PrimsAlgo.Pair<?, ?> pair = (I_PrimsAlgo.Pair<?, ?>) o;

            if (key != null ? !key.equals(pair.getKey()) : pair.getKey()
                    != null) return false;
            return value != null ? value.equals(pair.getValue()) : pair.getValue()
                    == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }
}
