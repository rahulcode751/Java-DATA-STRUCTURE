package ShortestPath;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class VI_CheapestFlightWithinKStop
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edges: flights){
            adj.get(edges[0]).add(new Pair<>(edges[1],edges[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair<Integer, Pair<Integer, Integer>>> pq = new LinkedList<>();
        pq.offer(new Pair<>(0,new Pair<>(src,0)));

        while(!pq.isEmpty()){
            Pair<Integer, Pair<Integer, Integer>> p = pq.poll();
            int stop = p.getKey();
            int u = p.getValue().getKey();
            int d = p.getValue().getValue();

            // if(u == dst) return d;
            if(stop > k) continue;

            for(Pair<Integer, Integer> v: adj.get(u)){
                if(stop <= k && dist[v.getKey()] > dist[u] + v.getValue()){
                    dist[v.getKey()] = d + v.getValue();
                    pq.offer(new Pair<>(stop+1, new Pair<>(v.getKey(), dist[v.getKey()])));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
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
