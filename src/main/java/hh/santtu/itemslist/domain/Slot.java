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
public class Slot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long slotId;
	private String name;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "slot")
	private List<Item> items;
	
	public Slot() {}
	
	public Slot(String name) {
		super();
		this.name = name;
	}

	public long getSlotId() {
		return slotId;
	}

	public void setSlotId(long slotId) {
		this.slotId = slotId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}