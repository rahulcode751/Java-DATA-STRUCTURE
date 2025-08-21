// https://www.geeksforgeeks.org/problems/longest-valid-word-with-all-prefixes/1
public class III_LongestValidWordWithAllPrefix
{
    private static Node root;

    public III_LongestValidWordWithAllPrefix() {
        root = new Node();
    }

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

    boolean checkAllPrefix(String word){
        Node node = root;
        boolean flag = true;
        for(int i=0; i<word.length(); i++){
            if(node.containsKey(word.charAt(i)) == true){
                node = node.get(word.charAt(i));
                flag = flag & node.isEnd();
            }else return false;
        }
        return flag;
    }
    public String longestValidWord(String[] words) {
        for(String it: words){
            insert(it);
        }

        String ans = "";
        for(String it: words){
            if(checkAllPrefix(it) == true){
                if(it.length() > ans.length()) ans = it;
                else if(it.length() == ans.length() && it.compareTo(ans) < 0){
                    ans = it;
                }
            }
        }
        return ans;
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
