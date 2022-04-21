package hh.santtu.itemslist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.santtu.itemslist.domain.*;

@Controller
public class ItemslistController {
	@Autowired
	private ItemRepository irepository;
	
	@Autowired
	private SlotRepository srepository;
	
	@Autowired
	private RarityRepository rrepository;
	
	// Show all items
	@RequestMapping(value = {"/", "/itemlist"})
	public String itemlist(Model model) {
		model.addAttribute("items", irepository.findAll());
		return "itemlist";
	}
	
	// RESTful - Get all items
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public @ResponseBody List<Item> studentListRest() {
		return (List<Item>) irepository.findAll();
	}
	
	// RESTful - get item by id
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Item> findStudentRest(@PathVariable("id") Long itemId) {
		return irepository.findById(itemId);
	}
	
	// Add new item
	@RequestMapping(value = "/add")
	public String addItem(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("slots", srepository.findAll());
		model.addAttribute("rarities", rrepository.findAll());
		return "additem";
	}
	
	// Save new item
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Item item) {
		irepository.save(item);
		return "redirect:itemlist";
	}
	
	// Delete specified item
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteItem(@PathVariable("id") Long itemId, Model model) {
		irepository.deleteById(itemId);
		return "redirect:../itemlist";
	}
	
	// Edit specified item
	@RequestMapping(value = "/edit/{id}")
	public String editItem(@PathVariable("id") Long itemId, Model model) {
		model.addAttribute("item", irepository.findById(itemId));
		model.addAttribute("slots", srepository.findAll());
		model.addAttribute("rarities", rrepository.findAll());
		return "edititem";
	}
	
	// Login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
}
