package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/inicio")
public class InicioController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(ModelMap model) {
		
		model.addAttribute("inicioMensagem", "Está é pagina de inicio");
		
		
		return "inicio";
	}
}
