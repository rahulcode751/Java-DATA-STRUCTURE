package learning;

import java.util.ArrayList;
import java.util.Collections;

public class I_GraphRepresentation
{
    public static void main(String[] args)
    {
        ///  Adjacency Matrix
        // Space Complexity = O(2*M)
        int n = 3, m = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // n+1
        for(int i = 0;i<=n ;i++){
            adj.add(new ArrayList<>());
        }

        // edge 1----2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // edge 2----3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // edge 1---3
        adj.get(1).add(3);
        adj.get(3).add(1);

        for(int i=0; i<adj.size(); i++){
            for(int j=0; j<adj.get(i).size(); j++){
                System.out.println(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
