package LAB1;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class - 
//Lab  -

import static java.lang.System.*;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
      BinarySearchTree tree = new BinarySearchTree();

      tree.add(90);
      tree.add(100);
      tree.add(80);
      tree.add(70);
      tree.add(85);
      tree.add(98);
      tree.add(120);

		out.println("IN ORDER");
	   tree.inOrder();

		out.println("PRE ORDER");
      tree.preOrder();

		out.println("POST ORDER");
      tree.postOrder();

		out.println("REVERSE ORDER");
      tree.revOrder();


      out.println("\nTree height is " + tree.getHeight());
      out.println("\nTree width is " + tree.getWidth());
      out.println("\nNumber of leaves is " + tree.getNumLeaves());
		out.println("\nNumber of nodes is " + tree.getNumNodes());
		out.println("\nNumber of levels is " + tree.getNumLevels());

		out.println("\nTree as a string  " + tree.toString());

		out.println(tree.isFull()?"\nThe tree is full.":"\nThe tree is not full.");
		


}
}