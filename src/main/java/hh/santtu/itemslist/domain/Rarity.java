	package hh.santtu.itemslist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Rarity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rarityId;
	private String rname;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rarity")
	private List<Item> items;
	
	public Rarity() {}
	
	public Rarity(String rname) {
		super();
		this.rname = rname;
	}

	public long getRarityId() {
		return rarityId;
	}

	public void setRarityId(long rarityId) {
		this.rarityId = rarityId;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}