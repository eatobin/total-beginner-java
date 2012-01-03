package totalBeginner.tutorial;

import junit.framework.TestCase;

public class BookTest extends TestCase
{
  public void testBook()
  {
    Book b1 = new Book("Great Expectations");
    assertEquals("Great Expectations", b1.title);
    assertEquals("unknown author", b1.author);
  }

  public void testGetPerson()
  {
    Book b2 = new Book("War and Peace");
    Person p2 = new Person();
    p2.setName("Elvis");
    b2.setPerson(p2);
    String testName = b2.getPerson().getName();

    assertEquals("Elvis", testName);
  }

  public void testGetAuthor()
  {
    Book b1 = new Book("Test Title");
    b1.setAuthor("Eric Tobin");

    assertEquals("Eric Tobin", b1.getAuthor());
  }

  public void testGetTitle()
  {
    Book b1 = new Book("Test Title");

    assertEquals("Test Title", b1.getTitle());
  }
}
