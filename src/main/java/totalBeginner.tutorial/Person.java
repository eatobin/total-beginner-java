package totalBeginner.tutorial;

public class Person
{

  private String name;
  private int maximumBooks;

  public Person()
  {
    this.name = "unknown name";
    maximumBooks = 3;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String anyName)
  {
    this.name = anyName;
  }

  public int getMaximumBooks()
  {
    return maximumBooks;
  }

  public void setMaximumBooks(int maximumBooks)
  {
    this.maximumBooks = maximumBooks;
  }

  @Override
  public String toString()
  {
    return this.getName() + " (" + this.getMaximumBooks() + " books)";
  }

}
