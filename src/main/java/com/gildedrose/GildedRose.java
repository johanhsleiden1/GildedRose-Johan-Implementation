package com.gildedrose;

class GildedRose {
    Item[] items;
    private String backstagePasses = "Backstage passes to a TAFKAL80ETC concert"; 
    private String sulfuras = "Sulfuras, Hand of Ragnaros"; 
    private String agedBrie = "Aged Brie"; 
    private String conjured = "Conjured"; 
    private int maxQuantity = 50; 

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    private Boolean itemIsAgedBrie(Item item) {
    	return item.name.equals(agedBrie);
    }
    
    private Boolean itemIsBackstagePass(Item item) {
    	return item.name.equals(backstagePasses);
    }
    
    private Boolean itemIsSulfuras(Item item) {
    	return item.name.equals(sulfuras);
    }
    
    private Boolean itemIsConjured(Item item) {
    	return item.name.contains(conjured);
    }
    
    private Boolean sellByDatePassed(Item item) {
    	return item.sellIn < 0;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (itemIsAgedBrie(item) || itemIsBackstagePass(item)) {
            	increaseQuality(item);
            } else {
            	decreaseQuality(item);             	
            	if(itemIsConjured(item)) {
            		decreaseQuality(item);
            	}
            }

            if (!itemIsSulfuras(item)) {
            	decreaseSellIn(item);
            }

            if (sellByDatePassed(item)) {
                if (itemIsAgedBrie(item)) {
                	increaseExtraQuality(item); 
                } else {
                	if (itemIsBackstagePass(item)) {
                		setQualityToZero(item);
                    } else {
                    	decreaseQuality(item);  	
                    	if(itemIsConjured(item)) {
                    		decreaseQuality(item);
                    	}
                    }
                	
                }
            }
        }
    }
    
    private void increaseQuality(Item item) {
    	if (item.quality < maxQuantity) {
    		item.quality = item.quality + 1;
        	this.handleQualityBasedOnSellIn(item);
    	}
    }
    
    private void handleQualityBasedOnSellIn(Item item) {
   	 if (item.name.equals(backstagePasses)) {
            if (item.sellIn < 11) {
            	this.increaseExtraQuality(item); 
            }

            if (item.sellIn < 6) {
            	this.increaseExtraQuality(item); 
            }
        }
   }
      
    private void increaseExtraQuality(Item item) {
    	if (item.quality < maxQuantity) {
    		item.quality = item.quality + 1;
    	}
    }
    
    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
		   if (!item.name.equals(sulfuras)) {
		        item.quality = item.quality - 1;
		   }
        }
    }
    
    private void decreaseSellIn(Item item) {
    	 item.sellIn = item.sellIn - 1;
    }
    
    private void setQualityToZero(Item item) {
		item.quality = item.quality - item.quality;
   }
}