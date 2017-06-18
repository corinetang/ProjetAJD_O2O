package org.descartes.web;

import java.util.List;

import org.descartes.domain.Espace;
import org.descartes.domain.TypeEspace;
import org.descartes.repository.EspaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping(path="/espace")
public class EspaceController {
	@Autowired
	private EspaceRepository espaceRepository;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public @ResponseBody Espace createEspace(@RequestBody Espace e) {
		return espaceRepository.save(e);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public @ResponseBody Espace editEspace(@RequestParam Espace espace) {
		return espaceRepository.save(espace);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findAll")
	public @ResponseBody Iterable<Espace> findAll() {
		return espaceRepository.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findBySuperficie")
	public @ResponseBody List<Espace> findBySuperficie(@RequestParam int minimum, @RequestParam int maximum) {
		return espaceRepository.findBySuperficie(minimum, maximum);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findByPrice")
	public @ResponseBody List<Espace> findByPrice(@RequestParam int minimum, @RequestParam int maximum) {
		return espaceRepository.findByPrice(minimum, maximum);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findByType")
	public @ResponseBody List<Espace> findByType(@RequestParam TypeEspace type) {
		return espaceRepository.findByType(type);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findByLocal")
	public @ResponseBody List<Espace> findByLocal(@RequestParam int id) {
		return espaceRepository.findByLocal(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findByVille")
	public @ResponseBody List<Espace> findByType(@RequestParam String ville) {
		return espaceRepository.findByVille(ville);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findAllWithVille")
	public @ResponseBody List<Espace> findAllWithVille(@RequestParam int minsup, @RequestParam int maxsup, @RequestParam int minprix, @RequestParam int maxprix, @RequestParam String ville) {
		return espaceRepository.findAllWithVille(minsup, maxsup, minprix, maxprix, ville);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findAllWithType")
	public @ResponseBody List<Espace> findAllWithType(@RequestParam int minsup, @RequestParam int maxsup, @RequestParam int minprix, @RequestParam int maxprix, @RequestParam TypeEspace type) {
	 	return espaceRepository.findAllWithType(minsup, maxsup, minprix, maxprix, type);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findAllWithVilleType")
	public @ResponseBody List<Espace> findAllWithType(@RequestParam int minsup, @RequestParam int maxsup, @RequestParam int minprix, @RequestParam int maxprix, @RequestParam String ville, @RequestParam TypeEspace type) {
		return espaceRepository.findAllWithVilleType(minsup, maxsup, minprix, maxprix, ville, type);
	}
}
