import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        Book b1 = new Book(1, "Java", "John");
        Member m1 = new Member(1, "Riya");

        lib.addBook(b1);
        lib.addMember(m1);
        lib.issueBook(1, 1);
        lib.searchBook("Java");
        lib.returnBook(1, 1);
    }

    static class Book {
        int id;
        String title;
        String author;
        boolean available;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.available = true;
        }
    }

    static class Member {
        int id;
        String name;

        Member(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static class Library {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();

        void addBook(Book b) {
            books.add(b);
        }

        void addMember(Member m) {
            members.add(m);
        }

        void issueBook(int bookId, int memberId) {
            for (Book b : books) {
                if (b.id == bookId && b.available) {
                    b.available = false;
                    System.out.println("Book issued");
                }
            }
        }

        void returnBook(int bookId, int memberId) {
            for (Book b : books) {
                if (b.id == bookId) {
                    b.available = true;
                    System.out.println("Book returned");
                }
            }
        }

        void searchBook(String title) {
            for (Book b : books) {
                if (b.title.equals(title)) {
                    System.out.println("Book found: " + b.title);
                }
            }
        }
    }
}
