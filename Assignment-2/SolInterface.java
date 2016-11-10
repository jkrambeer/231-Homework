/*
 * Joseph
 * Ayo
 *
 */
public interface SolInterface<E>
{
	//this defines the methods that the classes that implement this will have
	//this is type generic as E can be any type of object
	E      solLookUp(E lookForThis);
	void   solAdd(E data);
	String toString();
}//SolInterface
