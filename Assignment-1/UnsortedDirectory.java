/****
 * CISC 231-01
 * Joseph Krambeer, Connor Theisen
 * Paired Programming Assigment 1
 * 9/19/2015
 ****/
public class UnsortedDirectory implements PhoneDirectoryInterface
{
	private String[][] directory;//state in which all name/number pairs are stored
	                             //directory[i][0] corresponds to the name
	                             //directory[i][1] corresponds to the phone number

	public UnsortedDirectory()
	{
		this.directory = new String[0][2];
	}//constructor

	@Override
	public String studentLookup(String name)
	{
		/* Returns the number of that is paired with the referenced name,
		   and if that name is not contained it returns an error string   */

		int index;
		index = findNameIndex(name);
		if(index > -1){ return directory[index][1]; }//returns the number that corresponds to the input name

		return "***Error: could not retrieve number, " + name + " is not in the directory***";//returns a string saying that the name wasn't in the directory so it couldn't retrieve a number
	}//studentLookup

	@Override
	public void addStudent(String name, String number)
	{
		/* If the inputted name is not already in the directory,
		   then the name and number pair will be added to the
		   end of the directory array */

		String[][] newArray;
		int        nameIndex;

		nameIndex = findNameIndex(name);
		if(nameIndex > -1)
		{
			System.out.println("***" + name + " has already been entered***");//name already entered
		}
		else
		{
			newArray = new String[directory.length + 1][2];
			for(int i=0; i<directory.length; i++)
			{
				newArray[i] = directory[i];
			}
			newArray[directory.length][0] = name;
			newArray[directory.length][1] = number;
			setDirectory(newArray);//setting the state of the object to the new array created
		}
	}//addStudent

	@Override
	public void removeStudent(String name)
	{
		/* Checks if the inputted name is in the directory.
		   If it is not, it prints out an error string, and
		   if it is in the directory, then it creates a new
		   array that does not contain the element associated
		   with that name. */

		int        nameIndex;
		int        index; //used to index the new array when adding elements to it
		String[][] newArray;

		nameIndex = findNameIndex(name);
		if(nameIndex == -1 ){ System.out.println("***" + name + " could not be removed, as they were not in the directory***"); }//telling that the name wasn't in the directory
		else
		{
			newArray = new String[directory.length-1][2];//making the array one smaller than it used to be
			index    = 0;
			for(int i=0;i<directory.length;i++)
			{
				if(directory[i][0].compareTo(name) != 0 )//only adds the element to the new array if it doesn't have the same name as the thing to be removed
				{
					newArray[index] = directory[i];
					index++;//only incrementing the index when something is added so that there are no array indexs out of bounds
				}
			}//creating new array
			setDirectory(newArray);//setting the state of the object to the new array created
		}//else
	}//removeStudent

	@Override
	public String toString()
	{
		/* Returns a formatted string that contains
		   all the name and number pairs in the directory */

		String result;

		result = "";
		for(int i=0;i<directory.length;i++)
		{
			result = result + i + "). " +  directory[i][0] + " " + directory[i][1]+ "\n";//formatting the string so there are breaks between entries and they are on their own seperate line
		}
		return result;
	}//toString

	//-----Private Functions-----

	private int findNameIndex(String name)
	{
		/* This function is used to find if a name
		   is contained in the directory array.
		   If the name is  in the array its position is
		   returned, and if it is not, then -1 is returned. */

		for(int i=0;i<directory.length;i++)
		{
			if( name.compareTo(directory[i][0])==0 ){return i;}//equality in the strings, returns index of where the equality occured
		}
		return -1;//-1 means the name was not found
	}//findNameIndex

	private void setDirectory(String[][] newArray)
	{
		this.directory = newArray;//sets the state of the object
	}//setDirectory

}//class
