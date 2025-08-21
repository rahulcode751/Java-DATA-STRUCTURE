// https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1
public class IV_CountDistinctSubstring
{
    private static Node root;

    public IV_CountDistinctSubstring() {
        root = new Node();
    }

    public static int countDistinctSubstring(String words) {
        root = new Node();
        int ans = 0;
        for (int i = 0; i < words.length(); i++) {
            Node node = root;
            for (int j = i; j < words.length(); j++) {
                char ch = words.charAt(j);
                if (!node.containsKey(ch)) {
                    ans++;
                    node.put(ch, new Node());
                }
                node = node.get(ch);

            }
        }
        return ans + 1;
    }

    static class Node{
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
