package foo.bar.qix.wemanity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foo.bar.qix.wemanity.service.ComputeServiceImpl;

@RestController
@RequestMapping("compute")
public class ComputeController {
	
	@Autowired
	private ComputeServiceImpl computeService;
	
	/**
	 * 
	 * @param input
	 * @return une chaine de caracteres qui varie en fonction de l'input
	 */
	@GetMapping("/{input}")
	public ResponseEntity<String> compute(@PathVariable String input){
		String output = computeService.compute(input);
		return ResponseEntity.ok(output);		
	}
}
