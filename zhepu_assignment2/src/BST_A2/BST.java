package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	@Override
	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}

	@Override
//	public boolean insert(String s) {
//		// TODO Auto-generated method stub
//		if (getRoot() == null) {
//			root = new BST_Node(s);
//			size++;
//		}
//		if (getRoot().insertNode(s)) {
//			size++;
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	// another way
	public boolean insert(String s) {
		// TODO Auto-generated method stub
		if (getRoot() == null) {
			root = new BST_Node(s);
			size++;
		}
		if (getRoot().insertNode(root, s) != null) {
			size++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(String s) {
		// TODO Auto-generated method stub
		if (contains(s)) {
			this.root = getRoot().removeNode(root, s);
			size--;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		return (getRoot() == null) ? null : getRoot().findMin(root).data;
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		return (getRoot() == null) ? null : getRoot().findMax(root).data;
	}

	@Override
	public boolean empty() {
		// root is null, return true
		if(getRoot() == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if (getRoot() != null) {
			return getRoot().containsNode(s);
		} else {
			return false;
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public int height() {
		if (root == null) return -1;
		return getRoot().getHeight(root, -1);
	}

}