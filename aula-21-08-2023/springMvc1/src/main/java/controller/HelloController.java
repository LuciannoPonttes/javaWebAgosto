package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // Essa classe pe um controlador
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String imprimirHelloWord(ModelMap model) {
		
		model.addAttribute("message", "Hello Word spring mvc - raiz");
		
		
		return "hello";
	}
	
}
