package hh.santtu.itemslist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.santtu.itemslist.domain.Item;
import hh.santtu.itemslist.domain.ItemRepository;
import hh.santtu.itemslist.domain.RarityRepository;
import hh.santtu.itemslist.domain.SlotRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemslistRepositoryTest {
	
	@Autowired
	private ItemRepository brepository;
	
	@Autowired
	private SlotRepository srepository;
	
	@Autowired
	private RarityRepository rrepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Item> books = brepository.findByItemname("Animal Farm");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getItemname()).isEqualTo("George Orwell");
	}
	
	@Test
	public void createNewItem() {
		Item item = new Item("testimiekka", (long) 23, "Dungeon of the Deep", rrepository.findByRname("Common").get(0), srepository.findByName("Head").get(0));
		brepository.save(item);
		assertThat(item.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		brepository.delete(brepository.findByItemname("Animal Farm").get(0));
		List<Item> books = brepository.findByItemname("Animal Farm");
		assertThat(books).hasSize(0);
		
	}
}
