package hh.santtu.itemslist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{
	List<Item> findByItemname(String itemname);
}
