package ShortestPath;

import java.util.*;

// https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
// Time Complexity : O( E log(V) )
// it will not work for negative weight edge and negative weight cycle
public class III_DijkstraAlgorithm
{
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair<Integer,Integer>>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<Pair<Integer,Integer>>());
        }

        for(int i=0; i<m; i++){
            adj.get(edges[i][0]).add(new Pair<>(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair<>(edges[i][0], edges[i][2]));
        }

        int[] parent = new int[n+1];
        int[] dist = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        PriorityQueue<Pair<Integer,Integer>>pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        pq.offer(new Pair<>(0,1));

        while(!pq.isEmpty()){
            Pair<Integer, Integer> p = pq.poll();
            int d = p.getKey();
            int node = p.getValue();

            if (d > dist[node]) continue;

            for(Pair<Integer, Integer> nn: adj.get(node)){
                int nNode = nn.getKey();
                int nWeight = nn.getValue();

                if(dist[nNode] > dist[node]+nWeight){
                    dist[nNode] = dist[node] + nWeight;
                    pq.offer(new Pair<>(dist[node], nNode));
                    parent[nNode] = node;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        while(parent[n] != n){
            ans.add(n);
            n = parent[n];
        }
        ans.add(1);
        Collections.reverse(ans);

        List<Integer> result = new ArrayList<>();
        result.add(dist[ans.get(ans.size() - 1)]);
        result.addAll(ans);
        return result;
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
