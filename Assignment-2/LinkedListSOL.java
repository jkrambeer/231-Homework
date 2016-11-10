/*
 * Joseph
 * Ayo
 *
 */
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListSOL<E> implements SolInterface<E>
{
	private LinkedList<E> list;

	public LinkedListSOL()
	{
		this.list = new LinkedList<E>();
	}//constructor

	public E solLookUp(E lookForThis)
	{
		E               data;
		ListIterator<E> iterator;
		int             index;

		index     = 0;
		iterator  = list.listIterator();
		data      = null;

		while( iterator.hasNext() )
		{
			index = iterator.nextIndex();//gettting the index to use for setting the elements
			data  = iterator.next();//will move iterator to the next element

			iterator.previous();//going back to get in the position the data was found at
			if( data.equals(lookForThis) )
			{
				if( iterator.hasPrevious() )//if it doesnt have a previous its at the head and dont need to swap
				{
					list.set( index  , iterator.previous() );//setting the current elements data to the previous's data
					list.set( index-1, data );               //setting the previous's data to the current element's data
				}
				return data;//returns as data was found
			}//if
			iterator.next();//if the data isn't the stuff you're looking for, go back to the next element
		}//while

		return data;
	}//solLookUp

	public void solAdd(E data)
	{
		list.addFirst(data);
	}//solAdd

	public String toString()
	{
		String          result;
		ListIterator<E> iterator;

		result   = "";
		iterator = list.listIterator();

		while( iterator.hasNext() )
		{
			result = result + "* " + iterator.next().toString() + "\n";
		}//adding data to the string to return

		if(result.length()==0)
		{
			result = "***This linked list is empty***\n";//if there is nothing in the list it will return this to tell you
		}//if there was not data added

		return result;
	}//toString



}//class