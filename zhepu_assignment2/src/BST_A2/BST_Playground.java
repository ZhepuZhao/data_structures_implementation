package BST_A2;

public class BST_Playground {

	public static void main(String[] args) {

		BST bst = new BST();
		BST bst2 = new BST();
		BST bst3 = new BST();
		// Oracle test
		System.out.println("--------------------Oracle test-----------------");
		bst3.insert("A");
		System.out.println("height: " + bst3.height());
		System.out.println("size: " + bst3.size());
		bst3.remove("A");
		System.out.println("height: " + bst3.height());
		System.out.println("size: " + bst3.size());
		bst3.insert("B");
		preOrderTraverse(bst3.getRoot());
		System.out.println("height: " + bst3.height());
		System.out.println("size: " + bst3.size());
		
		// Empty BST: contains
		System.out.println("----------------empty tree test-------------");
		System.out.println(bst.contains("1"));
		// Empty BST: size
		System.out.println(bst.size());
		// Empty BST: height
		System.out.println(bst.height());
		// Empty BST: root
		System.out.println(bst.getRoot() == null);
		System.out.println(bst.findMax());
		System.out.println(bst.findMin());
		
		// Insert some nodes
		System.out.println("--------------------insert-----------------");
		bst.insert("3");
		printLevelOrder(bst);
		System.out.println("");
		System.out.println(bst.contains("3"));
		System.out.println("size: " + bst.size());
		System.out.println("height: " + bst.height());
		System.out.println(bst.getRoot().toString());
		
		bst.insert("2");
		bst.insert("5");
		bst.insert("1");
		bst.insert("6");
		bst.insert("4");
		bst.insert("0");
		System.out.println("max: " + bst.findMax());
		System.out.println("min: " + bst.findMin());
		System.out.println(bst.insert("3"));
		System.out.println("size: " + bst.size());
		System.out.println("height: " + bst.height());
		printLevelOrder(bst);
		System.out.println("");
		preOrderTraverse(bst.getRoot());
		
		// remove nodes
		System.out.println("--------------------remove-----------------");
		bst.remove("0"); // remove leaf
		preOrderTraverse(bst.getRoot());
		System.out.println("size:" + bst.size());
		System.out.println("height: "+ bst.height());
		System.out.println("-------------------one end-----------------");
		bst.remove("2"); // remove node with 1 child
		preOrderTraverse(bst.getRoot());
		System.out.println("size:" + bst.size());
		System.out.println("height: "+ bst.height());
		System.out.println("-------------------one end-----------------");		
		bst.remove("3"); // remove node with 2 children
		System.out.println("remove not existing string: " + bst.remove("sdfgsfd"));
		preOrderTraverse(bst.getRoot());
		System.out.println("size:" + bst.size());
		System.out.println("height: "+ bst.height());
		
		System.out.println("-------------------remove empty tree-----------------");
		
		System.out.println(bst2.remove("d"));
		
		// more insertion
		System.out.println("--------------------insert more-----------------");
		bst.insert("7");
		bst.insert("2");
		bst.insert("3");
		bst.insert("3.3");
		preOrderTraverse(bst.getRoot());
		
		
		

	}
	
	public static void preOrderTraverse(BST_Node root) {
		if (root == null) return;
		System.out.println(root.toString());
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	
	static void printLevelOrder(BST tree) {
		// will print your current tree in Level-Order...
		// https://en.wikipedia.org/wiki/Tree_traversal
		// original statement: int h = tree.getRoot().getHeight();
		int h = tree.getRoot().getHeight(tree.getRoot(), -1);
		for (int i = 0; i <= h; i++) {
			printGivenLevel(tree.getRoot(), i);
		}

	}

	static void printGivenLevel(BST_Node root, int level) {
		if (root == null)
			return;
		if (level == 0)
			System.out.print(root.data + " ");
		else if (level > 0) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	static void printInOrder(BST_Node root) {
		// will print your current tree In-Order
		if (root != null) {
			printInOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			printInOrder(root.getRight());
		}
	}
}