package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_QualityIncreasedToThree_AgedBrieIncreaseInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityIncreasedToFour_AgedBrieIncreaseInQualityByTwoWhenSellinIsPassed() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityIs50_QualityShouldNeverGoPast50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 3; i++) {
        	app.updateQuality();
        }        
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityOfSulfaresIs80_SulfaresNeverDecreasesInQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 80) };
        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 3; i++) {
        	app.updateQuality();
        }        
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityIsOne_QualityDegradesTwiceWhenSellDateIsPassed() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();       
        assertEquals(1, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityIsZero_QualityNeverDegradesBelowZero() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 1) };
        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 3; i++) {
        	app.updateQuality();
        }               
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityIsSix_QualityIsIncreasedWithABackstagePass() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 55, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();          
        assertEquals(6, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityOfBackstagePassIsSeven_QualityIsIncreasedByTwo() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();      
        assertEquals(7, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityOfBackstagePassIsEight_QualityIsIncreasedByThree() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();             
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityOfBackstagePassIsZero_WhenSellInIsZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();             
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityOfConjuredItemIsTwo_QualityIsDecreasedByTwo() {
        Item[] items = new Item[] { new Item("Conjured Item", 5, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();             
        assertEquals(2, app.items[0].quality);
    }
    
    @Test
    void updateQuality_QualityOfConjuredItemIsFour_QualityIsDecreasedByFourWhenSellinIsZero() {
        Item[] items = new Item[] { new Item("Conjured Item", 0, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();             
        assertEquals(4, app.items[0].quality);
    }

}
