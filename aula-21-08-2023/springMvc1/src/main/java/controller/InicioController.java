package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // Spring identifica que é uma classe controladora
@RequestMapping("/inicio")// Url para acessar a rota dessa controller
public class InicioController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(ModelMap model) {
		
		model.addAttribute("inicioMensagem", "Está é pagina de inicio");
		
		
		return "inicio";
	}
}
