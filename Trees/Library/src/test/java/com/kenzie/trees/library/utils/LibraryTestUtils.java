package com.kenzie.trees.library.utils;

import com.kenzie.trees.library.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class LibraryTestUtils {

    private static final String[] AUTHORS = {
        "barnikki", "judeanth", "golemmes",
        "samgord", "protasio", "bpercivia",
        "hcrites", "vanchang"};

    private LibraryTestUtils(){};

    /**
     * Generate sample books for our tests
     *
     * @param numSamples the number of sample Books we want to create
     * @return A list of generated Books of the size provided
     */
    public static List<Book> generateBooks(int numSamples, Random random){
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < numSamples; i++) {
            books.add(generateBook(Integer.toString(i), random));
        }

        // shuffle to ensure the order of the books is random
        Collections.shuffle(books);
        return books;
    }

    public static String getRandomAuthor(Random random) {
        return AUTHORS[random.nextInt(AUTHORS.length)];
    }


    /**
     * Generate a sample book for our tests
     *
     * @param isbn The given ISBN for the book we will create
     * @return A new Book with the given ISBN,
     *         a randomly generated title,
     *         and a randomly selected author
     */
    private static Book generateBook(String isbn, Random random) {
        String title = UUID.randomUUID().toString();
        String author = getRandomAuthor(random);

        return new Book(isbn, title, author);
    }

}
