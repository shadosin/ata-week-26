package com.kenzie.trees.library.treestructure;

import com.kenzie.trees.library.model.Book;

/**
 * Represents a node containing a book in a binary tree.
 */
public class BookNode {
    /* The Book value stored at this node */
    private Book book;

    /* The left child of this node */
    private BookNode left;

    /* The right child of this node */
    private BookNode right;

    /* We use the color of the node to help balance the tree. Color can either be red (true) or black (false)*/
    private boolean isRed;

    /**
     * Constructor for a new BookNode for our Tree, for a given Book.
     *
     * @param book the book for the node (defensively copied)
     */
    public BookNode(Book book) {
        this.book = new Book(book);

        // For balancing: default to a RED node
        this.isRed = true;

        // Have null children by default
        this.left = null;
        this.right = null;
    }

    /**
     * Get the book value for this node.
     * Defensively copies the book.
     *
     * @return the book for this node
     */
    public Book getBook() {
        return new Book(book);
    }

    /**
     * Get the left child of the node.
     *
     * @return the left child of the node
     */
    public BookNode getLeft() {
        return left;
    }

    /**
     * Set the left child of the node.
     *
     * @param left the node to add as the left child
     */
    public void setLeft(BookNode left) {
        this.left = left;
    }

    /**
     * Get the right child of the node.
     *
     * @return the node's right child
     */
    public BookNode getRight() {
        return right;
    }

    /**
     * Set the right child of the node.
     *
     * @param right the node to add as the right child
     */
    public void setRight(BookNode right) {
        this.right = right;
    }

    /**
     * Returns the color of the node, used for balancing.
     *
     * @return true (RED) or false (BLACK)
     */
    public boolean isRed() {
        return isRed;
    }

    /**
     * Sets the color of the node, used for balancing.
     *
     * @param isColorRed true (RED) or false (BLACK)
     */
    public void setColor(boolean isColorRed) {
        this.isRed = isColorRed;
    }

    /**
     * Flips the color of the node.
     */
    public void flipColor() {
        this.isRed = !this.isRed;
    }
}
