package hh.santtu.itemslist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.santtu.itemslist.domain.Item;
import hh.santtu.itemslist.domain.ItemRepository;
import hh.santtu.itemslist.domain.Rarity;
import hh.santtu.itemslist.domain.RarityRepository;
import hh.santtu.itemslist.domain.Slot;
import hh.santtu.itemslist.domain.SlotRepository;
import hh.santtu.itemslist.domain.User;
import hh.santtu.itemslist.domain.UserRepository;

@SpringBootApplication
public class ItemslistApplication {
		
	private static final Logger log = LoggerFactory.getLogger(ItemslistApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ItemslistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Itemslist(ItemRepository irepository, SlotRepository srepository, RarityRepository rrepository, UserRepository urepository) {
		return (args) -> {
			srepository.save(new Slot("Weapon"));
			srepository.save(new Slot("Head"));
			srepository.save(new Slot("Body"));
			srepository.save(new Slot("Hands"));
			srepository.save(new Slot("Legs"));
			srepository.save(new Slot("Feet"));
			srepository.save(new Slot("Ring"));
			srepository.save(new Slot("Earring"));
			srepository.save(new Slot("Necklace"));
			srepository.save(new Slot("Bracelet"));
			
			rrepository.save(new Rarity("Common"));
			rrepository.save(new Rarity("Aetherial"));
			rrepository.save(new Rarity("Scarce"));
			rrepository.save(new Rarity("Rare"));
			rrepository.save(new Rarity("Relic"));
			
			irepository.save(new Item("testimiekka", (long) 23, "Dungeon of the Deep", rrepository.findByRname("Common").get(0), srepository.findByName("Head").get(0)));
	
			
			urepository.save(new User("troksi", "$2a$10$MvCbOkma2KoQ.kHxGs0NbeKGz57xOaqp8a5G.aYLDydV84IZdk0zi", "TROKSI", "santtux2@hotmail.com"));

			for (Item item : irepository.findAll()) {
				log.info(item.toString());
			}
		};
	}
}
