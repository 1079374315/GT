package com.gsls.gtlibrary.bean;

public class Book {

    private int number;
    private String bookName;

    public Book() {
        super();
    }

    public Book(int number, String bookName) {
        this.number = number;
        this.bookName = bookName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "number=" + number +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
