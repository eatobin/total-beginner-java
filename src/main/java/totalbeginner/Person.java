package totalbeginner;

public class Person {
    // Fields
    private String name; // Name of Person
    private int maximumBooks; // Most Books the Person can check out

    // Constructors
    public Person() {
        name = "unknown name";
        maximumBooks = 3;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String anyName) {
        this.name = anyName;
    }

    int getMaximumBooks() {
        return maximumBooks;
    }

    void setMaximumBooks(int maximumBooks) {
        this.maximumBooks = maximumBooks;
    }

    public String toString() {
        return this.getName() + " (" + this.getMaximumBooks() + " books)";
    }
}
