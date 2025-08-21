package Traversals;

import java.util.*;

public class Traversals
{
    static void preOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        arr.add(root.val);
        preOrder(root.left, arr);
        preOrder(root.right, arr);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        if (root == null) {
            return preorder;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.empty()) {
            root = st.pop();

            preorder.add(root.val);

            if (root.right != null) {
                st.push(root.right);
            }

            if (root.left != null) {
                st.push(root.left);
            }
        }
        return preorder;
    }

    static void inOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }
    static void postOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        postOrder(root.left, arr);
        postOrder(root.right, arr);
        arr.add(root.val);
    }
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) {
            return postorder;
        }

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while (!st1.empty()) {
            root = st1.pop();

            st2.push(root);

            if (root.left != null) {
                st1.push(root.left);
            }

            if (root.right != null) {
                st1.push(root.right);
            }
        }
        while (!st2.empty()) {
            postorder.add(st2.pop().val);
        }

        return postorder;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.isEmpty() == false){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode treeNode = q.poll();
                level.add(treeNode.val);
                if(treeNode.left != null){
                    q.add(treeNode.left);
                }
                if(treeNode.right != null){
                    q.add(treeNode.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
