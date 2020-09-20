package com.gildedrose;

import com.gildedrose.items.ItemUpdater;

class GildedRose {
    Item[] items;
    private ItemUpdaterFactory itemUpdaterFactory;

    public GildedRose(Item[] items) {
        this.items = items;
        itemUpdaterFactory = new ItemUpdaterFactory();
    }
    
    public void updateQuality() {
        for (Item item : items) {
        	ItemUpdater createdItem = itemUpdaterFactory.createItem(item);
        	createdItem.updateItem(item);
        }
    }
}