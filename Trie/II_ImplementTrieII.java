
class II_ImplementTrieII {
    private Node root;

    public II_ImplementTrieII() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            if(node.containsKey(word.charAt(i)) == false){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordEqualToK(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            if(node.containsKey(word.charAt(i)) == false){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getEnd();
    }

    public int countWordStartWithK(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            if(node.containsKey(word.charAt(i)) == false){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++){
            if(node.containsKey(word.charAt(i)) == false){
                return;
            }
            node = node.get(word.charAt(i));
            node.reducePrefix();
        }
        node.deleteEnd();
    }

    class Node{
        Node[] links = new Node[26];
        int cntEndWith = 0;
        int cntPrefix = 0;

        Node(){}

        boolean containsKey(char ch){
            return (links[ch-'a'] != null);
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        void put(char ch, Node node){
            links[ch-'a'] = node;
        }

        void increaseEnd(){
            cntEndWith++;
        }

        void deleteEnd(){
            cntEndWith--;
        }

        int getEnd(){
            return cntEndWith;
        }

        void increasePrefix(){
            cntPrefix++;
        }

        void reducePrefix(){
            cntPrefix--;
        }

        int getPrefix(){
            return cntPrefix;
        }
    }
}
