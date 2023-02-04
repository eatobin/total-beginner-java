package totalbeginner;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: Jun 10, 2010
 * Time: 10:39:50 AM
 */
public class BookTest extends TestCase {
    public void testBook() {
        Book b1 = new Book("Great Expectations");
        assertEquals("Great Expectations", b1.title);
        assertEquals("unknown author", b1.author);
    }

    public void testGetPerson() {
        Book b2 = new Book("War And Peace");
        Person p2 = new Person();
        p2.setName("Elvis");

        // Method to say Book is loaned to this Person

        b2.setPerson(p2);

        // Get the name of the Person who has the Book

        String testName = b2.getPerson().getName();

        assertEquals("Elvis", testName);
    }

    public void testToString() {
        Book b2 = new Book("War And Peace");
        Person p2 = new Person();
        p2.setName("Elvis");

        assertEquals("War And Peace by unknown author; Available", b2.toString());

        b2.setPerson(p2);
        assertEquals("War And Peace by unknown author; Checked out to Elvis", b2.toString());
    }
}
