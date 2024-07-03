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

import com.bib.mvc.model.Dictionnaire;
import com.bib.mvc.model.Document;
import com.bib.mvc.model.Livre;
import com.bib.mvc.model.Revue;
import com.bib.mvc.service.DocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private DocumentService service;
	@GetMapping("")
	public String index(Model model){
		model.addAttribute("documents", this.service.getAllDocuments());
		return "document/index";
	}
	
	@GetMapping("/acceuil")
	public String acceuil() {
		return "index";
	}
	
	@GetMapping("/addDictionnaire")
	public String add(@ModelAttribute Dictionnaire dictionnaire) {
		
		return "document/addDictionnaire";
	}
	
	@GetMapping("/addLivre")
	public String add(@ModelAttribute Livre livre) {
		
		return "document/addLivre";
	}
	
	@GetMapping("/addRevue")
	public String add(@ModelAttribute Revue revue) {
		
		return "document/addRevue";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		if(this.service.getDocumentByID(id) instanceof Livre) {
		model.addAttribute("livre", this.service.getDocumentByID(id));
		return "document/addLivre";
		}
		else if (this.service.getDocumentByID(id) instanceof Dictionnaire) {
			model.addAttribute("dictionnaire", this.service.getDocumentByID(id));
			return "document/addDictionnaire";
		}
		else {
			model.addAttribute("revue", this.service.getDocumentByID(id));
			return "document/addRevue";
		}
	}
	
	@PostMapping("/addDictionnaire")
	public String store(@ModelAttribute Dictionnaire dictionnaire) {
		
		this.service.saveDocument(dictionnaire);
		dictionnaire.toString();
		return "redirect:/document";
	
	}
	
	@PostMapping("/addLivre")
	public String store(@ModelAttribute Livre livre) {
		
		this.service.saveDocument(livre);
		return "redirect:/document";
	
	}
	
	@PostMapping("/addRevue")
	public String store(@ModelAttribute Revue revue) {
		
		this.service.saveDocument(revue);
		return "redirect:/document";
	
	}
	
	@PostMapping("/add")
	public String store(@Valid @ModelAttribute Document document) {
		
		System.out.println(document);
		return "document/add";
	
	}
	/*
	 * @PostMapping("/edit/{id}") public String update(@PathVariable Long id) {
	 * return "document/add"; }
	 */
	@GetMapping("/consulte")
	public String consulte(@RequestParam(name="id", defaultValue="0" )Long id, Model model) {
	
		model.addAttribute("document", this.service.getDocumentByID(id));
		return "document/consulte";
	}
	
	@GetMapping("/index1")
	public String index1() {
	
		return "document/index1";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		this.service.delete(id);
		//System.out.println("done");
		return "redirect:/document";
	}
}
		
