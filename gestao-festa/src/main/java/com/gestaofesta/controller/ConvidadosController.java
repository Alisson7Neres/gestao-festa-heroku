package com.gestaofesta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestaofesta.model.Convidado;
import com.gestaofesta.repository.ConvidadoCrud;

@Controller
@RequestMapping("/*")
public class ConvidadosController {

	@Autowired
	private ConvidadoCrud convidadosRepository;
	
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidadosRepository.findAll());
		modelAndView.addObject(new Convidado());
	return modelAndView;
	}
	
	@GetMapping("**/removerconvidado/{convidadoid}") 
	public String deletar(@PathVariable ("convidadoid") Long convidadoid){
		convidadosRepository.deleteById(convidadoid);
		
		ModelAndView view = new ModelAndView("ListaConvidados");
		view.addObject("convidados", convidadosRepository.findAll());
		view.addObject("convidado", new Convidado());
		return "redirect:/convidados";
	}
	
	@PostMapping
	public String salvar(Convidado convidado,
			BindingResult result) {
		this.convidadosRepository.save(convidado);
		return "redirect:/convidados";
	}
	
}
