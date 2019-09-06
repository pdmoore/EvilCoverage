package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

public class Example_4_100PerCent {

    // 48 different item test cases provide 100% line/branch coverage

    @Test
    public void approvals_100_percent_coverage() {
        CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                new String[] {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
                new Integer[] {-1, 0, 11 },   //sellIn
                new Integer[] {0, 1, 49, 50 }
        );
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose sut = new GildedRose(items);
        sut.updateQuality();
        return sut.items[0].toString();
    }


}
