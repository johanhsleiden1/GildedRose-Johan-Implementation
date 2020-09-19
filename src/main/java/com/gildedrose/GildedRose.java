package com.gildedrose;

class GildedRose {
    Item[] items;
    private String backstagePasses = "Backstage passes to a TAFKAL80ETC concert"; 
    private String sulfuras = "Sulfuras, Hand of Ragnaros"; 
    private String agedBrie = "Aged Brie"; 
    private int maxQuantity = 50; 

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (itemIsAgedBrie(i) || itemIsBackstagePass(i)) {
            	increaseQuality(i);
            } else {
            	decreaseQuality(i); 
            }

            if (!itemIsSulfuras(i)) {
            	decreaseSellIn(i);
            }

            if (sellByDatePassed(i)) {
                if (itemIsAgedBrie(i)) {
                	increaseExtraQuality(i); 
                } else {
                	if (itemIsBackstagePass(i)) {
                		setQualityToZero(i);
                    } else {
                    	decreaseQuality(i);
                    }
                	
                }
            }
        }
    }
    
    private Boolean itemIsAgedBrie(int index) {
    	return items[index].name.equals(agedBrie);
    }
    
    private Boolean itemIsBackstagePass(int index) {
    	return items[index].name.equals(backstagePasses);
    }
    
    private Boolean itemIsSulfuras(int index) {
    	return items[index].name.equals(sulfuras);
    }
    
    private Boolean sellByDatePassed(int index) {
    	return items[index].sellIn < 0;
    }
    
    private void increaseQuality(int index) {
    	if (items[index].quality < maxQuantity) {
    		items[index].quality = items[index].quality + 1;
        	this.handleQualityBasedOnSellIn(index);
    	}
    }
    
    private void handleQualityBasedOnSellIn(int index) {
    	 if (items[index].name.equals(backstagePasses)) {
             if (items[index].sellIn < 11) {
             	this.increaseExtraQuality(index); 
             }

             if (items[index].sellIn < 6) {
             	this.increaseExtraQuality(index); 
             }
         }
    }
    
    private void increaseExtraQuality(int index) {
    	if (items[index].quality < maxQuantity) {
    		items[index].quality = items[index].quality + 1;
    	}
    }
    
    private void decreaseQuality(int index) {
        if (items[index].quality > 0) {
		   if (!items[index].name.equals(sulfuras)) {
		        items[index].quality = items[index].quality - 1;
		   }
        }
    }
    
    private void decreaseSellIn(int index) {
    	 items[index].sellIn = items[index].sellIn - 1;
    }
    
    private void setQualityToZero(int index) {
		items[index].quality = items[index].quality - items[index].quality;
   }
}