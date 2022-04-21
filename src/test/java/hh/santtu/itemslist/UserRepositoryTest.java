package hh.santtu.itemslist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.santtu.itemslist.domain.User;
import hh.santtu.itemslist.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = urepository.findByUsername("admin");
		assertThat(user).isNotNull();
		assertThat(user.getRole()).isEqualTo("ADMIN");
	}
	
	@Test
	public void createUser() {
		User user = new User("matti", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "matti@ffxiv.com");
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		urepository.delete(urepository.findByUsername("user"));
		User user = urepository.findByUsername("user");
		assertThat(user).isNull();
	}
}
