package totalBeginner.tutorial;

import junit.framework.TestCase;

import java.util.ArrayList;

public class MyLibraryTest extends TestCase
{

  private Book b1;
  private Book b2;
  private Person p1;
  private Person p2;
  private MyLibrary ml;

  public void testMyLibrary()
  {
    MyLibrary ml = new MyLibrary("Test Library");

    assertEquals("Test Library", ml.getName());

    assertTrue(ml.books instanceof ArrayList);
    assertTrue(ml.people instanceof ArrayList);
  }

  public void setup()
  {
    b1 = new Book("Book1");
    b2 = new Book("Book2");

    p1 = new Person();
    p2 = new Person();

    p1.setName("Fred");
    p2.setName("Sue");

    ml = new MyLibrary("Test Library");
  }

  public void testAddBook()
  {
    setup();

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

  public void testAddPerson()
  {
    setup();

    assertEquals(0, ml.getPeople().size());

    ml.addPerson(p1);
    ml.addPerson(p2);

    assertEquals(2, ml.getPeople().size());
    assertEquals(0, ml.getPeople().indexOf(p1));
    assertEquals(1, ml.getPeople().indexOf(p2));

    ml.removePerson(p1);
    assertEquals(1, ml.getPeople().size());
    assertEquals(0, ml.getPeople().indexOf(p2));

    ml.removePerson(p2);
    assertEquals(0, ml.getPeople().size());
  }

  public void testCheckOut()
  {
    setup();

    ml.addBook(b1);
    ml.addBook(b2);
    ml.addPerson(p1);
    ml.addPerson(p2);

    assertTrue("Book did not check out correctly!", ml.checkout(b1, p1));
    assertEquals("Fred", b1.getPerson().getName());
    assertFalse("Book was already checked out!", ml.checkout(b1, p2));

    assertTrue("Book check in failed!", ml.checkIn(b1));
    assertFalse("Book was already checked in", ml.checkIn(b1));
    assertFalse("Book was never checked out!", ml.checkIn(b2));
    
    setup();
    p1.setMaximumBooks(1);
    ml.addBook(b2);
    ml.addPerson(p1);
    ml.addPerson(p2);

    assertTrue("First book did not check out", ml.checkout(b2, p1));
    assertFalse("Second book should not have checked out", ml.checkout(b1, p1));

  }
}
