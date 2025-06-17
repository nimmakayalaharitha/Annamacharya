
public class Binary2 {

    class Node {
        String key;
        int height;
        Node left, right;

        public Node(String value) {
            key = value;
            height = 1;
        }
    }

    Node root;

    int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    int getBalance(Node n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, String key) {
        if (node == null)
            return new Node(key);

        int cmp = key.compareTo(node.key);

        if (cmp < 0)
            node.left = insert(node.left, key);
        else if (cmp > 0)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rightRotate(node);

        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return leftRotate(node);

        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void insert(String key) {
        root = insert(root, key);
    }

    public void printTop() {
        if (root != null) {
            System.out.println("\n--- Tree Top ---");
            System.out.println("Root of the tree: " + root.key);
        } else {
            System.out.println("\n--- Tree Top ---");
            System.out.println("The tree is empty.");
        }
    }

    private Node findNode(Node node, String key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return findNode(node.left, key);
        } else if (cmp > 0) {
            return findNode(node.right, key);
        } else {
            return node;
        }
    }

    public void printChildren(String key) {
        System.out.println("\n--- Children of Node: " + key + " ---");
        Node node = findNode(root, key);
        if (node != null) {
            System.out.println("Node: " + node.key);
            if (node.left != null) {
                System.out.println("  Left child: " + node.left.key);
            } else {
                System.out.println("  Left child: null");
            }
            if (node.right != null) {
                System.out.println("  Right child: " + node.right.key);
            } else {
                System.out.println("  Right child: null");
            }
        } else {
            System.out.println("Node with key '" + key + "' not found in the tree.");
        }
    }

    public boolean search(String key) {
        System.out.println("\n--- Searching for: " + key + " ---");
        boolean found = findNode(root, key) != null;
        System.out.println("Key '" + key + "' " + (found ? "found" : "not found") + " in the tree.");
        return found;
    }

    public int countNodes() {
        return countNodesRecursive(root);
    }

    private int countNodesRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodesRecursive(node.left) + countNodesRecursive(node.right);
    }

    public int countLeafNodes() {
        return countLeafNodesRecursive(root);
    }

    private int countLeafNodesRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeafNodesRecursive(node.left) + countLeafNodesRecursive(node.right);
    }

    public void printInOrder() {
        System.out.println("\n--- In-order traversal (Left to Right) ---");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.key + " ");
            printInOrder(node.right);
        }
    }

    public void flipTree() {
        System.out.println("\n--- Flipping the tree (Mirror Image) ---");
        root = flipTreeRecursive(root);
        System.out.println("Tree flipped. In-order traversal will now be reversed.");
    }

    private Node flipTreeRecursive(Node node) {
        if (node == null) {
            return null;
        }

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        flipTreeRecursive(node.left);
        flipTreeRecursive(node.right);

        return node;
    }

    public void printAllPaths() {
        System.out.println("\n--- All Paths from Root to Leaves ---");
        if (root == null) {
            System.out.println("Tree is empty, no paths to print.");
            return;
        }
        printAllPathsRecursive(root, "");
    }

    private void printAllPathsRecursive(Node node, String currentPath) {
        if (node == null) {
            return;
        }

        currentPath += node.key + " -> ";

        if (node.left == null && node.right == null) {
            System.out.println(currentPath.substring(0, currentPath.length() - 4));
        } else {
            printAllPathsRecursive(node.left, currentPath);
            printAllPathsRecursive(node.right, currentPath);
        }
    }

    public static void main(String[] args) {
        Binary2 tree = new Binary2();

        tree.insert("mom");
        tree.insert("dad");
        tree.insert("you");
        tree.printTop();

        tree.printInOrder();

        tree.printChildren("mom");
        tree.printChildren("dad");
        tree.printChildren("you");

        tree.search("mom");
        tree.search("dad");

        System.out.println("\n--- Node Counts ---");
        System.out.println("Total nodes in the tree: " + tree.countNodes());

        System.out.println("Nodes without children (leaves): " + tree.countLeafNodes());

        tree.printAllPaths();

        tree.flipTree();
        tree.printInOrder();

        tree.printAllPaths();
    }
}