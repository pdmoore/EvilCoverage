package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        assertEquals("foo", sut.items[0].name);
    }

}
