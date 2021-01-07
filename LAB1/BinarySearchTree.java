//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class - 
//Lab  -

import java.util.Queue;
import java.util.LinkedList;
import static java.lang.System.*;

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void makeEmpty(){
		root = null;
	}

	public void add(Comparable val)
	{
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
	   if(tree == null)
			tree = new TreeNode(val);
		
		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);		
		
		if(dirTest < 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if(dirTest > 0)
			tree.setRight(add(val, tree.getRight()));
		
		return tree;
	}

	public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if(tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	public void preOrder()
	{
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree)
	{
		if(tree != null){
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void postOrder()
	{
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree)
	{
		if(tree != null){
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}

	public void levelOrder()
	{
		levelOrder(root);
		System.out.println("\n\n");
	}

	private void levelOrder(TreeNode tree)
	{
		if(tree==null)
		  return;
		  
		Queue<TreeNode> level = new LinkedList<TreeNode>();
		level.add(tree);
		while(!level.isEmpty())
		{
			TreeNode node = level.remove();
			out.print(node.getValue() + " ");
			if(node.getLeft()!=null)
			{
				level.add(node.getLeft());
			}
			if(node.getRight()!=null)
			{
				level.add(node.getRight());
			}
		}
	}

	public void revOrder()
	{
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree)
	{
		if(tree != null){
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}

	public int getNumLevels()
	{
	     return getNumLevels(root);
	}
		
	private int getNumLevels(TreeNode tree)
	{
	   if(tree==null)   return 0;
	   else {
	      /*int numLeft = getNumLevels(tree.getLeft());
	      int numRight = getNumLevels(tree.getRight());
	      if(numLeft > numRight)
	         return 1 + numLeft; 
	      return 1 + numRight;
	      */
	      //or
	      return 1 + Math.max(getNumLevels(tree.getLeft()),getNumLevels(tree.getRight()));
	   }
	}


	public int getWidth()
	{
		return getWidth(root);
	}

	private int getWidth(TreeNode tree)
	{
		return 1+getNumLevels(tree.getRight()) + getNumLevels(tree.getLeft());
	}

	public int getNumLeaves()
	{
		return getNumLeaves(root);
	}

	private int getNumLeaves(TreeNode tree)
	{
		if(tree==null)
			return 0;
		else if(isLeaf(tree))
			return 1;
		else
			return getNumLeaves(tree.getRight()) + getNumLeaves(tree.getLeft());
	}
	
	private boolean isLeaf(TreeNode tree)
	{
		if(tree.getRight()==null && tree.getLeft()==null)
		{
			return true;
		}
		return false;
	}

	public int getNumNodes()
	{
		return getNumNodes(root);
	}

	private int getNumNodes(TreeNode tree)
	{
		if(tree!=null)
		{
			return  1 + getNumNodes(tree.getRight()) + getNumNodes(tree.getLeft());
		}
		return 0;
	}

	public int getHeight()
	{
		return getNumLevels(root)-1;
	}

	public boolean isFull()
	{
		return (Math.pow(2,getNumLevels())-1)==getNumNodes();
	}

	public boolean search(Comparable val)
	{
		return search(val, root);
	}

	private boolean search(Comparable val, TreeNode tree)
	{
		if(tree != null)
		{
			int dirTest = val.compareTo(tree.getValue());
			if(dirTest == 0 ) 
				return true;
			else if (dirTest < 0)
				return search(val, tree.getLeft());
			else if (dirTest > 0)
				return search(val, tree.getRight());
		}
		return false;
	}

	public void remove(Comparable val)
	{
		root = remove(val, root);
	}

	private TreeNode remove(Comparable val, TreeNode tree)
	{
		if(tree != null)
		{
			int dirTest = val.compareTo(tree.getValue());

			if (dirTest < 0)
				tree.setLeft(remove(val, tree.getLeft()));
			else if (dirTest > 0)
				tree.setRight(remove(val, tree.getRight()));
			else
			{
				if(tree.getRight()==null)
				{
					tree = tree.getLeft();
				}
				else
				{
					TreeNode successor = getSmallest(tree.getRight());
					tree.setValue(successor.getValue());
					tree.setRight(remove(successor.getValue(), tree.getRight()));
				}
			}
		}
		return tree;
	}
	
	public Comparable getSmallest()
	{
		return getSmallest(root).getValue();
	}
	
	private TreeNode getSmallest(TreeNode tree)
	{
		if(tree!=null)
	   {
	   	if(tree.getLeft()!=null)
	   	   return getSmallest(tree.getLeft());
	   	else
	   	   return tree;
	   }	
	   
	   //iterative version
	   /*
	   if(tree!=null)
	   {
	      while(tree.getLeft()!=null)
	      {
	         tree=tree.getLeft();		 
	      }
	      return tree;
	   } 
	   */
	   return null;
	}

	public Comparable getLargest()
	{
		return getLargest(root).getValue();
	}
	
	private TreeNode getLargest(TreeNode tree)
	{
		if(tree!=null)
	   {
	   	if(tree.getRight()!=null)
	   	   return getLargest(tree.getRight());
	   	else
	   	   return tree;
	   }	
	   
	   //iterative version
	   /*
	   if(tree!=null)
	   {
	      while(tree.getRight()!=null)
	      {
	         tree=tree.getRight();		 
	      }
	      return tree;
	   } 
	   */
	   return null;		
	}


	public String toString()
	{
		return toString(root);
	}

	private String toString(TreeNode tree)
	{
	   if(tree==null)
	      return "";
	   else return "" + toString(tree.getLeft())+ " " + tree.getValue() + " "  + toString(tree.getRight());
	}
}