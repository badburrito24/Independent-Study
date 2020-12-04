//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;

public class ListFunHouseTwo
{
	private ListNode theList;
	
	public ListFunHouseTwo()
	{
		theList=null;
	}
	
	public void add(Comparable data)
	{
		theList = new ListNode(data,theList);
	}
	
	//this method will return the number of nodes present in list
	public int nodeCount()
	{
   	int count=0;
   	ListNode list=theList;
   	while(list!=null)
   	{
   		count++;
   		list=list.getNext();
   	}		
   	return count;
	}
		
	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
   	ListNode list=theList;
   	while(list!=null&&list.getNext()!=null)
   	{
   		list=list.getNext();
   	}
   	ListNode add = new ListNode(list.getValue(),null);
   	list.setNext(add);			
	}

	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
   	theList = new ListNode(theList.getValue(),theList);   				
	}
		
	//method skipEveryOther will remove every other node
	public void skipEveryOther()
	{
   	ListNode list=theList;
	   while(list!=null&&list.getNext()!=null)
   	{
   		list.setNext(list.getNext().getNext());
   		list=list.getNext();
   	}	
	}

	//this method will set the value of every xth node in the list
	public void setXthNode(int x, Comparable value)
	{
   	ListNode list=theList;
		int count=1;
	   while(list!=null)
   	{
   		if(x==count)
   		{
   			list.setValue(value);
   			count=1;
   		}
   		else
   		{
   			count++;
   		}  
   		list=list.getNext();
   	}		
	}	

	//this method will remove every xth node in the list
	public void removeXthNode(int x)
	{
   	ListNode list=theList;
		int count=1;
		ListNode prev=list;
	   while(list!=null)
   	{
   		if(x==count)
   		{
   			prev.setNext(list.getNext());
   			count=1;
   		}
   		else
   		{
   			count++;
   		}  
   		prev=list;
   		list=list.getNext();
   	}		
	}		
	//this method will return a String containing the entire list
   public String toString()
   {
   	String output="";
   	ListNode list=theList;
   	while(list!=null)
   	{
   		output+=list.getValue()+" ";
   		list=list.getNext();
   	}
   	return output;
   }			
	
}