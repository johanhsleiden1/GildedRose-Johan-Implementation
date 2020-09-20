package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemChecker;

public class AgedBrie extends ItemUpdater {
	
	@Override
	public void updateQuality(Item item) {
		increaseQuality(item);		
	}

	@Override
	public void updateSellIn(Item item) {
		decreaseSellIn(item);	
	}

	@Override
	public void updateItem(Item item) {
        updateQuality(item);
        updateSellIn(item);
        
        if (sellByDatePassed(item)) {
        	updateQuality(item);
        }
		
	}

}
