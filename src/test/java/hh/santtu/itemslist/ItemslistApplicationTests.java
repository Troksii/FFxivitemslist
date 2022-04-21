package hh.santtu.itemslist;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.santtu.itemslist.domain.UserRepository;
import hh.santtu.itemslist.web.ItemslistController;

@RunWith(SpringRunner.class)
@SpringBootTest
class ItemslistApplicationTests {
	
	@Autowired
	private ItemslistController icontroller;

	@Autowired
	private UserRepository ucontroller;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(icontroller).isNotNull();
		assertThat(ucontroller).isNotNull();
	}

}
