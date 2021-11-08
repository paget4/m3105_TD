package fr.unilim.iut;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InnTest {
  @Test
  public void should_write_tests() {
	  assertThat(new Inn().getItems()).extracting("name")
	  .containsExactly("+5 Dexterity Vest", "Aged Brie",
			  "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", 
			  "Backstage passes to a TAFKAL80ETC concert", 
			  "Conjured Mana Cake");
  }
  
	@Test
	public void should_list_items() {
		  assertThat(new Inn().getItems()).extracting("name")
		  .containsExactly("+5 Dexterity Vest", "Aged Brie",
				  "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", 
				  "Backstage passes to a TAFKAL80ETC concert", 
				  "Conjured Mana Cake");
		  assertThat(new Inn().getItems()).extracting("sellIn")
		  .containsExactly(10,2,5,0,15,3);
		  assertThat(new Inn().getItems()).extracting("quality")
		  .containsExactly(20,0,7,80,20,6);
	}
	
	@Test
	public void should_update_items() {
		Inn inn=new Inn();
		inn.updateQuality();
		
		  assertThat(inn.getItems()).extracting("name")
		  .containsExactly("+5 Dexterity Vest", "Aged Brie",
				  "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", 
				  "Backstage passes to a TAFKAL80ETC concert", 
				  "Conjured Mana Cake");
		  assertThat(inn.getItems()).extracting("sellIn")
		  .containsExactly(9,1,4,0,14,2);
		  assertThat(inn.getItems()).extracting("quality")
		  .containsExactly(19,1,6,80,21,5);
	}
	
	@Test
	public void should_update_items_twice() {
		Inn inn=new Inn();
		inn.updateQuality();
		inn.updateQuality();
		
		  assertThat(inn.getItems()).extracting("name")
		  .containsExactly("+5 Dexterity Vest", "Aged Brie",
				  "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", 
				  "Backstage passes to a TAFKAL80ETC concert", 
				  "Conjured Mana Cake");
		  assertThat(inn.getItems()).extracting("sellIn")
		  .containsExactly(8,0,3,0,13,1);
		  assertThat(inn.getItems()).extracting("quality")
		  .containsExactly(18,2,5,80,22,4);
	}
	
	@Test
	public void should_update_items_twrice() {
		Inn inn=new Inn();
		inn.updateQuality();
		inn.updateQuality();
		inn.updateQuality();
		
		  assertThat(inn.getItems()).extracting("name")
		  .containsExactly("+5 Dexterity Vest", "Aged Brie",
				  "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", 
				  "Backstage passes to a TAFKAL80ETC concert", 
				  "Conjured Mana Cake");
		  assertThat(inn.getItems()).extracting("sellIn")
		  .containsExactly(7,-1,2,0,12,0);
		  assertThat(inn.getItems()).extracting("quality")
		  .containsExactly(17,4,4,80,23,3);
	}
	
}
