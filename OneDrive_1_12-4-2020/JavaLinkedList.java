//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.LinkedList;
import static java.lang.System.*;

public class JavaLinkedList
{
	private LinkedList<Integer> list;

	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
	}

	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	public double getSum(  )
	{
		double total=0;
		for(int n=0; n<list.size(); n++)
			total+=list.get(n);
		return total;
	}

	public double getAvg(  )
	{
		return getSum()/list.size();
	}

	public int getLargest()
	{
		int largest=Integer.MIN_VALUE;
		for(int n=0; n<list.size(); n++)
		{
			if(list.get(n)>largest)
				largest=list.get(n);
		}
		return largest;
	}

	public int getSmallest()
	{
		int smallest = smallest=Integer.MAX_VALUE;
		for(int n=0; n<list.size(); n++)
		{
			if(list.get(n)<smallest)
				smallest=list.get(n);
		}
		return smallest;
	}

	public String toString()
	{
		String output="";
		output+="SUM:: "+getSum()+"\n";
		output+="AVERAGE:: "+getAvg()+"\n";
		output+="SMALLEST:: " +getSmallest()+"\n";
		output+="LARGEST:: "+getLargest()+"\n";
		return output;
	}
}