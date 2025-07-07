package totalbeginner;

public class Book {
    String title;
    String author;
    private Person person;

    public Book(String string) {
        this.title = string;
        this.author = "unknown author";
    }

    private String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    private String getTitle() {
        return title;
    }

    public void setPerson(Person p2) {
        this.person = p2;
    }

    public Person getPerson() {
        return this.person;
    }

    public String toString() {
        String available;

        if (this.getPerson() == null) {
            available = "Available";
        } else {
            available = "Checked out to " + this.getPerson().getName();
        }

        return this.getTitle() + " by " + this.getAuthor() + "; " + available;
    }
}
