package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.Conjured;
import com.gildedrose.items.ItemUpdater;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.Sulfuras;

public class ItemUpdaterFactory {
	private ItemChecker itemChecker;
	
	public ItemUpdaterFactory() {
		itemChecker = new ItemChecker();
	}
	
	public ItemUpdater createItem(Item item) {
		
		if(itemChecker.itemIsAgedBrie(item)) {
			return new AgedBrie();
		} else if (itemChecker.itemIsBackstagePass(item)) {
			return new BackstagePass();
		} else if (itemChecker.itemIsConjured(item)) {
			return new Conjured();
		} else if (itemChecker.itemIsSulfuras(item)) {
			return new Sulfuras();
		}
		return new NormalItem();
		
	}

}
