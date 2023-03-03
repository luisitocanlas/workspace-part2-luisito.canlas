package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    // fixture
    private InMemoryCatalog catalog;

    @Before
    public void setUp() throws Exception {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findSelfTitled_shouldReturnCorrectResult() {
        Collection<MusicItem> items = catalog.findSelfTitled();
        // size should be 2, ids are 6 and 7
        assertEquals(2, items.size());

        // I need to extract (get) the first one and make sure its id is 6, then the 2nd one is 7
        List<MusicItem> itemsList = new ArrayList<>(items);

        // now you can say itemsList.get(0) and check its id
        assertEquals(6L, itemsList.get(0).getId().longValue());
        assertEquals(7L, itemsList.get(1).getId().longValue());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getAll_shouldReturnReadOnlyCollection() {
        Collection<MusicItem> items = catalog.getAll();
        items.clear();  // should trigger UnsupportedOperationException
    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(1000L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItem_whenIdFound() {
        MusicItem item = catalog.findById(10L);

        assertEquals(10L, item.getId().longValue());   // assertEquals(Object, Object)
    }
}