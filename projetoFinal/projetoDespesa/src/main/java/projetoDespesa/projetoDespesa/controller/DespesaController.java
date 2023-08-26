package projetoDespesa.projetoDespesa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import projetoDespesa.projetoDespesa.model.Despesa;
import projetoDespesa.projetoDespesa.repository.DespesaRepositorio;

@Controller
public class DespesaController {
	
	@Autowired // Inicializa automaticamente 
	DespesaRepositorio despesaRepositorio;
	
	
	
	@RequestMapping(value="/despesa", method=RequestMethod.GET)
	public String cadastroDespesaGet() {
		
		return "cadastroDespesa";//Pagina HTML
	}
	
	@RequestMapping(value="/despesa", method=RequestMethod.POST)
	public String cadastroDespesaPost(Despesa despesa) {
		
		despesaRepositorio.save(despesa);
		
		return "redirect:/despesa";
	}
	
	
}
