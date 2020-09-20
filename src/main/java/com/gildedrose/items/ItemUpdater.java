package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class ItemUpdater {
	
	private final int MAX_QUANTITY = 50;
	private final int MIN_QUANTITY = 0;
	     
    protected void increaseQuality(Item item) {
    	if (item.quality < MAX_QUANTITY) {
    		item.quality = item.quality + 1;
    	}
    }
    
    protected void decreaseQuality(Item item) {
        if (item.quality > MIN_QUANTITY) {
		        item.quality = item.quality - 1;
        }
    }
    
    protected void decreaseSellIn(Item item) {
    	 item.sellIn = item.sellIn - 1;
    }
    
    protected void setQualityToZero(Item item) {
		item.quality = 0;
    }
    
    protected Boolean sellByDatePassed(Item item) {
    	return item.sellIn < 0;
    }
    
	public abstract void updateQuality(Item item);
	public abstract void updateSellIn(Item item);
	public abstract void updateItem(Item item);

}
