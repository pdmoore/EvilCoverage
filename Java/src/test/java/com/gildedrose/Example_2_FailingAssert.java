package com.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Example_2_FailingAssert {

    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    private Item[] createItemArray(String itemName, int sellIn, int quality) {
        return new Item[] { new Item(itemName, sellIn, quality) };
    }

    @Test
    public void LegendaryItem_QualityDoesNotDecrease() {
        // Arrange
        GildedRose sut = new GildedRose(createItemArray("Sulfuras, Hand of Ragnaros", 20, 80));

        // Act
        sut.updateQuality();

        // Assert
        assertEquals(80, sut.items[0].quality);
    }

    @Test
    public void LegendaryItem_NeverHasToBeSold() {
        GildedRose sut = new GildedRose(createItemArray("Sulfuras, Hand of Ragnaros", 1, 80));
        sut.updateQuality();
        assertEquals(1, sut.items[0].sellIn);
    }

    @Test
    public void NonLegendaryItem_SellInDate_Decreases() {
        GildedRose sut = new GildedRose(createItemArray("generic item", 8, 10));
        sut.updateQuality();
        assertEquals(7, sut.items[0].sellIn);
    }

    @Test
    public void NonLegendaryItem_SellinDate_CanBeNegative() {
        GildedRose sut = new GildedRose(createItemArray("Aged Brie", 0, 25));
        sut.updateQuality();
        assertEquals(-1, sut.items[0].sellIn);
    }

    @Test
    public void LegendaryItem_SellinDate_NotDecreased_WhenNegative() {
        GildedRose sut = new GildedRose(createItemArray("Sulfuras, Hand of Ragnaros", -1, 25));
        sut.updateQuality();
        assertEquals(-1, sut.items[0].sellIn);
    }

    @Test
    public void GenericItem_QualityDecreasesBeforeSellinDate() {
        GildedRose sut = new GildedRose(createItemArray("generic item", 5, 10));
        sut.updateQuality();
        assertEquals(9, sut.items[0].quality);
    }

    @Test
    public void GenericItem_VerifyAllFields() {
        GildedRose sut = new GildedRose(createItemArray("generic item", 5, 10));
        sut.updateQuality();
        assertEquals("generic item, 4, 9", sut.items[0].toString());
    }

    @Test
    public void GenericItem_QualityDecreasesTwiceAsFastAfterSellinDate() {
        GildedRose sut = new GildedRose(createItemArray("generic item", 0, 10));
        sut.updateQuality();
        assertEquals(8, sut.items[0].quality);
    }

    @Test
    public void GenericItem_QualityNeverGoesNegative() {
        GildedRose sut = new GildedRose(createItemArray("generic item", 0, 0));
        sut.updateQuality();
        assertEquals(0, sut.items[0].quality);
    }

    @Test
    public void AgedBrie_QualityIncreases() {
        GildedRose sut = new GildedRose(createItemArray("Aged Brie", 5, 30));
        sut.updateQuality();
        assertEquals(31, sut.items[0].quality);
    }

    @Test
    public void NonLegendaryItem_ThatImprovesWithAge_QualityIsCappedAt50() {
        GildedRose sut = new GildedRose(createItemArray(BACKSTAGE_PASS, 5, 50));
        sut.updateQuality();
        assertEquals(50, sut.items[0].quality);
    }


    @Test
    public void AgedBrie_QualityIncreases_EvenAfterSellInDate() {
        GildedRose sut = new GildedRose(createItemArray("Aged Brie", -1, 20));
        sut.updateQuality();
        assertEquals(22, sut.items[0].quality);
    }

    @Test
    public void AgedBrie_QualityIsCappedAt50_EvenWhenReallyOld() {
        GildedRose sut = new GildedRose(createItemArray("Aged Brie", -99, 50));
        sut.updateQuality();
        assertEquals(50, sut.items[0].quality);
    }

    @Test
    public void BackstagePass_QualityIncreasesEachDay() {
        GildedRose sut = new GildedRose(createItemArray(BACKSTAGE_PASS, 30, 23));
        sut.updateQuality();
        assertEquals(24, sut.items[0].quality);
    }

    @Test
    public void BackstagePass_QualityIncreasesMoreAsConcertNears() {
        GildedRose sut = new GildedRose(createItemArray(BACKSTAGE_PASS, 10, 40));
        sut.updateQuality();
        assertEquals(42, sut.items[0].quality);
    }

    @Test
    public void BackstagePass_QualityIncreasesMoreAsConcertNears_ButStillCapped() {
        GildedRose sut = new GildedRose(createItemArray(BACKSTAGE_PASS, 10, 49));
        sut.updateQuality();
        assertEquals(50, sut.items[0].quality);
    }

    @Test
    public void BackstagePass_QualityIncreasesMuchMoreWhenConcertIsClose_ButStillCapped() {
        GildedRose sut = new GildedRose(createItemArray(BACKSTAGE_PASS, 5, 49));
        sut.updateQuality();
        assertEquals(50, sut.items[0].quality);
    }

    @Test
    public void BackStagePass_QualityDropsToZeroWhenConcertPasses() {
        GildedRose sut = new GildedRose(createItemArray(BACKSTAGE_PASS, 0, 50));
        sut.updateQuality();
        assertEquals(0, sut.items[0].quality);
    }


    // Oops - there's a failing test and I don't have time to dig into why it is failing
    @Test
    public void BackstagePass_HandleSpecialCase() {
        GildedRose sut = new GildedRose(createItemArray(BACKSTAGE_PASS, 5, 40));
        sut.updateQuality();
        assertEquals(42, sut.items[0].quality);
    }


}
