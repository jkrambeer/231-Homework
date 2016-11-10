/*
 * Joseph
 * Ayo
 *
 */
public class LinkedSolTester
{
	public static void main(String[] args)
	{
		LinkedListSOL<String> test = new LinkedListSOL<String>();

		test.solAdd("Test1");
		test.solAdd("Test2");
		test.solAdd("Test3");
		test.solAdd("Test4");
		test.solAdd("Test5");
		test.solAdd("Test6");

		System.out.println(test.toString() );

		test.solLookUp("Test1");
		test.solLookUp("Test1");

		System.out.println( test.solLookUp("Test6") );
		System.out.println( test.solLookUp("Test1") );

		test.solLookUp("Test1");
		test.solLookUp("Test1");
		test.solLookUp("Test6");

		System.out.println(test.toString() );


	}//main
}