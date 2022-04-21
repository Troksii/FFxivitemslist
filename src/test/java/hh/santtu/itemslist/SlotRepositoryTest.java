package hh.santtu.itemslist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.santtu.itemslist.domain.Slot;
import hh.santtu.itemslist.domain.SlotRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SlotRepositoryTest {
	@Autowired
	private SlotRepository srepository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Slot> categories = srepository.findByName("Satire");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Satire");
	}
	
	@Test
	public void createCategory() {
		Slot category = new Slot("Uncommon");
		srepository.save(category);
		assertThat(category.getSlotId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		srepository.delete(srepository.findByName("Uncommoon").get(0));
		List<Slot> categories = srepository.findByName("Rare");
		assertThat(categories).hasSize(0);
	}
}
