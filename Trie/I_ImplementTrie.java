// https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class I_ImplementTrie
{
    private static Node root;

    public I_ImplementTrie() {
        root = new Node();
    }

    // TC = O(N) // n = length of word
    public void insert(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            if(node.containsKey(word.charAt(i)) == false){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    // TC = O(N) // n = length of word
    public boolean search(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            if(node.containsKey(word.charAt(i)) == true){
                node = node.get(word.charAt(i));
            }else return false;
        }
        if(node.isEnd() == true) return true;
        return false;
    }

    // TC = O(N) // n = length of word
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0; i<prefix.length(); i++){
            if(node.containsKey(prefix.charAt(i)) == true){
                node = node.get(prefix.charAt(i));
            }else return false;
        }
        return true;
    }

    class Node{
        Node[] links = new Node[26];
        boolean flag = false;

        Node(){}

        boolean containsKey(char ch){
            return (links[ch-'a'] != null);
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        Node put(char ch, Node node){
            links[ch-'a'] = node;
            return node;
        }

        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }
    }
}
