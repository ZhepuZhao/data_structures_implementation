package LinkedList_A1;

public class LinkedListPlayground {

	public static void main(String[] args) {
		/*
		 * here you can instantiate your LinkedList and play around with it to check
		 * correctness. We've graciously also provided you a bit of extra test data for
		 * debugging. It doesn't matter what you have in here. We will not grade it.
		 * This is for your use in testing your implementation.
		 */
//		System.out.println("------------------test1-----------------");
//		test1();
//		System.out.println("------------------test2-----------------");
//		test2();
//		System.out.println("------------------test3-----------------");
//		test3();
//		System.out.println("------------------test4-----------------");
//		test4();
		System.out.println("------------------test5-----------------");
		test5();
		System.out.println("------------------test6-----------------");
		test6();
		

	}

	public static void test1() {
		// example test cases
		LinkedListImpl L = new LinkedListImpl();
		System.out.println(L.isEmpty());
		printList(L);
		L.clear();
		System.out.println(L.isEmpty());
		printList(L);
		System.out.println(L.sentinel.toString());
		L.insert(3.3, 0);
		System.out.println(L.isEmpty());
		printList(L);
		System.out.println(L.sentinel.next.toString());
		L.insert(3.4, 0);
		L.insert(3.5, 0);
		L.insert(3.67, 1);
		L.insert(3.357, 0);
		L.insert(3.333, 4);
		System.out.println(L.size());
		printList(L);
		L.remove(3);
		System.out.println(L.size());
		printList(L);
		L.clear();
		L.insert(3.4, 0);
		L.insert(3.5, 0);
		L.insert(3.67, 1);
		L.insert(3.357, 0);
		L.insert(3.333, 3);
		L.remove(0);
		System.out.println(L.size());
		printList(L);
	}

	public static void test2() {
		// example test cases
		LinkedListImpl L = new LinkedListImpl();
		L.insert(3.4, 0);
		printList(L);
		L.insert(3.5, 1);
		printList(L);
		L.insert(3.67, 2);
		printList(L);
		L.remove(-1);
		L.remove(5);
		L.remove(3);
		L.remove(2);
		// L.remove(0);
		System.out.println(L.size());
		printList(L);
	}

	public static void test3() {
		// example test cases
		LinkedListImpl l = new LinkedListImpl();
		// test index
//		System.out.println(l.insert(1.0, 1));
//		System.out.println(l.insert(1.0, -1));
//		System.out.println(l.remove(-1));
//		System.out.println(l.remove(0));
//		System.out.println(l.remove(1));
//		System.out.println(l.get(1));
//		System.out.println(l.isEmpty());
		
		// test case 1
		l.insert(1.0, -1);
		printList(l);
		l.insert(1.0, 0);
		printList(l);
		l.insert(2.0, 0);
		printList(l);
		l.insert(6.0, -1);
		printList(l);
		l.insert(3.0, 1);
		printList(l);
		l.insert(4.0, 3);
		printList(l);
		l.insert(5.0, 5);
		printList(l);
//		System.out.println(l.get(0));
//		System.out.println(l.get(-1));
//		System.out.println(l.get(1));
//		System.out.println(l.get(3));
//		System.out.println(l.get(4));
		printList(l);
		System.out.println(l.size());
	}
	
	public static void test4() {
		LinkedListImpl l = new LinkedListImpl();
		System.out.println(l.size());
		l.insert(45.0,0);
		System.out.println(l.size());
		l.insert(3, 0);
		l.insert(2.0, 1);
		l.insert(1.0, 2);
		l.remove(0);
		System.out.println(l.size());
	}
	
	public static void test5() {
		LinkedListImpl l1 = new LinkedListImpl();
		l1.insert(3, 0);
		l1.insert(5, 1);
		l1.insert(6, 2);
		l1.insert(4, 1);
		printList(l1);
		
		
		
	}
	
	public static void test6() {
		LinkedListImpl l = new LinkedListImpl();
		l.insert(3,0);
		l.insert(2.0,1);
		l.insert(1.0,2);
		l.remove(0);
		l.clear();
		l.insert(3,0);
		l.insert(2,1);
		l.insert(1,0);
		l.remove(2);
		printList(l);
        
	}
	
	public static void printList(LinkedListImpl L) {
		// note that this is a good example of how to iterate through your linked list
		// since we know how many elements are in the list we can use a for loop
		// and not worry about checking the next field to see if we hit the end sentinel
		Node curr = L.sentinel.next; // the first data node in the list is the one after sentinel.
		System.out.print("sentinel");
		for (int i = 0; i < L.size(); i++) {
			System.out.print(" --> " + curr.data);
			curr = curr.next;
		}
		System.out.println();
	}
}
