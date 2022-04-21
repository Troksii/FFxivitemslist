package hh.santtu.itemslist.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SlotRepository extends CrudRepository<Slot, Long>{
	List<Slot> findByName(String name);
}
