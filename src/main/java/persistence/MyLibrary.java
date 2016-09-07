package persistence;

import java.io.Serializable;
import java.util.ArrayList;

public class MyLibrary implements Serializable {
    String name;
    ArrayList<Book> books;
    ArrayList<Person> people;
    private static final long serialVersionUID = 1628111105684495433L;

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

    ArrayList<Person> getPeople() {
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

        System.out.println("Just created new library - Persistence");
        testLibrary.printStatus();

        System.out.println("Check out War And Peace to Sue");
        testLibrary.checkOut(b1, sue);
        testLibrary.printStatus();

        System.out.println("Do some more stuff");
        testLibrary.checkIn(b1);
        testLibrary.checkOut(b2, jim);

        testLibrary.printStatus();

        MyUtilities.saveMyLibraryToXMLFile("testmain.xml", testLibrary);
        MyLibrary newMyLibrary = MyUtilities.getMyLibraryFromXMLFile("testmain.xml");
        System.out.println("Printing information from saved xml file.");
        newMyLibrary.printStatus();
    }

    private void printStatus() {
        System.out.println("Status Report of MyLibrary \n" +
                this.toString());

        for (Book thisBook : this.getBooks()) {
            System.out.println(thisBook);
        }

        for (Person p : this.getPeople()) {
            int count = this.getBooksForPerson(p).size();
            System.out.println(p + " (has " + count
                    + " of my books)");
        }

        System.out.println("Books available: "
                + this.getAvailableBooks().size());

        System.out.println("--- End of Status Report ---");
        System.out.println();
    }
}
