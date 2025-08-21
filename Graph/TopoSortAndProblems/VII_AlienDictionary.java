package TopoSortAndProblems;

import java.util.*;
import java.util.stream.Collectors;

// https://www.geeksforgeeks.org/problems/alien-dictionary/1
public class VII_AlienDictionary
{
    public String findOrder(String[] words) {
        int n = words.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<26; i++){
            adj.add(new ArrayList<>());
        }

        Set<Character> usedChars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                usedChars.add(c);
            }
        }

        for(int i=0; i<n-1; i++){
            char[] s1 = words[i].toCharArray();
            char[] s2 = words[i+1].toCharArray();

            int sz = Math.min(s1.length,s2.length);
            boolean flag = false;
            for(int j=0; j<sz; j++){
                if(s1[j] != s2[j]){
                    adj.get(s1[j] - 'a').add(s2[j] - 'a');
                    flag = true;
                    break;
                }
            }
            if (flag == false && s1.length > s2.length) {
                return "";
            }
        }

        ArrayList<Character> ch = toposort(adj,usedChars);
        if(ch.size() != usedChars.size()) return "";
        String s = ch.stream().map(String::valueOf).collect(Collectors.joining());
        return s;
    }

    public ArrayList<Character> toposort(ArrayList<ArrayList<Integer>> adj, Set<Character> usedChars){
        int[] indegree = new int[26];


        for(int i=0; i<26; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<26; i++){
            if(usedChars.contains((char)(i+'a')) && indegree[i] == 0){
                q.offer(i);
            }
        }

        int i = 0;
        ArrayList<Character> ch = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ch.add((char)('a' + node));


            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        return ch;
    }
}
