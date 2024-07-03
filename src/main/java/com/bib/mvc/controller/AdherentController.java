package com.bib.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bib.mvc.model.Adherent;
import com.bib.mvc.service.AdherentService;

@Controller
@RequestMapping("/adherent")
public class AdherentController {
	
	@Autowired
	private AdherentService service;
	
	@GetMapping("")
	public String index() {
		
		//model.addAttribute("adherents", this.service.getAllAdherents());
		return "adherent/index";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute Adherent adherent) {
		
		return "adherent/add";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("adherent", this.service.getAdherentByID(id));
		return "adherent/add";
	}
	
	@PostMapping("/add")
	public String store(@Valid @ModelAttribute Adherent adherent) {
		
		this.service.saveAdherent(adherent);
		return "redirect:/adherent";
	
	}
	
	
	@GetMapping("/consulte")
	public String consulte(@RequestParam(name="CIN", defaultValue="" )String CIN, Model model) {
		System.out.println("jkrfjkhsdqjkh");
		model.addAttribute("adherent", this.service.consulterAdherent(CIN));
		
		return "adherent/consulte";
	}
	
	
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		this.service.delete(id);
		//System.out.println("done");
		return "redirect:/adherent";
	}
	
}
