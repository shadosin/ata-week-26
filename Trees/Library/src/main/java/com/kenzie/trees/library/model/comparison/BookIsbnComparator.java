package com.kenzie.trees.library.model.comparison;

import com.kenzie.trees.library.model.Book;

import java.util.Comparator;

/**
 * Comparator to compare Books by ISBN.
 */
public class BookIsbnComparator implements Comparator<Book> {
    /**
     * Compare two books via ISBN.
     * @param book1 one book to compare
     * @param book2 the other book to compare
     * @return 0 if the ISBNs of the two Books are the same,
     *         greater than 0 if the ISBN of book1 is larger (by natural order)
     *         less than 0 if the ISBN of book2 is larger (by natural order)
     */
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getIsbn().compareTo(book2.getIsbn());
    }
}
