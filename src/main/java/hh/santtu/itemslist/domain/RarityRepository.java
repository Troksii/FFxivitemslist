package hh.santtu.itemslist.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RarityRepository extends CrudRepository<Rarity, Long>{
	List<Rarity> findByRname(String rname);
}
