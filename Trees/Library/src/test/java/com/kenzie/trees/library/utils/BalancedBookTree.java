package com.kenzie.trees.library.utils;

import com.kenzie.trees.library.model.Book;
import com.kenzie.trees.library.model.comparison.BookIsbnComparator;
import com.kenzie.trees.library.treestructure.BookNode;

import java.util.Optional;

/**
 * Helps construct a red-black Balanced Binary Search Tree
 * of type BookNode. The key for our nodes is the book's ISBN
 */
public class BalancedBookTree {
    /* The root of this tree */
    private BookNode root;

    /* The comparator to combare Books by ISBN */
    private BookIsbnComparator bookIsbnComparator;

    /**
     * Constructs an empty RED/BLACK BST
     */
    public BalancedBookTree() {
        root = null;
        bookIsbnComparator = new BookIsbnComparator();
    }

    /**
     * Get the root node of this tree
     *
     * @return The root node of this tree
     */
    public BookNode getRoot() {
        return root;
    }

    /**
     * Adds a given book to our BST.
     * If the given book is null, ignore this operation.
     *
     * @param book The book to add to our BST
     */
    public void put(Book book) {
        if (book != null) {
            root = put(root, book);
        }
    }

    /**
     * Adds the given book to a given subtree.
     * If the book is already in the subtree, return the subtree as it is.
     * After adding the book, the subtree is shifted for balance as needed.
     *
     * @param node The root of this subtree
     * @param book The book to add to a subtree
     * @return The updated root of this subtree
     */
    private BookNode put(BookNode node, Book book) {
        if (node == null) {
            return new BookNode(book);
        }

        // Compare the root of the subtree to the given book by ISBN
        int compared = bookIsbnComparator.compare(book, node.getBook());

        if (compared < 0) {
            // If the new book's ISBN is less than that at this node,
            // add it to the left.
            node.setLeft(
                put(node.getLeft(),
                    book));
        } else if (compared > 0) {
            // If the new book's ISBN is greater than that at this node,
            // add it to the left.
            node.setRight(
                put(node.getRight(),
                    book));
        }

        // balance our subtree
        return balance(node);
    }

    /**
     * Balances a given subtree
     *
     * @param node The root of the subtree to balance
     * @return The updated root othe balanced subtree
     */
    private BookNode balance(BookNode node) {
        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }

        if (isRed(node.getLeft()) && isLeftNodeRed(node.getLeft())) {
            node = rotateRight(node);
        }

        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            node = flipColors(node);
        }

        return node;
    }


    /**
     * Determine if a given node is RED
     *
     * @param node The node to check the color of
     * @return false if the given node is null. Otherwise, the color of the node
     */
    private boolean isRed(BookNode node) {
        return Optional.ofNullable(node)
            .map(BookNode::isRed)
            .orElse(false);
    }

    /**
     * Determine if the left child of a given node is RED
     *
     * @param node The node we wish to check.
     * @return false if either the given node or its left child is null.
     *         Otherwise, return the color of the node's left child.
     */
    private boolean isLeftNodeRed(BookNode node) {
        return Optional.ofNullable(node)
            .map(BookNode::getLeft)
            .map(this::isRed)
            .orElse(false);
    }

    /**
     * Flip the color of this node and its children.
     *
     * @param node A given node
     * @return the given node, after its color and the colors of
     * its children are flipped
     */
    private BookNode flipColors(BookNode node) {
        node.flipColor();
        Optional.ofNullable(node.getRight()).ifPresent(BookNode::flipColor);
        Optional.ofNullable(node.getLeft()).ifPresent(BookNode::flipColor);
        return node;
    }

    /**
     * Rotate a given subtree to the left
     *
     * @param node The root of the subtree to rotate
     * @return The new root of the subtree after rotating to the left
     */
    private BookNode rotateLeft(BookNode node) {
        BookNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        newRoot.setColor(isRed(node));
        node.setColor(true);
        return newRoot;
    }

    /**
     * Rotate a given subtree to the right
     *
     * @param node The root of the subtree to rotate
     * @return The new root of the subtree after rotating to the right
     */
    private BookNode rotateRight(BookNode node) {
        BookNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        newRoot.setColor(isRed(node));
        node.setColor(true);
        return newRoot;
    }
}
