package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class Example_1_LineCoverage {

    // Configure Code Coverage for Sampling, not Tracing
    // These tests provide 97% line coverage
    // Coverage coloring shows everything green
    // Where's the missing coverage???


    @Test
    public void plain_old_item() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        assertEquals("foo", sut.items[0].name);
    }

    @Test
    public void quality_above_zero() {
        Item[] items = new Item[] { new Item("foo", 0, 25) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        assertEquals("foo", sut.items[0].name);
    }

    @Test
    public void cheesy_test() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 25) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        assertEquals("Aged Brie", sut.items[0].name);
    }

    @Test
    public void backstage_pass() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", sut.items[0].name);
    }

    // Switch to Tracing, not Sampling
    // 96% line coverage but only 44% branch coverage

}
