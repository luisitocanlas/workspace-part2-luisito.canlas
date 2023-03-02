package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    // fixture
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Sony", 50, DisplayType.LED);
        tv2 = new Television("Sony", 50, DisplayType.LED);
    }

    // hashCode
    @Test
    public void hashCode_equalObjects_mustHaveEqualHashCodes() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    // equals
    @Test
    public void equals_shouldReturnFalse_sameBrand_sameVolume_differentDisplay() {
        tv2.setDisplay(DisplayType.OLED);

        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_differentVolume_sameDisplay() {
        tv2.setVolume(35);

        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_differentBrand_sameVolume_sameDisplay() {
        tv2.setBrand("Samsung");

        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(tv1, tv2);
    }

    // compareTo
    @Test
    public void compareTo_shouldReturnTrue_sameBrand_differentVolume_differentDisplay() {
        tv2.setVolume(55);
        tv2.setDisplay(DisplayType.OLED);
        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void compareTo_shouldReturnTrue_sameBrand_sameVolume_differentDisplay() {
        tv2.setDisplay(DisplayType.OLED);
        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void compareTo_shouldReturnTrue_sameBrand_differentVolume_sameDisplay() {
        tv2.setVolume(55);
        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void compareTo_shouldReturnTrue_sameAllProperties() {
        assertEquals(0, tv1.compareTo(tv2));
    }

    // changeChannel
    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_maxChannel() {
        try {
            tv1.changeChannel(1000);
            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 1000. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_minChannel()
            throws InvalidChannelException {
        try {
            tv1.changeChannel(0);   // should trigger the exception
            fail("Should have thrown InvalidChannelException");
        }
        catch (InvalidChannelException e) {
            // you can assert that the exception's reason message is what you expect
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
            throw e;
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_maxChannel() throws InvalidChannelException {
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_minChannel() throws InvalidChannelException {
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    // setVolume
    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_maxVolume() {
        tv1.setVolume(101); // should trigger the exception, and I DON'T catch it
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_maxVolume() {
        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());
    }

    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_minVolume() {
        tv1.setVolume(-1);  // should trigger the exception, and I DON'T catch it
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_minVolume() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }
}