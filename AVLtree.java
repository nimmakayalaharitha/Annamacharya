public class AVLtree {
	class Node {
		int key;
		int height;
		Node left, right;

		public Node(int value) {
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

	Node insert(Node node, int key) {
		if (node == null)
			return new Node(key);

		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		else
			return node;

		node.height = 1 + Math.max(height(node.left), height(node.right));

		int balance = getBalance(node);

		// Left Left Case
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	void insert(int key) {
		root = insert(root, key);
	}

	void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.print(node.key + " ");
			printInOrder(node.right);
		}
	}

	public static void main(String[] args) {
		AVLtree tree = new AVLtree();
		tree.insert(10);
		tree.insert(25);
		tree.insert(5); 
		tree.insert(13);
		tree.insert(40);
		tree.insert(50);
		tree.insert(60);
		tree.insert(0);

		System.out.println("In-order print of AVL tree:");
		tree.printInOrder(tree.root);
	}
}