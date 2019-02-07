package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;

	BST_Node(String data) {
		this.data = data;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------

	public boolean containsNode(String s) {
		if (s.compareTo(this.data) == 0) {
			return true;
		} else if (s.compareTo(this.data) < 0) {
			if (this.left == null) {
				return false;
			} else {
				return this.left.containsNode(s);
			}
		} else {
			if (this.right == null) {
				return false;
			} else {
				return this.right.containsNode(s);
			}
		}
	}

	public boolean insertNode(String s) {
		if (s.compareTo(this.data) == 0) { // element already exists, cannot be inserted
			return false;
		} else if (s.compareTo(this.data) < 0) { // s is smaller than the root
			if (this.left == null) {
				this.left = new BST_Node(s);
				return true;
			} else { 
				return this.left.insertNode(s);
			}
		} else { // s is bigger than the root
			if (this.right == null) {
				this.right = new BST_Node(s);
				return true;
			} else {
				return this.right.insertNode(s);
			}
		}
	}
	
	// another way to insert
	public BST_Node insertNode(BST_Node root, String s) {
		if (root == null) return new BST_Node(s);
		if (s.compareTo(root.data) == 0) { // element already exists, cannot be inserted
			return null;
		} else if (s.compareTo(root.data) < 0) { // s is smaller than the root
			root.left = insertNode(root.left, s);
		} else { // s is bigger than the root
			root.right = insertNode(root.right, s);
		}
		return root;
	}

	public BST_Node removeNode(BST_Node root, String s) {
		if (root == null) return root;
		if (s.compareTo(root.data) == 0) {
			// case #1: this node is a leaf node
			// case #2: this node has only 1 child node
			if (root.left == null) return root.right;
			if (root.right == null) return root.left;
			
			// case #3: this node has 2 child nodes
			BST_Node successor = findMin(root.right);
			root.data = successor.data;
			root.right = removeNode(root.right, successor.data);
			
		} else if (s.compareTo(root.data) < 0) {
			root.left = removeNode(root.left, s);
		} else {
			root.right = removeNode(root.right, s);
		}
		return root;
	}

	public BST_Node findMin(BST_Node min_node) {
		while (min_node.left != null) {
			min_node = min_node.left;
		}
		return min_node;
	}

	public BST_Node findMax(BST_Node max_node) {
		while (max_node.right != null) {
			max_node = max_node.right;
		}
		return max_node;
	}

	public int getHeight(BST_Node root, int height) {
		if (root == null) return height;
		return Math.max(getHeight(root.left, height+1), getHeight(root.right, height+1));
	}

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}