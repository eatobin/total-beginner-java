package totalbeginner;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: Jun 12, 2010
 * Time: 11:39:45 AM
 */
public class MyLibraryTest extends TestCase
{
	private Book b1;
	private Book b2;
	private Person p1;
	private Person p2;
	private MyLibrary ml;

	// Test constructor

	public void testMyLibrary()
	{
		MyLibrary ml = new MyLibrary("Test");

		assertEquals("Test", ml.name);

		assertTrue(ml.books != null);
		assertTrue(ml.people != null);
	}

	public void setup()
	{
		// Create objects

		b1 = new Book("Book1");
		b2 = new Book("Book2");

		p1 = new Person();
		p2 = new Person();
		p1.setName("Fred");
		p2.setName("Sue");

		ml = new MyLibrary("Test");
	}

	public void testAddBook()
	{
		// Create test objects

		setup();

		// Test initial size is 0

		assertEquals(0, ml.getBooks().size());

		ml.addBook(b1);
		ml.addBook(b2);

		assertEquals(2, ml.getBooks().size());
		assertEquals(0, ml.getBooks().indexOf(b1));
		assertEquals(1, ml.getBooks().indexOf(b2));

		ml.removeBook(b1);
		assertEquals(1, ml.getBooks().size());
		assertEquals(0, ml.getBooks().indexOf(b2));

		ml.removeBook(b2);
		assertEquals(0, ml.getBooks().size());
	}

	public void testCheckOut()
	{
		// Setup objects

		setup();
		addItems();

		assertTrue("Book did not check out correctly",
				ml.checkOut(b1, p1));

		assertEquals("Fred", b1.getPerson().getName());

		// Uncomment to fail book check out

		//ml.checkIn(b1);

		assertFalse("Book should be checked out",
				ml.checkOut(b1, p2));

		assertTrue("Book check in failed", ml.checkIn(b1));

		assertFalse("Book was already checked in", ml.checkIn(b1));

		assertFalse("Book was never checked out", ml.checkIn(b2));

		// Additional test for maximumBooks

		setup();

		p1.setMaximumBooks(1);
		addItems();

		assertTrue("First book did not check out",
				ml.checkOut(b2, p1));

		assertFalse("Second book should not have checked out",
				ml.checkOut(b1, p1));
	}

	private void addItems()
	{
		ml.addBook(b1);
		ml.addBook(b2);
		ml.addPerson(p1);
		ml.addPerson(p2);
	}

	public void testGetBooksForPerson()
	{
		setup();
		addItems();
		assertEquals(0, ml.getBooksForPerson(p1).size());

		ml.checkOut(b1, p1);

		ArrayList<Book> testBooks = ml.getBooksForPerson(p1);
		assertEquals(1, testBooks.size());
		assertEquals(0, testBooks.indexOf(b1));

		ml.checkOut(b2, p1);
		testBooks = ml.getBooksForPerson(p1);
		assertEquals(2, testBooks.size());
		assertEquals(1, testBooks.indexOf(b2));
	}

	public void testGetAvailableBooks()
	{
		setup();
		addItems();
		ArrayList<Book> testBooks = ml.getAvailableBooks();
		assertEquals(2, testBooks.size());
		assertEquals(1, testBooks.indexOf(b2));

		ml.checkOut(b1, p1);
		testBooks = ml.getAvailableBooks();
		assertEquals(1, testBooks.size());
		assertEquals(0, testBooks.indexOf(b2));

		ml.checkOut(b2, p1);
		testBooks = ml.getAvailableBooks();
		assertEquals(0, testBooks.size());
	}

	public void testUnavailableBooks()
	{
		setup();
		addItems();
		assertEquals(0, ml.getUnavailableBooks().size());

		ml.checkOut(b1, p1);

		ArrayList<Book> testBooks = ml.getUnavailableBooks();
		assertEquals(1, testBooks.size());
		assertEquals(0, testBooks.indexOf(b1));

		ml.checkOut(b2, p2);
		testBooks = ml.getUnavailableBooks();
		assertEquals(2, testBooks.size());
		assertEquals(1, testBooks.indexOf(b2));
	}

	public void testToString()
	{
		setup();
		addItems();

		assertEquals("Test: 2 books; 2 people.", ml.toString());
	}
}
