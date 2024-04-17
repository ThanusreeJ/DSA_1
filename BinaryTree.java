import java.util.*;
import java.util.LinkedList;
public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }
    public static Node root;
    public static void levelOrderTraversal(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.remove();
            System.out.println(temp.data+" ");
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
    }
    public static void inOrderTraversal(Node root){
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data);
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(Node root){
        if(root==null) return;
        System.out.print(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public static void postOrderTraversal(Node root){
        if(root==null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data);
    }
    public static int maxDepth(Node root){
        if(root==null){
            return 0;
        }
        int leftdepth=maxDepth(root.left);
        int rightdepth=maxDepth(root.right);
        return Math.max(leftdepth,rightdepth)+1;

    }
    public static Node lowestCommonAncestor(Node root,int p,int q){
        if(root==null||root.data==p||root.data== q){
            return root;
        }
        Node left=lowestCommonAncestor(root.left, p, q);
        Node right=lowestCommonAncestor(root.right, p, q);
        if(left==null){
            return right;
        }
        if(right ==null){
            return left;
        }
        return root;
    }
    public static void preOrderTraversalIterative(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                System.out.print(curr.data + " ");
                curr = curr.left;
            }
            Node temp = st.pop();
            curr = temp.right;
        }
        System.out.println();
    }

    public static void inOrderTraversalIterative(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            Node temp = st.pop();
            System.out.print(temp.data + " ");
            curr = temp.right;
        }
        System.out.println();
    }

    public static void postOrderTraversalIterative(Node root) {
        if (root == null)
            return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node temp = st1.pop();
            st2.push(temp);
            if (temp.left != null)
                st1.push(temp.left);
            if (temp.right != null)
                st1.push(temp.right);
        }
        while (!st2.isEmpty()) {
            System.out.print(st2.pop().data + " ");
        }
        System.out.println();
    }
    public static int distBtwRootToNode(Node root,int a){
        if(root==null){
            return -1;
        }
        if(root.data==a){
            return 0;
        }
        int ld=distBtwRootToNode(root.left, a);
        int rd=distBtwRootToNode(root.right, a);
        if(ld==-1&&rd==-1){
            return -1;
        }
        else if(ld==-1){
            return rd+1;
        }
        return ld+1;
    }
    public static int findDist(Node root,int a,int b){
        Node lca=lowestCommonAncestor(root, a, b);
        int ld=distBtwRootToNode(lca, a);
        int rd=distBtwRootToNode(lca, b);
        return ld+rd;
    }
    public static int solve(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=solve(root.left);
        int rightSum=solve(root.right);
        int data=root.data;
        int left=root.left==null?0:root.left.data;
        int right=root.right==null?0:root.right.data;
        root.data=leftSum+rightSum+left+right;
        return data;
    }
    public static void main(String[] args) {
 
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        //inOrderTraversal(root);
        //preOrderTraversal(root);
        //postOrderTraversal(root);
        //System.out.println("Height of tree is "
         //                +maxDepth(root));
        //System.out.println(lowestCommonAncestor(root, 2,3));
        //preOrderTraversalIterative(root);
        //postOrderTraversalIterative(root);
        //inOrderTraversalIterative(root);
        //System.out.println(findDist(root, 4, 7));
        System.out.println(solve(root));

    }

}    