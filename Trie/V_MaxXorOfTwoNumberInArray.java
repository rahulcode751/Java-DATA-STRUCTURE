// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
public class V_MaxXorOfTwoNumberInArray
{
    private Node root;

    V_MaxXorOfTwoNumberInArray(){
        root = new Node();
    }
    public void insert(int num){
        Node node = root;
        for(int i=31; i>=0; --i){
            int bit = (num>>i) & 1;
            if(node.containsKey(bit) == false){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    public int findMaximumXOR(int[] nums) {
        for(int i=0; i<nums.length; i++){
            insert(nums[i]);
        }

        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int mx = 0;
            int num = nums[i];
            Node node = root;
            for(int j=31; j>=0; --j){
                int bit = (num >> j) & 1;
                if(node.containsKey(1-bit) == true){
                    mx = mx | (1 << j);
                    node = node.get(1-bit);
                }else node = node.get(bit);
            }
            ans = Math.max(ans,mx);
        }
        return ans;
    }
    class Node{
        Node links[] = new Node[2];
        public Node(){}

        boolean containsKey(int ind){
            return (links[ind] != null);
        }
        Node get(int ind){
            return links[ind];
        }
        void put(int ind, Node node){
            links[ind] = node;
        }
    }
}
