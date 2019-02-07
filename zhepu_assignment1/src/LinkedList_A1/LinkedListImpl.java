package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node sentinel; // this will be the entry point to your linked list (the head)
	private int size;
	public LinkedListImpl() {// this constructor is needed for testing purposes. Please don't modify!
		sentinel = new Node(0); // Note that the root's data is not a true part of your data set!
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		this.size = 0;
	}

	public Node getRoot() { // leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		Node insert = new Node(elt);
		// if the list is empty
		if (isEmpty() && index == 0) {
			sentinel.next = insert;
			insert.prev = sentinel;
			sentinel.prev = insert; // the prev field of the sentinel will always point to the last data node in the linked node chain 
			insert.next = sentinel; // The next field of the last data node will point back to the sentinel
			size += 1;
			return true;
		} else if (isEmpty()) {
			return false;
		}
		
		// list is not empty
		if (index == size) { // insert at tail
			Node cur = getNodeAtPosition(index - 1);
			cur.next = insert;		
			insert.prev = cur;
			insert.next = sentinel;// this is how we defined sentinel
			sentinel.prev = insert;
			size += 1;
			return true;
		} else { // insert inside the list
			Node cur = getNodeAtPosition(index);
			if (cur == null) return false;
			Node prev = cur.prev;
			prev.next = insert;
			cur.prev = insert;
			insert.prev = prev;
			insert.next = cur;
		}		
		size += 1;
		return true;
	}

	@Override
	public boolean remove(int index) {
		// index and empty validation
		Node cur = getNodeAtPosition(index);
		if (cur == null) return false;
		// remove tail element
		if (index == size - 1) {
			sentinel.prev = cur.prev;
			cur.prev.next = sentinel;
			size--;
			return true;
		}
		
		// remove normal element
		Node prev = cur.prev;
		Node next = cur.next;
		prev.next = next;
		next.prev = prev;
		size--;
		return true;
	}

	@Override
	public double get(int index) {
		// validate the index and the list
		return getNodeAtPosition(index) == null ? Double.NaN : getNodeAtPosition(index).data;		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	@Override
	public void clear() {
		// set list as null except the sentinel
		sentinel.next = null;
		// set the size as 0
		size = 0;
	}
	
	public Node getNodeAtPosition(int index) {
		if (isEmpty() || index < 0 || index >= size) return null;
		int count = 0;
		Node temp = sentinel.next;
		while (count < index) {
			temp = temp.next;
			count++;
		}
		return temp;
	}
}
