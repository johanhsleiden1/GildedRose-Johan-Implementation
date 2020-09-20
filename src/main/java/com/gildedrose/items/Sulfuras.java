package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras extends ItemUpdater{

	@Override
	public void updateQuality(Item item) {
		// Nothing happens with Sulfuras
	}

	@Override
	public void updateSellIn(Item item) {
	  // Nothing happens with Sulfuras
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
