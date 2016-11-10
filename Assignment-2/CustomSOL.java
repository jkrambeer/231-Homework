/*
 * Joseph
 * Ayo
 *
 */
public class CustomSOL<E> implements SolInterface<E>
{

	private Node<E> head; //reference to the first node

	public CustomSOL()
	{
		this.head = null;
	}//constructor

	public E solLookUp(E lookForThis)
	{
		E       data;
		Node<E> lastNode;
		Node<E> currentNode;

		data        = null;
		lastNode    = null;
		currentNode = this.head;

		if(this.head == null){return null;}//If the head is null the whole list is null so just give them back null
		if(currentNode.data.equals(lookForThis) ){return currentNode.data;}//if the data is at the head no swaps are needed

		while( currentNode.next != null )//keep going until it hits the end of the list or returns in the if statement
		{
			if( currentNode.next.data.equals(lookForThis)  )//if data is the same
			{
				data = currentNode.next.data;//this is the data that we were looking for

				if(currentNode.equals(this.head ) )
				{
					lastNode = currentNode.next;//this works by deleting the second node
					removeAfter(this.head);     //in the list and then readding that
					solAdd(lastNode.data);      //node as the front thus swapping the two nodes
				}//case when there is no previous node
				else
				{
					swapAfter(lastNode);//swapping the next object and the current object's place in the list
				}//used to when there is a previous node

				return data;  //found the data, after swapping, return from teh function
			}//if currentNode.next.data equals lookForThis
			lastNode    = currentNode;
			currentNode = currentNode.next;
		}//while
		return data;//will return null if the thing wasn't found in the list
	}//solLookUp

	public void solAdd(E data)//this will not let them add null data though
	{
		if(data==null){throw new IllegalArgumentException("A passed argument was null");}//don't want to add elements with null data

		this.head = new Node<E>(data,this.head);//Add it to the front of the list
	}//solAdd

	public String toString()//works
	{
		String  result;
		Node<E> nodeRef;

		result  = "";
		nodeRef = this.head;

		while(nodeRef != null)//this concatenate elements to the string until it reaches the end of the list
		{
			result  = result+"* "+nodeRef.data.toString()+"\n";//getting the data as a string with the data type's own toString method
			nodeRef = nodeRef.next;
		}//getting all the data into a string
		if(result.length()==0)
		{
			result = "***This linked list is empty***\n";//if there is nothing in the list it will return this to tell you
		}
		return result;
	}//toString

	public void duplicate()
	{
		Node<E> currentNode;

		currentNode = this.head;
		while(currentNode != null)
		{
			addAfter(currentNode.data, currentNode);//adding duplicate right after orignal
			currentNode = currentNode.next.next;//skipping over new duplicate and going to next original element
		}//while current not null
	}//duplicate

	public void collapse()
	{
		Node<E> currentNode;

		currentNode = this.head;
		while(currentNode != null)//going through all nodes
		{
			while(currentNode.next != null && currentNode.data.equals(currentNode.next.data) )
			{
				removeAfter(currentNode);//removes elements while next node exists and its data is equal to the node its checking against
			}//while next not null and data is equal
			currentNode = currentNode.next;
		}//while current not null
	}//collapse

//-----Private Methods-----
	private void swapAfter(Node<E> nodeRef)
	{
		if(nodeRef==null){throw new IllegalArgumentException("The passed node reference is null");}

		Node<E> first  = nodeRef.next;
		Node<E> second = nodeRef.next.next;

		first.next   = second.next;//sets 1st's next to 2nd's next
		second.next  = first;      //sets 2nd's next to 1st's next
		nodeRef.next = second;     //sets nodeRef to the 2nd node
	}//swap after

	private void addAfter(E data, Node<E> nodeRef) //not used right now
	{
		if(nodeRef==null){throw new IllegalArgumentException("The passed node reference is null");}
		nodeRef.next = new Node<E>(data,nodeRef.next);
	}//addAfter

	private void removeAfter(Node<E> nodeRef)
	{
		if(nodeRef==null){throw new IllegalArgumentException("The passed node reference is null");}

		if(nodeRef.next != null)//if its next is null, there's nothing to remove so dont remove it
		{
			nodeRef.next=nodeRef.next.next;//skipping over the removed element in the list
		}
	}//removeAfter

//-----Node Class-----
	private static class Node<E>
	{
		private E       data;
		private Node<E> next;

		private Node(E data)
		{
			this.data = data;
			this.next = null;
		}//constructor with data

		private Node(E data,Node<E> nodeRef)
		{
			this.data = data;
			this.next = nodeRef;
		}//constructor with data and node ref
	}//class node

}//class customsol
