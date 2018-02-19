package src;

class Book {

    int isbn;
    String title;
    String author;
    String publisher;
    int year;
    float price;
    boolean isEbook = false;

    Book(int isbn, String title, String author, String publisher, int year, float price, boolean isEbook) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
        this.isEbook = isEbook;
    }

    int getIsbn() {
        return isbn;
    }

    String getAuthor() {
        return author;
    }

    String getTitle() {
        return title;
    }

    String getPublisher() {
        return publisher;
    }

    int getYear() {
        return year;
    }

    float getPrice() {
        return price;
    }

    boolean isEbook() {
        return isEbook;
    }

    void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    void setYear(int year) {
        this.year = year;
    }

    void setPrice(float price) {
        this.price = price;
    }

    void setEbook(boolean ebook) {
        isEbook = ebook;
    }
}
