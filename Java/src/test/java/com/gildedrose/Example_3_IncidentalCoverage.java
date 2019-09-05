package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Example_3_IncidentalCoverage {

    // Add tests to cover the last line of code/most indented in the method
    // Continue til 100% line coverage

    @Test
    public void AgedBrie_Past_SellinDate() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 25) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        assertEquals("Aged Brie, -1, 27", sut.items[0].toString());
    }
    // First test: Line 54%  Branch 12%

    @Test
    public void BackStagePass_Past_SellinDate() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", sut.items[0].toString());
    }
    // Second test: Line 81%  Branch 28%

    @Test
    public void UnspecialItem() {
        Item[] items = new Item[] { new Item("generic", 0, 10) };
        GildedRose sut = new GildedRose((items));
        sut.updateQuality();
        assertEquals("generic, -1, 8", sut.items[0].toString());
    }
    // Third test: Line 100%  Branch 33%

    // Only some lines are intentionally covered. Most are incidentally covered.
    // For example, delete lines 24-34 and all tests still pass
}
