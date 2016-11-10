/*
 * Joseph
 * Ayo
 *
 */
public class CustomSOLTester
{
	public static void main(String[] args)
	{
		//tests to think about
		//varying duplicate sizes
		//methods when the list is empty
		//solLookUp on data at the head
		CustomSOL<String>  test         = new CustomSOL<String>();//type generic
		CustomSOL<Object>  testNotUsed1 = new CustomSOL<Object>();//type generic
		CustomSOL<Integer> testNotUsed2 = new CustomSOL<Integer>();//type generic
		CustomSOL<Float>   testNotUsed3 = new CustomSOL<Float>();//type generic
		CustomSOL<Boolean> testNotUsed4 = new CustomSOL<Boolean>();//type generic

		//test
		System.out.println(test.toString() );//for empty

		//test when empty
		test.collapse();//shouldn't do anything
		test.duplicate();
		test.solLookUp("This shouldn't be found");//should just return null


		//with two element
		test.solAdd("1");
		test.solAdd("0");

		test.solLookUp("1");

		System.out.println(test.toString() );



		//test
		for(int i=0;i<7;i++)
		{
			test.solAdd("Jim "+i);
		}
		test.duplicate();
		test.duplicate();
		System.out.println(test.toString() );

		//test
		System.out.println("\nTesting Collapse\n");

		test.solAdd("Text1");
		test.solAdd("Text2");
		test.solAdd("Text3");
		test.solAdd("Text4");
		test.solAdd("Text5");
		test.solAdd("Text5");
		test.solAdd("Text6");
		test.solAdd("Text6");
		test.solAdd("Text6");
		test.solAdd("Text6");
		test.solAdd("Text6");
		test.solAdd("Text6");
		test.solAdd("Text6");
		test.solAdd("Text6");

		test.collapse();
		System.out.println(test.toString() );

		//test
		System.out.println("\nTesting solLookUp\n");

		//test at head/with duplicates
		test.solLookUp("Text1");
		test.solLookUp("Text1");
		test.solLookUp("Jim 1");
		test.solLookUp("Jim 1");
		test.solLookUp("Jim 1");
		test.solLookUp("This shouldn't be found");
		test.solLookUp("This shouldn't be found");
		test.solLookUp("This shouldn't be found");
		test.solLookUp("This shouldn't be found");
		test.solLookUp("This shouldn't be found");
		test.solLookUp("Jim 1");
		System.out.println(test.toString() );
	}//main
}//class