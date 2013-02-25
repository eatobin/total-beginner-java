package totalbeginner;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by IntelliJ IDEA.
 * User: Eric
 * Date: Jun 11, 2010
 * Time: 10:12:23 PM
 */
public class AllTests
{
	public static Test suite()
	{
		TestSuite suite = new TestSuite("Test for org.totalbeginner.tutorial");
		//$JUnit-BEGIN$
		suite.addTestSuite(BookTest.class);
		suite.addTestSuite(PersonTest.class);
		suite.addTestSuite(MyLibraryTest.class);
		//$JUnit-END$
		return suite;
	}
}
