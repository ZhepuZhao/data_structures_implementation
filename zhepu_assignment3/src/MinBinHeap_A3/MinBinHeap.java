package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; // load this array
	private int size;
	private static final int arraySize = 10000; // Everything in the array will initially
												// be null. This is ok! Just build out
												// from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); // 0th will be unused for simplicity
													// of child/parent computations...
													// the book/animation page both do this.
		this.size = 0;
	}

	// Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() {
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		// TODO Auto-generated method stub
		
		// Step 1: insert the element at the end of the heap
		int insertIndex = this.size + 1;
		this.array[insertIndex] = entry;
		
		// Step 2: bubble up the element as far as it can
		int parentIndex = insertIndex / 2;
		while (parentIndex != 0 && entry.getPriority() < this.array[parentIndex].getPriority()) {
			swap(this.array, insertIndex, parentIndex);
			insertIndex = parentIndex;
			parentIndex = insertIndex / 2;
		}
		this.size += 1;
	}

	@Override
	public void delMin() {
		// TODO Auto-generated method stub
		
		// Step 0: return if the heap is empty
		if (this.array[1] == null) return;
		
		// Step 1: store the last element in the tail
		EntryPair tail = this.array[this.size()];
		
		// Step 2: delete the last element
		this.array[this.size()] = null;
		
		// Step 3: delete the first element
		this.array[1] = null;
		
		// Step 4: bubble down the empty slot
		int cur = 1;
		int left = cur * 2;
		int right = cur * 2 + 1;
		
		// left < this.array.length is very important because the array can have not enough space for an element
		// hold its child. if we don't check this. this.array[left] will be nullpointer exception
		while (left < this.array.length && this.array[left] != null) {
			// set the smaller one between left and right into the current slot 
			if (right < this.array.length && this.array[right] != null && this.array[left].getPriority() > this.array[right].getPriority()) {
				if (tail.getPriority() > this.array[right].getPriority()) {
					this.array[cur] = this.array[right];
					this.array[right] = null;
					cur = right;
				} else {
					break;
				}

			} else {
				if (tail.getPriority() > this.array[left].getPriority()) {
					this.array[cur] = this.array[left];
					this.array[left] = null;
					cur = left;
				} else {
					break;
				}
			}			
			left = cur * 2;
			right = cur * 2 + 1;
		}
		if (this.size() != 1) {
			this.array[cur] = tail;
		}
		this.size -= 1;
		
		// another more practically efficient solution
		
		

		
	}

	@Override
	public EntryPair getMin() {
		// TODO Auto-generated method stub
		
		// return the element with index of 1 which is the minimum element in the heap
		return this.array[1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public void build(EntryPair[] entries) {
		// TODO Auto-generated method stub
		
		// return if the entries if empty
		if (entries == null) return;
		
		// Step 0: Add elements in entries to array
		
//		// reallocate memory for this.array if the length of entries is longer than this.array
//		if (entries.length >= this.array.length) {
//			this.array = new EntryPair[entries.length + 10];
//			array[0] = new EntryPair(null, -100000);
//		}
		for (int i = 0; i < entries.length; i++) {
			this.array[i + 1] = entries[i];
		}
		
		// Step 1: Find the first non-leaf which has at least one child
		this.size = entries.length;
		int start = this.size() / 2;
		
		// Step 2: go though the element starting form cur to the start
		for (int i = start; i > 0; i--) {
			int cur = i;
			int left = cur * 2;
			int right = cur * 2 + 1;
			while (left < this.array.length && this.array[left] != null) {
				if (right < this.array.length && this.array[right] != null && this.array[left].getPriority() > this.array[right].getPriority()) {
					if (this.array[cur].getPriority() > this.array[right].getPriority()) {
						swap(this.array, cur, right);
						cur = right;
					} else {
						break;
					}				
				} else {
					if (this.array[cur].getPriority() > this.array[left].getPriority()) {
						swap(this.array, cur, left);
						cur = left;
					} else {
						break;
					}
					
				}			
				left = cur * 2;
				right = cur * 2 + 1;	
			}
		}		
	}
	
	public static void swap(EntryPair[] array, int a, int b) {
		EntryPair temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}