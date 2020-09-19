package com.gildedrose;

class GildedRose {
    Item[] items;
    private String backstagePasses = "Backstage passes to a TAFKAL80ETC concert"; 
    private String sulfuras = "Sulfuras, Hand of Ragnaros"; 
    private String agedBrie = "Aged Brie"; 

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(agedBrie) && !items[i].name.equals(backstagePasses)) {
            	this.decreaseQuality(i);
            } else {
                if (items[i].quality < 50) {
                	this.increaseQualityTest(i); 

                    if (items[i].name.equals(backstagePasses)) {
                        if (items[i].sellIn < 11) {
                        	this.increaseQuality(i); 
                        }

                        if (items[i].sellIn < 6) {
                        	this.increaseQuality(i); 
                        }
                    }
                }
            }

            if (!items[i].name.equals(sulfuras)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(agedBrie)) {
                    if (!items[i].name.equals(backstagePasses)) {
                    	this.decreaseQuality(i);
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                	this.increaseQuality(i); 
                }
            }
        }
    }
    
    private void increaseQualityTest(int index) {
    		items[index].quality = items[index].quality + 1;
    }
    
    private void increaseQuality(int index) {
    	if (items[index].quality < 50) {
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
}