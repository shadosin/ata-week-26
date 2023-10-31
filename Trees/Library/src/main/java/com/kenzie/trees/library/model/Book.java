package com.kenzie.trees.library.model;

import java.util.Objects;

/**
 * Represents a book in our library.
 */
public class Book {
    /* The unique identifier for each book (International Standard Book Number) */
    private String isbn;

    /* The title for each book */
    private String title;

    /* The author for each book */
    private String author;

    /**
     * Constructs a new Book.
     *
     * @param isbn The unique ISBN for this book
     * @param title The title of this book
     * @param author The author of this book
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    /**
     * Copy Constructor for a Book.
     *
     * @param original the book to copy
     */
    public Book(Book original) {
        this(original.getIsbn(), original.getTitle(), original.getAuthor());
    }

    /**
     * Gets the isbn for this book.
     *
     * @return the isbn for this book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Gets the title for this book.
     *
     * @return the title of this book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of this book.
     *
     * @return the author of this book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Compares this book to another Object.
     *
     * @param o the other Object to compare against
     * @return true if the Object is the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return isbn.equals(book.isbn) &&
            title.equals(book.title) &&
            author.equals(book.author);
    }

    /**
     * Calculate the hashcode for this book by isbn, title, and author.
     *
     * @return the hashcode for this book, calculated by isbn, title, and author
     */
    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author);
    }

    @Override
    public String toString() {
        return String.format("Book{isbn = %s, title = %s, author = %s}",
            isbn, title, author);
    }
}
