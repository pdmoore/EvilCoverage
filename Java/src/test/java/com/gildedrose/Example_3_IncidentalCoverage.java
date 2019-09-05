package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Example_3_IncidentalCoverage {


    @Test
    public void AgedBrie_Past_SellinDate() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 25) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        assertEquals("Aged Brie, -1, 27", sut.items[0].toString());
    }
    // First test: Line: 54%  Branch: 12%

    @Test
    public void BackStagePass_Past_SellinDate() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", sut.items[0].toString());
    }
    // Second test: Line 81%  Branch: 28%

}
