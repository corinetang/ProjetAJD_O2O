package org.descartes.web;

import org.descartes.domain.Local;
import org.descartes.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping(path="/local")
public class LocalController {

	@Autowired 
	private LocalRepository localRepository;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public @ResponseBody Local createLocal(@RequestBody Local l) {
		return localRepository.save(l);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public @ResponseBody Local editLocal(@RequestBody Local local) {
		return localRepository.save(local);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path="/findAll")
	public @ResponseBody Iterable<Local> findAll() {
		return localRepository.findAll();
	}
}
