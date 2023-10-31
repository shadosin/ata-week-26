package com.kenzie.trees.library;

import com.kenzie.trees.library.model.Book;
import com.kenzie.trees.library.utils.BalancedBookTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.kenzie.trees.library.utils.LibraryTestUtils.generateBooks;
import static com.kenzie.trees.library.utils.LibraryTestUtils.getRandomAuthor;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindBookByTitleAndAuthorTest {
    private LibraryService libraryService;
    private Random random;
    private List<Book> sampleBooks;

    @BeforeEach
    public void setup() {
        random = new Random();
        sampleBooks = generateBooks(100, random);

        BalancedBookTree bookTree = new BalancedBookTree();
        sampleBooks.forEach(bookTree::put);

        libraryService = new LibraryService(bookTree.getRoot());
    }

    @Test
    public void testIsBookInLibraryByTitleAndAuthor_nullTitle_returnsFalse() {
        // GIVEN
        String title = null;
        String author = getRandomAuthor(random);

        // WHEN & THEN
        assertFalse(libraryService.isBookInLibraryByTitleAndAuthor(title, author),
            "Expected to not find a book with a null title in our library");
    }

    @Test
    public void testIsBookInLibraryByTitleAndAuthor_emptyTitle_returnsFalse() {
        // GIVEN
        String title = "";
        String author = getRandomAuthor(random);

        // WHEN & THEN
        assertFalse(libraryService.isBookInLibraryByTitleAndAuthor(title, author),
            "Expected to not find a book with an empty title in our library");
    }

    @Test
    public void testIsBookInLibraryByTitleAndAuthor_nullAuthor_returnsFalse() {
        // GIVEN
        String title = sampleBooks.get(0).getTitle();
        String author = null;

        // WHEN & THEN
        assertFalse(libraryService.isBookInLibraryByTitleAndAuthor(title, author),
            "Expected to not find a book with a null author in our library");
    }

    @Test
    public void testIsBookInLibraryByTitleAndAuthor_emptyAuthor_returnsFalse() {
        // GIVEN
        String title = sampleBooks.get(0).getTitle();
        String author = "";

        // WHEN & THEN
        assertFalse(libraryService.isBookInLibraryByTitleAndAuthor(title, author),
            "Expected to not find a book with an empty author in our library");
    }

    @Test
    public void testIsBookInLibraryByTitleAndAuthor_nonExistingAuthor_returnsFalse() {
        // GIVEN
        String title = sampleBooks.get(0).getTitle();
        String author = "larsonj";

        assertFalse(libraryService.isBookInLibraryByTitleAndAuthor(title, author),
            String.format("Expected to not find a book with author {%s} in our library", author));
    }

    @Test
    public void testIsBookInLibraryByTitleAndAuthor_nonExistingTitle_returnsFalse() {
        // GIVEN
        String title = UUID.randomUUID().toString();
        String author = "barnikki";

        assertFalse(libraryService.isBookInLibraryByTitleAndAuthor(title, author),
            String.format("Expected to not find a book with title {%s} in our library", title));
    }

    @Test
    public void testIsBookInLibraryByTitleAndAuthor_allBooksExist_returnsTrue() {
        // GIVEN
        List<Book> missingBooks = sampleBooks.stream()
            .filter(book -> !libraryService
                .isBookInLibraryByTitleAndAuthor(book.getTitle(), book.getAuthor()))
            .collect(Collectors.toList());

        assertTrue(missingBooks.isEmpty(),
            String.format(
                "Books {%s} were not found in our library",
                missingBooks));
    }
}
