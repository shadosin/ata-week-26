package com.kenzie.trees.library;

import com.kenzie.trees.library.treestructure.BookNode;

import org.apache.commons.lang.NotImplementedException;

import java.util.Stack;

/**
 * Application to test traversing Binary Trees and Binary Search Trees.
 *
 * Represents a Library with a collection of books.
 */
public class LibraryService {

    /**
     * The root node of our tree of Books.
     * Assume this tree is sorted by ISBN.
     * The tree and its nodes should not be modified by our application.
    */
    private final BookNode books;

    /**
     * Constructs our library with a default tree of books.
     * Assume this tree is sorted by ISBN.
     *
     * @param books The root node of a tree of Books
     */
    public LibraryService(final BookNode books) {
        this.books = books;
    }

    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given ISBN.
     *
     * @param isbn A given ISBN to search our library for
     * @return True if a book with the given ISBN is in our library and
     *         false otherwise
     */
    public boolean isBookInLibraryByIsbn(String isbn) {
        // PARTICIPANTS: IMPLEMENT YOUR BINARY SEARCH HERE
        if (isbn == null || isbn.isEmpty()) {
            return false;
        }

        BookNode currentNode = books;

        while (currentNode != null) {
            int comparison = isbn.compareTo(currentNode.getBook().getIsbn());

            if (comparison == 0) {
                return true; //
            } else if (comparison < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        return false;
    }


    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given Title and Author.
     *
     * @param title A given title to search our library for, alongside an author's name
     * @param author The name of a given author to search our library for, alongside a title
     * @return True if a book with the given title and author is in our library, and
     *         false otherwise
     */
    public boolean isBookInLibraryByTitleAndAuthor(String title, String author) {
        // PARTICIPANTS: IMPLEMENT YOUR DEPTH FIRST SEARCH HERE
        if(author == null || title == null || author.isEmpty() || title.isEmpty()){
            return false;
        }
        BookNode currentNode = books;
        if(currentNode == null){
            return false;
        }
        Stack<BookNode> bookStack = new Stack<BookNode>();
        bookStack.push(currentNode);
        while(!bookStack.isEmpty()){
            BookNode current = bookStack.pop();
            if(author.equals(current.getBook().getAuthor()) && title.equals(current.getBook().getTitle())){
                return true;
            }
            if(current.getRight() != null){
                bookStack.push(current.getRight());
            }
            if(current.getLeft() != null){
                bookStack.push(current.getLeft());
            }
        }

        return false;
    }


}
