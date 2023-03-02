package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    // fixture
    private Television tv1;
    private Television tv2;
    private TelevisionBrandChannelComparator bcComp;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Sony", 50, DisplayType.LED);
        tv2 = new Television("Sony", 50, DisplayType.LED);
        bcComp = new TelevisionBrandChannelComparator();
    }

    @Test
    public void compare_shouldReturnTrue_sameBrand_NegativeChannel() throws InvalidChannelException {
        tv1.changeChannel(75);
        tv2.changeChannel(555);

        assertEquals(-1, bcComp.compare(tv1, tv2));
        assertTrue(bcComp.compare(tv1, tv2) < 0);        // Jorge's solution
    }

    @Test
    public void compare_shouldReturnTrue_sameBrand_PositiveChannel() throws InvalidChannelException {
        tv1.changeChannel(800);
        tv2.changeChannel(50);

        assertEquals(1, bcComp.compare(tv1, tv2));
        assertTrue(bcComp.compare(tv1, tv2) > 0);        // Jorge's solution
    }

    @Test
    public void compare_shouldReturnTrue_sameBrand_sameChannel() throws InvalidChannelException {
        tv1.changeChannel(5);
        tv2.changeChannel(5);

        assertEquals(0, bcComp.compare(tv1, tv2));
    }
}