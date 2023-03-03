/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void removeDuplicates() {
        Collection<Television> tvs = Catalog.getInventory();
        Collection<Television> tvs2 = new HashSet<>();
        tvs2.addAll(tvs);

        System.out.println(tvs.size());
        System.out.println(tvs2.size());
        assertNotEquals(tvs.size(), tvs2.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getInventory_shouldReturnUnmodifiableCatalog() {
        Collection<Television> tvs = Catalog.getInventory();
        tvs.clear(); // should trigger UnsupportedOperationException
    }

    /*
    @Test
    public void findByBrands_test() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith", "LG");
        for (Map.Entry<String, Collection<Television>> tv : tvMap.entrySet()) {
            System.out.println(tv);
        }
    }
    */

    @Test
    public void findByBrands_shouldReturnMapWithEntries_whenBrandsPassed() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith", "LG");

        assertEquals(3, tvMap.size());

        Collection<Television> sonyTvs = tvMap.get("Sony");
        assertEquals(7, sonyTvs.size());
        for (Television tv : sonyTvs) {
            assertEquals("Sony", tv.getBrand());
        }

        Collection<Television> zenithTvs = tvMap.get("Zenith");
        assertEquals(9, zenithTvs.size());
        for (Television tv : zenithTvs) {
            assertEquals("Zenith", tv.getBrand());
        }

        Collection<Television> lgTvs = tvMap.get("LG");
        assertEquals(0, lgTvs.size());
        for (Television tv : lgTvs) {
            assertEquals("LG", tv.getBrand());
        }
    }

    @Test
    public void findByBrands_shouldReturnEmptyMap_whenNoBrandsPassed() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands();

        assertTrue(tvMap.isEmpty());
    }

    @Test
    public void findByBrand_shouldReturnCollectionOfBrand_whenBrandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");

        assertEquals(7, tvs.size());
        for (Television tv : tvs) {
            assertEquals("Sony", tv.getBrand());
        }
    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldReturnEmptyCollection_whenBrandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");

        assertTrue(tvs.isEmpty());
    }
}