
import java.util.*;

public class BinarySearchTree {

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            // left subtree
            root.left = insert(root.left, val);
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // Inorder: root -> left -> right
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> inorder = new ArrayList<>();

        inorder.add(root.val);
        inorder.addAll(inorderTraversal(root.left));
        inorder.addAll(inorderTraversal(root.right));

        return inorder;
    }

    public static boolean search(TreeNode root, int val) {

        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        }

        if (val < root.val) {
            // left subtree
            return search(root.left, val);
        } else {
            // right subtree
            return search(root.right, val);
        }
    }

    public static TreeNode delete(TreeNode root, int val) {

        if (!search(root, val)) {
            System.out.println("Value doesn't exist in the tree");
            return root;
        }

        if (val < root.val) { // Left Subtree
            root.left = delete(root.left, val);
        } else if (val > root.val) { // Right Subtree
            root.right = delete(root.right, val);
        } else {

            // Case1: Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case2: One Child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case3: Two Children
            TreeNode IS = inorderSuccessor(root.right);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);

        }
        return root;
    }

    public static TreeNode inorderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] values = {5, 1, 3, 4, 2, 7};
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();

        System.out.println(search(root, 3));
        delete(root, 10);
        inOrder(root);
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }
}
