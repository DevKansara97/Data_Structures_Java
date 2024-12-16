
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftNodesSum = sumOfNodes(root.left);
        int rightNodesSum = sumOfNodes(root.right);

        return leftNodesSum + rightNodesSum + root.data;
    }

    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // O(n^2):
    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int diam1 = diameterOfTree(root.left);
        int diam2 = diameterOfTree(root.right);
        int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }

    // O(n):
    static class TreeInfo {

        int ht;
        int diam;

        public TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameterOfTree2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameterOfTree2(root.left);
        TreeInfo right = diameterOfTree2(root.right);

        int currHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int currDiam = Math.max(diam3, Math.max(diam1, diam2));
        TreeInfo currInfo = new TreeInfo(currHeight, currDiam);

        return currInfo;
    }

    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data == root2.data) {
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        }

        return false;
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // preOrder(root);
        // inOrder(root);
        // postOrder(root);
        // levelOrder(root);
        // System.out.println(countNodes(root));
        // System.out.println(sumOfNodes(root));
        // System.out.println(heightOfTree(root));
        // System.out.println(diameterOfTree(root));
        // System.out.println(diameterOfTree2(root).diam);
        int[] treeNodes = {7, 6, 4, -1, -1, 1, 2, -1, -1, 3, -1, -1, 5, -1, -1};
        int[] subTreeNodes = {1, 2, -1, -1, 3, -1, -1};

        BinaryTree mainTree = new BinaryTree();
        BinaryTree subTree = new BinaryTree();

        Node mainTreeRoot = mainTree.buildTree(treeNodes);
        Node subTreeRoot = subTree.buildTree(subTreeNodes);

        System.out.println(isSubTree(mainTreeRoot, subTreeRoot));
    }
}
