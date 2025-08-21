package ShortestPath;

import java.util.*;

// https://leetcode.com/problems/network-delay-time/description/
public class VII_NetworkDeleyTime
{
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edges: times){
            adj.get(edges[0]).add(new Pair<>(edges[1],edges[2]));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        pq.offer(new Pair<>(0,k));

        while(!pq.isEmpty()){
            Pair<Integer,Integer> p = pq.poll();
            int d = p.getKey();
            int u = p.getValue();

            for(Pair<Integer, Integer> v: adj.get(u)){
                if(dist[v.getKey()] > dist[u] + v.getValue()){
                    dist[v.getKey()] = d + v.getValue();
                    pq.offer(new Pair<>(dist[v.getKey()],v.getKey()));
                }
            }
        }
        int mx = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            mx = Math.max(mx,dist[i]);
        }
        return mx;
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
