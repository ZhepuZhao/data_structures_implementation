package MinBinHeap_A3;

public class MinBinHeap_Playground {
	public static void main(String[] args) {
		// Add more tests as methods and call them here!!
		TestBuild();
	}

	public static void TestBuild() {
		// constructs a new minbinheap, constructs an array of EntryPair,
		// passes it into build function. Then print collection and heap.
		MinBinHeap mbh_1 = new MinBinHeap();
		EntryPair[] collection = new EntryPair[8];
		collection[0] = new EntryPair("i", 3);
		collection[1] = new EntryPair("b", 5);
		collection[2] = new EntryPair("c", 1);
		collection[3] = new EntryPair("d", 0);
		collection[4] = new EntryPair("e", 46);
		collection[5] = new EntryPair("f", 5);
		collection[6] = new EntryPair("g", 6);
		collection[7] = new EntryPair("h", 17);
		mbh_1.build(collection);
		printHeapCollection(collection);
		System.out.println("---------------------------------Magic build the heap----------------------------------");
		printHeap(mbh_1.getHeap(), mbh_1.size());
		System.out.println("Size: " + mbh_1.size());
		System.out.println("The min elemnt is: Priority: " + mbh_1.getMin().getPriority() + ", Value: " + mbh_1.getMin().getValue());
		
		
//		System.out.println("----------------------------delMin by Magic build the heap-----------------------------");
//		mbh_1.delMin();
//		System.out.println("Size: " + mbh_1.size());
//		System.out.println("The min elemnt is: Priority: " + mbh_1.getMin().getPriority() + ", Value: " + mbh_1.getMin().getValue());
//		printHeap(mbh_1.getHeap(), mbh_1.size());
		
		// build the heap by inserting one by one
		System.out.println("---------------------------------Build by inserting one by one------------------------");
		MinBinHeap mbh_2 = new MinBinHeap();
		for (int i = 0; i < collection.length; i++) {
			mbh_2.insert(collection[i]);
		}
		printHeap(mbh_2.getHeap(), mbh_2.size());
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is: Priority: " + mbh_2.getMin().getPriority() + ", Value: " + mbh_2.getMin().getValue());

		// Test delMin()
		System.out.println("----------------------------delMin by inserting one by one----------------------------");
		mbh_2.delMin();
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is: Priority: " + mbh_2.getMin().getPriority() + ", Value: " + mbh_2.getMin().getValue());
		printHeap(mbh_2.getHeap(), mbh_2.size());
		
		mbh_2.delMin();
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is: Priority: " + mbh_2.getMin().getPriority() + ", Value: " + mbh_2.getMin().getValue());
		printHeap(mbh_2.getHeap(), mbh_2.size());

		mbh_2.delMin();
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is: Priority: " + mbh_2.getMin().getPriority() + ", Value: " + mbh_2.getMin().getValue());
		printHeap(mbh_2.getHeap(), mbh_2.size());
		
		mbh_2.delMin();
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is: Priority: " + mbh_2.getMin().getPriority() + ", Value: " + mbh_2.getMin().getValue());
		printHeap(mbh_2.getHeap(), mbh_2.size());
		
		mbh_2.delMin();
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is: Priority: " + mbh_2.getMin().getPriority() + ", Value: " + mbh_2.getMin().getValue());
		printHeap(mbh_2.getHeap(), mbh_2.size());
		
		mbh_2.delMin();
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is: Priority: " + mbh_2.getMin().getPriority() + ", Value: " + mbh_2.getMin().getValue());
		printHeap(mbh_2.getHeap(), mbh_2.size());
		
		mbh_2.delMin();
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is: Priority: " + mbh_2.getMin().getPriority() + ", Value: " + mbh_2.getMin().getValue());
		printHeap(mbh_2.getHeap(), mbh_2.size());
		
		mbh_2.delMin();
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is(it should be null): " + mbh_2.getMin());
		printHeap(mbh_2.getHeap(), mbh_2.size());
		
		System.out.println("----------------------------delMin in an empty heap----------------------------");
		mbh_2.delMin();
		System.out.println("Size: " + mbh_2.size());
		System.out.println("The min elemnt is(it should be null): " + mbh_2.getMin());
		printHeap(mbh_2.getHeap(), mbh_2.size());
		
		
	}

	public static void printHeapCollection(EntryPair[] e) {
		// this will print the entirety of an array of entry pairs you will pass
		// to your build function.
		System.out.println("Printing Collection to pass in to build function:");
		for (int i = 0; i < e.length; i++) {
			System.out.print("(" + e[i].value + "," + e[i].priority + ")\t");
		}
		System.out.print("\n");
	}

	public static void printHeap(EntryPair[] e, int len) {
		// pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th
		// index....
		System.out.println("Printing Heap");
		for (int i = 1; i < len + 1; i++) {
			System.out.print("(" + e[i].value + "," + e[i].priority + ")\t");
		}
		System.out.print("\n");
	}
}