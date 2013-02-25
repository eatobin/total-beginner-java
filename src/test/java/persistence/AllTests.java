package persistence;

import org.junit.runner.*;
import org.junit.runners.*;

/**
 * Created by IntelliJ IDEA. And Eric.
 * User: Eric
 * Date: Jun 11, 2010
 * Time: 10:12:23 PM
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
		PersonTest.class,
		BookTest.class,
		MyLibraryTest.class,
		MyUtilitiesTest.class
})

public class AllTests
{

}
