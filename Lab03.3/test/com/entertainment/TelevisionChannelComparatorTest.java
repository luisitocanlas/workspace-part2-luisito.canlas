package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    // fixture
    private Television tv1;
    private Television tv2;
    private TelevisionChannelComparator cComp;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Sony", 50, DisplayType.LED);
        tv2 = new Television("Samsung", 50, DisplayType.LED);
        cComp = new TelevisionChannelComparator();
    }

    @Test
    public void compare_shouldReturnTrue_differentBrand_NegativeChannel() throws InvalidChannelException {
        tv1.changeChannel(75);
        tv2.changeChannel(555);

        assertEquals(-1, cComp.compare(tv1, tv2));
        assertTrue(cComp.compare(tv1, tv2) < 0);        // Jorge's solution
    }

    @Test
    public void compare_shouldReturnTrue_differentBrand_PositiveChannel() throws InvalidChannelException {
        tv1.changeChannel(800);
        tv2.changeChannel(50);

        assertEquals(1, cComp.compare(tv1, tv2));
        assertTrue(cComp.compare(tv1, tv2) > 0);        // Jorge's solution
    }

    @Test
    public void compare_shouldReturnTrue_differentBrand_SameChannel() throws InvalidChannelException {
        tv1.changeChannel(5);
        tv2.changeChannel(5);

        assertEquals(0, cComp.compare(tv1, tv2));
    }
}