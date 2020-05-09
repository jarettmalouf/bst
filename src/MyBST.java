// Implements a BST with TreeNode nodes

import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
// Normally, TreeNode and MyTreeSet would be "generic" (type-specific)
// classes and hold Comparable objects, but this is beyond the scope of
// the Java Methods book. Without @SuppressWarnings, this class would give
// three "Unchecked cast" warnings.

public class MyBST
{
	private TreeNode root;  // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST()
	{
		root = null;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(Object value)
	{
		return contains(root, value);
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(Object value)
	{
		if (contains(value))
			return false;
		root = add(root, value);
		return true;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(Object value)
	{
		if (!contains(value))
			return false;
		root = remove(root, value);
		return true;
	}

	// Returns a string representation of this BST.
	public String toString()
	{
		String str = toString(root);
		if (str.endsWith(", "))
			str = str.substring(0, str.length() - 2);
		return "[" + str + "]";
	}

	//*************** Private helper methods: *********************

	// Returns true if the BST rooted at node contains value;
	// otherwise returns false (recursive version).

	private boolean contains(TreeNode node, Object value)
	{
		if (node == null)
			return false;
		else
		{
			int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
			if (diff == 0)
				return true;
			else if (diff < 0)
				return contains(node.getLeft(), value);
			else // if (diff > 0)
				return contains(node.getRight(), value);
		}
	}

	/*
  // Iterative version:
  private boolean contains(TreeNode node, Object value)
  {
    while (node != null)
    {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff == 0)
        return true;
      else if (diff < 0)
        node = node.getLeft();
      else // if (diff > 0)
        node = node.getRight();
    }
    return false;
  }
	 */

	// Adds value to the BST rooted at node. Returns the
	// root of the new tree.
	// Precondition: the tree rooted at node does not contain value.
	private TreeNode add(TreeNode node, Object value)
	{
		if (node == null)
		{
			root = new TreeNode(value);
			return root;
		}
		int diff = ((Comparable<Object>)value).compareTo(node.getValue());
		if (diff < 0 && node.getLeft() == null)
		{
			node.setLeft(new TreeNode(value));
		}
		else if (diff > 0 && node.getRight() == null)
		{
			node.setRight(new TreeNode(value));
		}
		else if (diff < 0)
		{
			add(node.getLeft(), value);
		}
		else // (diff > 0)
		{
			add(node.getRight(), value);
		}
		return node;
	}

	// Removes value from the BST rooted at node.
	// Returns the root of the new tree.
	// Precondition: the tree rooted at node contains value.
	private TreeNode remove(TreeNode node, Object value)
	{

		int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
		if(diff == 0)
		{
			return removeRoot(node);
		}
		else if (diff < 1)
		{
			node.setLeft(remove(node.getLeft(),value));
			return node;
		}
		else
		{
			node.setRight(remove(node.getRight(),value));
			return node;
		}



	}

	// Removes the root of the BST rooted at root
	// replacing it with the smallest node from the right subtree.
	// Returns the root of the new tree.
	private TreeNode removeRoot(TreeNode root)
	{
		if(root.getLeft() == null)
			root = root.getRight();
		else if(root.getRight() == null)
			root = root.getLeft();
		else if (root.getRight().getLeft() == null)
		{
			root.getRight().setLeft(root.getLeft());
			return root.getRight();
		}
		else
		{
			TreeNode prev = root;
			TreeNode tracker = root.getRight();
			while(tracker.getLeft() != null)
			{
				prev = tracker;
				tracker = tracker.getLeft();
			}
			root.setValue(tracker.getValue());
			prev.setLeft(tracker.getRight());

		}
		return root;
	}

	// Returns a string representation of the tree rooted at node.
	private String toString(TreeNode node)
	{
		if (node == null)
			return "";
		else
			return toString(node.getLeft()) + node.getValue() + ", " +
			toString(node.getRight());
	}

	// Returns true if node is a leaf, false otherwise.
	private boolean isLeaf(TreeNode node)
	{
		if (node.getLeft() == null && node.getRight() == null)
			return true;
		return false;
	}

//	// Returns a String listing the contents of all leaf-nodes, separated by commas.
//	public String listLeafs()
//	{
//		/* YOUR CODE HERE */
//	}

	// Returns the sum of all the Integer values stored in the tree.
	// Precondition: all the nodes only store Integers.
	public int sumTree()
	{
		return sumTree(root);
	}
	
	public int sumTree(TreeNode node)
	{
		int total = (int) node.getValue();
		if (node.getLeft() == null)
		{
			return total += sumTree(node.getRight());
		}
		if (node.getRight() == null)
		{
			return total + sumTree(node.getLeft());
		}
		if (node.getLeft() == null && node.getRight() == null)
		{
			return total;
		}
		else
		{
			return total + sumTree(node.getLeft()) + sumTree(node.getRight());
		}
	}

	// Returns the length of the longest path in the tree.
	public int depth()
	{
		return depth(root);
	}
	
	public int depth(TreeNode node)
	{
		if(node == null)
		{
			return 0;
		}
		int depthLeft = depth(node.getLeft());
		int depthRight = depth(node.getRight());
		return (depthLeft>depthRight) ? 1+depthLeft : 1+depthRight;
	}

	//Returns an int representing the total number of nodes in the tree.
	public int countNodes()
	{
		return countNodes(root);
	}
	
	public int countNodes(TreeNode node)
	{
		if (node.getLeft() == null)
		{
			return 1 + countNodes(node.getRight());
		}
		if (node.getRight() == null)
		{
			return 1 + countNodes(node.getLeft());
		}
		if (node.getLeft() == null && node.getRight() == null)
		{
			return 1;
		}
		else
		{
			return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
		}
	}
}

//	// Returns the ratio of the number of nodes in the tree to the maximum
//	// possible number of nodes in a binary tree with the same number of levels.
//	// Hint: ^^
//	public double bushRatio()
//	{
//		/* YOUR CODE HERE */
//	}
//
//	// Returns true if and only if the subtrees rooted at root1 and root2
//	// are not leaves and they have the same shape.
//	public boolean sameShape(TreeNode root1, TreeNode root2)
//	{
//		/* YOUR CODE HERE */
//	}
//
//	// Returns a String listing all pairs of nodes whose subtrees are the same shape.
//	// For example: "the 2-node and the 4-node, the 7-node and the 3-nodes, ..."
//	public String findSameShapeNodes()
//	{
//		/* YOUR CODE HERE */
//	}
//
//}
