//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;

public class HistoList
{
   private HistoNode front;

	public HistoList( )
	{
		front = null;
	}


	//ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	//IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void addLetter(char let)
	{
		if(indexOf(let)==-1)
		   front = new HistoNode(let,1,front);
		else{
			HistoNode current = nodeAt(indexOf(let));
			current.setLetterCount(current.getLetterCount()+1);
		}
	}

	//RETURNS THE INDEX POSITION OF LET IN THE LIST
	public int indexOf(char let)
	{
		int spot=-1;
		HistoNode current = front;
		while(current!=null)
		{
			spot++;
			char temp=current.getLetter();
			if(temp==let)
			   return spot;
			current = current.getNext();
		}
		return -1;
	}

	//RETURNS A REFERENCE TO THE NODE AT SPOT
	private HistoNode nodeAt(int spot)
	{
		HistoNode current=front;
		for(int i=0; i<spot; i++)
		{
			current=current.getNext();
		}
		return current;
	}

	//RETURNS THE LIST AS A BIG STRING
	public String toString()
	{
		String output = "";
		HistoNode current = front;

		while(current != null)
		{
			output = output + current.getLetter() + " - " + current.getLetterCount() + "     ";
			current = current.getNext();
		}
		return output;
	}
}