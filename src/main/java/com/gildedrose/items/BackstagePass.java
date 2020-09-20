package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends ItemUpdater {
	
	@Override
	public void updateQuality(Item item) {
		increaseQuality(item);
		handleQualityBasedOnSellIn(item);
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
        	setQualityToZero(item);
        }	
	}
	
    private void handleQualityBasedOnSellIn(Item item) {
         if (item.sellIn < 11) {
          	this.increaseQuality(item); 
         }

         if (item.sellIn < 6) {
           	this.increaseQuality(item); 
         }
      }

}
