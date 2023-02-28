/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.Catalog;
import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;
import java.util.Collections;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        // testFindByKeyword();
        // testFindByCategory();
        // testSize();
        // testGetAll();

        // testFindSelfTitled();
        // testFindRockBottom();
        // testGenreCount();
        // testAverageCost();
        // testCheapItem();
        // testAvgCostGenre();
        // testIsAtLeast();
        // testIsGenreAvailable();
        // testGetPopTitles();
        testGetTheFollowing();
    }

    private static void testGetTheFollowing() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.getTheFollowing(15.00));
    }

    private static void testGetPopTitles() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.getPopTitles());
    }

    private static void testIsGenreAvailable() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.isGenreAvailable(MusicCategory.ROCK));
        System.out.println(catalog.isGenreAvailable(MusicCategory.JAZZ));
    }

    private static void testIsAtLeast() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.isAtLeast(10.00));
    }

    private static void testAvgCostGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.avgCostGenre(MusicCategory.ROCK));
    }

    private static void testCheapItem() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.cheapItem(MusicCategory.ROCK));
    }

    private static void testAverageCost() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.printf("Average cost is : $%.2f", catalog.averageCost());
    }

    private static void testGenreCount() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        int genre = catalog.genreCount(MusicCategory.POP);
        System.out.println(genre);
    }

    private static void testFindRockBottom() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> items = catalog.findRockBottom(15.00);
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }

    private static void testFindSelfTitled() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> items = catalog.findSelfTitled();
        for (MusicItem item: items) {
            System.out.println(item);
        }
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem item = catalog.findById(12L);
        System.out.println(item);

        MusicItem notFound = catalog.findById(19L);
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> item = catalog.findByKeyword("CREED");    // artist, all upper case
        System.out.println(item);

        Collection<MusicItem> item2 = catalog.findByKeyword("diva");    // title, all lower case
        System.out.println(item2);

        Collection<MusicItem> notFound = catalog.findByKeyword("Paramore"); // empty
        System.out.println(notFound);
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.size());
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog);
    }
}