package com.gildedrose;

public class ItemChecker {

    private final String AGED_BRIE = "Aged Brie"; 
    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"; 
    private final String CONJURED = "Conjured"; 
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros"; 
	
    public Boolean itemIsAgedBrie(Item item) {
    	return item.name.equals(AGED_BRIE);
    }
    
    public Boolean itemIsBackstagePass(Item item) {
    	return item.name.equals(BACKSTAGE_PASSES);
    }
    
    public Boolean itemIsConjured(Item item) {
    	return item.name.contains(CONJURED);
    }
    
    public Boolean itemIsSulfuras(Item item) {
    	return item.name.equals(SULFURAS);
    }
    

    
}
