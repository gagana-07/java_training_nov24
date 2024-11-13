package linked;

class AVLTree {
    static class Node {
        int key, height;
        Node left;
        private Node right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    private Node root;
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }
    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.getRight());
    }
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.getRight();
        x.setRight(y);
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.getRight())) + 1;
        x.height = Math.max(height(x.left), height(x.getRight())) + 1;
        return x;
    }
    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.left;
        y.left = x;
        x.setRight(T2);
        x.height = Math.max(height(x.left), height(x.getRight())) + 1;
        y.height = Math.max(height(y.left), height(y.getRight())) + 1;
        return y;
    }
    public void insert(int key) {
        root = insert(root, key);
    }
    private Node insert(Node node, int key) {
        // Perform the normal BST insert
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.setRight(insert(node.getRight(), key));
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.getRight()));
        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        if (balance < -1 && key > node.getRight().key) {
            return leftRotate(node);
        }
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.getRight().key) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
        return node;
    }
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.getRight());
        }
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
        System.out.println("In-order traversal of the AVL tree:");
        tree.inOrder();
    }
}
