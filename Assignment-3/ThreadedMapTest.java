public class ThreadedMapTest
{
	public static void main(String[] args)
	{
		ThreadedMap test;

		test = new ThreadedMap();

		String result = test.prettyStr();
		System.out.println(result);

		test.put(3,"Three");

		//result = test.prettyStr();
		//System.out.println(result);

		test.put(2,"Two");
		test.put(6,"Six");
		test.put(1,"One");

		test.put(7,"Seven");

		test.put(4,"Four");
		test.put(5,"Five");
		test.put(8,"Eight");
		test.put(9,"Nine");


		result = test.prettyStr();
		System.out.println(result);
		//System.out.println("one gets "+test.get(1) );
		//System.out.println("one gets "+test.get(1) );
		//System.out.println("100 gets "+test.get(100) );

		result = test.inOrderTrav();
	}

}