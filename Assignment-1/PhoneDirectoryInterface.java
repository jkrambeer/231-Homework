/****
 * CISC 231-01
 * Joseph Krambeer, Connor Theisen
 * Paired Programming Assigment 1
 * 9/19/2015
 ****/
public interface PhoneDirectoryInterface
{
	//these are the methods that each directory has to implement
	public abstract String studentLookup(String name);
	public abstract void   addStudent(String name, String number);
	public abstract void   removeStudent(String name);
	public abstract String toString();
}//interface