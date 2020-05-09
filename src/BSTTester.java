public class BSTTester {

	public static void main(String[] args)
	{
		String[] words = {"One", "Two", "Three", "Four", "Five",
				"Six", "Seven", "Eight", "Nine", "Ten"};
		MyBST bst = new MyBST();

		for (String word : words)
		{
			System.out.println("Added: " + word + " " + bst.add(word));
			System.out.println("Contains: " + word + " " + bst.contains(word));
			if(bst.add(word))
				System.out.println("*** Added a duplicate value ***");
			System.out.println(bst);
		}



		for (String word : words)
		{
			System.out.println("Removed: " + word + " " + bst.remove(word));
			if(bst.remove(word))
				System.out.println("*** Removed a non-existent value ***");
			System.out.println(bst);
		}
		MyBST ts1 = new MyBST();
		ts1.add(new Integer(5));
		ts1.add(new Integer(3));
		ts1.add(new Integer(4));
		ts1.add(new Integer(15));
		ts1.add(new Integer(10));
		ts1.add(new Integer(20));
		ts1.add(new Integer(7));
		ts1.add(new Integer(13));
		ts1.add(new Integer(6));
		ts1.add(new Integer(8));
		ts1.add(new Integer(9));
		ts1.add(new Integer(11));
		ts1.add(new Integer(12));
		ts1.add(new Integer(14));
		ts1.add(new Integer(17));
		ts1.add(new Integer(16));
		ts1.add(new Integer(18));
		ts1.add(new Integer(19));
		ts1.add(new Integer(23));
		ts1.add(new Integer(21));
		ts1.add(new Integer(22));
		ts1.add(new Integer(25));

		ts1.add(new Integer(1));
		ts1.add(new Integer(0));
		ts1.add(new Integer(2));
		ts1.add(new Integer(5)); //notice that 5 is added twice
		ts1.add(new Integer(17)); //notice that 17 is added twice
		ts1.add(new Integer(4)); //notice that 4 is added twice

		MyBST ts2 = new MyBST();
		ts2.add(new Integer(5));
		ts2.add(new Integer(3));
		ts2.add(new Integer(4));
		ts2.add(new Integer(8));
		ts2.add(new Integer(7));
		ts2.add(new Integer(1));
		ts2.add(new Integer(0));
		ts2.add(new Integer(9));
		ts2.add(new Integer(2));
		ts2.add(new Integer(6));
		ts2.add(new Integer(5)); //notice that 5 is added twice

		ts2.remove(new Integer(2));
		ts2.remove(new Integer(5));
		ts2.add(new Integer(2));
		ts2.add(new Integer(5));


//		runStats(ts2);
//		System.out.println();
//		runStats(ts1); 
//		}

//		public static void runStats(MyBST t)
//		{
//		System.out.println("The leafs of this tree are: " + t.listLeafs());
//		System.out.println("This tree has " + t.countNodes() + " nodes and the sum of their contents is " + t.sumTree() + ".");
//		System.out.println("This tree has " + t.depth() + " levels, where the root node counts as one level.");
//		System.out.println("The bush-ratio of this tree is: " + t.bushRatio());
//		System.out.println("The pairs of nodes that have same-shape subtrees are:\n" + t.findSameShapeNodes()); 
//		}
	}
}
	

