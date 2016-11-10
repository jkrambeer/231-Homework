/****
 * CISC 231-01
 * Joseph Krambeer, Connor Theisen
 * Paired Programming Assigment 1
 * 9/19/2015
 ****/
public class SortedDirectoryTester
{
	public static void main(String[] args)
	{
		SortedDirectory test;
		test = new SortedDirectory();

		//testing removing someone from an empty directory
		System.out.println("\n---Testing Removing Student From Empty Directory---\n");
		test.removeStudent("name");

		//testing adding students
		System.out.println("\n---Testing Adding Students---\n");
		test.addStudent("Ricky Bobby", "844-811-877");
		test.addStudent("Adam Smith", "532-000-123");
		test.addStudent("John Cena","521-999-043");
		test.addStudent("Derek Jackson", "777-777-444");
		test.addStudent("Batman","217-744-999");
		test.addStudent("Adam Johnson", "532-111-123");
		test.addStudent("Yohn Smith","111-111-111");//duplicate numbers are fine
		test.addStudent("Lohn Smith","111-111-111");
		test.addStudent("lohn Smith","222-222-222");//unique names take into accout capitalization, should be at end as lowercase is after uppercase
		test.addStudent("Derek Jeter", "987-654-321");
		test.addStudent("Joseph Krambeer","123-456-789");
		test.addStudent("Darth Vader", "111-222-333");

		//Testing to make sure a duplicate name is not added
		test.addStudent("John Cena","444-999-043");
		test.addStudent("Joseph Krambeer","444-999-043");//this will not change the number of the specified name

		System.out.println(test);//this will call the toString method

		//testing removing students
		System.out.println("\n---Testing Removing Students---\n");
		test.removeStudent("Batman");
		test.removeStudent("Darth Vader");
		test.removeStudent("Anec Nhoj");//should give back an error alert
		test.removeStudent("John Smith");//should give back an error alert

		System.out.println(test);//this will call the toString method

		//adding an entry after it has been removed
		test.addStudent("Batman","145-785-913");//adding old entry again with new number to check if studentLookup will give newest number

		//testing the studentLookup method
		System.out.println("\n---Testing StudentLookup---\n");
		System.out.println("*John Cena's number is : " + test.studentLookup("John Cena") );
		System.out.println("*Bob Dole's number is : " + test.studentLookup("Bob Dole") );//will return error string
		System.out.println("*Lohn Smith's number is : " + test.studentLookup("Lohn Smith") );
		System.out.println("*lohn Smith's number is : " + test.studentLookup("lohn Smith") );//checking names takes into account capitalization
		System.out.println("*Darth Vader's number is : " + test.studentLookup("Darth Vader") );//will return error string
		System.out.println("*Batman's number is : " + test.studentLookup("Batman") );//will return the newest number assigned to batman


	}//main
}//class
