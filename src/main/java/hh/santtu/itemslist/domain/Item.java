package hh.santtu.itemslist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String itemname;
	private Long ilevel;
	private String source;
	
	
	@ManyToOne
	@JoinColumn(name = "slotId")
	@JsonManagedReference
	private Slot slot;
	
	@ManyToOne
	@JoinColumn(name = "rarityId")
	@JsonManagedReference
	private Rarity rarity;
	
	public Item() {}
	
	public Item(String itemname, Long ilevel, String source, Rarity rarity, Slot slot) {
		super();
		this.itemname = itemname;
		this.ilevel = ilevel;
		this.source = source;
		this.slot = slot;
		this.rarity = rarity;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Long getIlevel() {
		return ilevel;
	}
	public void setIlevel(Long ilevel) {
		this.ilevel = ilevel;
	}
	public Rarity getRarity() {
		return rarity;
	}
	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}
}
