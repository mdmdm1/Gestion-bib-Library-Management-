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

import com.bib.mvc.model.Emprunt;
import com.bib.mvc.service.AdherentService;
import com.bib.mvc.service.DocumentService;
import com.bib.mvc.service.EmpruntService;

@Controller
@RequestMapping("/emprunt")
public class EmpruntController {
	
	@Autowired
	private EmpruntService service;
	
	@Autowired
	private AdherentService adherentService;
	
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("")
	public String index(Model model) {
		
		model.addAttribute("emprunts", this.service.getAllEmprunts());
		return "emprunt/index";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute Emprunt emprunt,Model model1, Model model2) {
		model1.addAttribute("adherents", this.adherentService.getAllAdherents());
		model2.addAttribute("documents", this.documentService.getAllDocuments());
		return "emprunt/add";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("emprunt", this.service.getEmpruntByID(id));
		model.addAttribute("adherents", this.adherentService.getAllAdherents());
		model.addAttribute("documents", this.documentService.getAllDocuments());
		return "emprunt/add";
	}
	
	@PostMapping("/add")
	public String store(@Valid @ModelAttribute Emprunt emprunt, Model model) {
		/*
		 * if(result.hasErrors()){
		 * 
		 * return "emprunt/add"; }
		 */
		//System.out.println(emprunt);
		this.service.saveEmprunt(emprunt);
		return "redirect:/emprunt";
	
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		this.service.delete(id);
		//System.out.println("done");
		return "redirect:/emprunt";
	}
	
	
}
