package persistence;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: Jun 9, 2010
 * Time: 3:34:49 PM
 */
@SuppressWarnings({"SerializableHasSerializationMethods"})
public class Person implements Serializable
{
	// Fields

	private String name; // Name of Person
	private int maximumBooks; // Most Books the Person can check out
	private static final long serialVersionUID = 2277703936610730900L;

	// Constructors

	public Person()
	{
		name = "unknown name";
		maximumBooks = 3;
	}

	// Methods

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

	public String toString()
	{
		return this.getName() + " (" + this.getMaximumBooks() + " books)";
	}
}
