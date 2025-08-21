import Traversals.TreeNode;

public class IX_InorderSuccessor
{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode node){
        TreeNode successor = null;

        while(root != null){
            if(node.val >= root.val){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
