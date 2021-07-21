package foo.bar.qix.wemanity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foo.bar.qix.wemanity.service.ComputeService;

@RestController
@RequestMapping("compute")
public class ComputeController {
	
	@Autowired
	private ComputeService computeService;
	
	/**
	 * 
	 * @param input
	 * @return une chaine de caracteres qui varie en fonction de l'input
	 */
	@GetMapping("/{input}")
	public ResponseEntity<String> compute(@PathVariable String input){
		return ResponseEntity.ok("Structure bien mise en place");
		
	}
}
