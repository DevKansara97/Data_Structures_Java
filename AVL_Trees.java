
public class AVL_Trees {

    static class Node {

        int val;
        Node left;
        Node right;
        int height;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean search(Node root, int val) {
        if (root == null) {
            return false;
        } else if (root.val == val) {
            return true;
        } else {
            if (root.val > val) { // Left Subtree
                return search(root.left, val);
            } else {
                return search(root.right, val);
            }
        }
    }

    public static Node insert(Node node, int val) {

        // Perform normal BST insertion:
        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        } else { // Equal keys not allowed in BST
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get Balance factor of this ancestor node
        int balance = getBalance(node);

        // If unbalanced, 4 cases arise:

        // Case 1: Left Left
        if (balance > 1 && val < node.left.val) {
            rightRotate(node);
        }

        // Case 2: Right Right
        if (balance < -1 && val > node.right.val) {
            leftRotate(node);
        }

        // Case 3: Left Right 
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Case 4: Right Left
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return unchanged Node
        return node;
    }

    public static int height(Node N) {
        if (N == null) {
            return 0;
        }

        return N.height;
    }

    public static int getBalance(Node N) {
        if (N == null) {
            return 0;
        }

        return height(N.left) - height(N.right);
    }

    public static Node rightRotate(Node z) {
        Node y = z.left;
        Node T3 = y.right;

        // Perform Rotation:
        y.right = z;
        z.left = T3;

        // Update Heights:
        z.height = 1 + Math.max(height(z.left), height(z.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Return root:
        return y;
    }

    public static Node leftRotate(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        // Perform Rotation:
        y.left = z;
        z.right = T2;

        // Update Heights:
        y.height = 1 + Math.max(height(y.left), height(y.right));
        z.height = 1 + Math.max(height(z.left), height(z.right));

        // Return root:
        return y;
    }

    public static void main(String[] args) {

    }
}
