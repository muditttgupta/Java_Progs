public class Library {

    static class Book {
        String title;
        String author;
        String ISBN;

        Book(String title, String author, String ISBN) {
            this.title = title;
            this.author = author;
            this.ISBN = ISBN;
        }

        void displayDetails() {
            System.out.println("Book Details:");
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + ISBN);
        }
    }

    public static void main(String[] args) {
        Library.Book myBook = new Library.Book("The Alchemist", "Paulo Coelho", "978-0062315007");
        myBook.displayDetails();
    }
}
