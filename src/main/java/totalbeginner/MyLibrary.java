package totalbeginner;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Eric
 * Date: Jun 12, 2010
 * Time: 11:50:17 AM
 */
public class MyLibrary {
    String name;
    ArrayList<Book> books;
    ArrayList<Person> people;

    MyLibrary(String name) {
        this.name = name;
        books = new ArrayList<>();
        people = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    private ArrayList<Person> getPeople() {
        return people;
    }

    void addBook(Book b1) {
        this.books.add(b1);
    }

    void removeBook(Book b1) {
        this.books.remove(b1);
    }

    void addPerson(Person p1) {
        this.people.add(p1);
    }

    boolean checkOut(Book b1, Person p1) {
        int booksOut = this.getBooksForPerson(p1).size();

        if ((b1.getPerson() == null) &&
                (booksOut < p1.getMaximumBooks())) {
            b1.setPerson(p1);
            return true;
        } else {
            return false;
        }
    }

    boolean checkIn(Book b1) {
        if (b1.getPerson() != null) {
            b1.setPerson(null);
            return true;
        } else {
            return false;
        }
    }

    ArrayList<Book> getBooksForPerson(Person p1) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book aBook : this.getBooks()) {
            if ((aBook.getPerson() != null) &&
                    (aBook.getPerson().getName()
                            .equals(p1.getName()))) {
                result.add(aBook);
            }
        }

        return result;
    }

    ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> result = new ArrayList<>();

        for (Book aBook : this.getBooks()) {
            if (aBook.getPerson() == null) {
                result.add(aBook);
            }
        }

        return result;
    }

    ArrayList<Book> getUnavailableBooks() {
        ArrayList<Book> result = new ArrayList<>();

        for (Book aBook : this.getBooks()) {
            if (aBook.getPerson() != null) {
                result.add(aBook);
            }
        }

        return result;
    }

    public String toString() {
        return this.getName() + ": " +
                this.getBooks().size() + " books; " +
                this.getPeople().size() + " people.";
    }

    public static void main(String[] args) {
        // Create a new MyLibrary

        MyLibrary testLibrary = new MyLibrary("Test Drive Library");
        Book b1 = new Book("War And Peace");
        Book b2 = new Book("Great Expectations");
        b1.setAuthor("Tolstoy");
        b2.setAuthor("Dickens");
        Person jim = new Person();
        Person sue = new Person();
        jim.setName("Jim");
        sue.setName("Sue");

        testLibrary.addBook(b1);
        testLibrary.addBook(b2);
        testLibrary.addPerson(jim);
        testLibrary.addPerson(sue);

        System.out.println("Just created new library - Tutorial");
        testLibrary.printStatus();

        System.out.println("Check out War And Peace to Sue");
        testLibrary.checkOut(b1, sue);
        testLibrary.printStatus();

        System.out.println("Do some more stuff");
        testLibrary.checkIn(b1);
        testLibrary.checkOut(b2, jim);
        testLibrary.printStatus();
    }

    private void printStatus() {
        StringBuilder sb = new StringBuilder("--- Status Report of MyLibrary ---\n" +
                this.toString() + "\n");

        for (Book thisBook : this.getBooks()) {
            sb.append(thisBook).append("\n");
            //System.out.println(thisBook);
        }

        for (Person p : this.getPeople()) {
            int count = this.getBooksForPerson(p).size();
            sb.append(p).append(" (has ").append(count).append(" of my books)\n");
        }

        sb.append("Books available: ").append(this.getAvailableBooks().size()).append("\n");

        sb.append("--- End of Status Report ---");
        System.out.println(sb.toString());
    }
}
