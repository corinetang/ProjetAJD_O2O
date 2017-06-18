package org.descartes.web;

import java.util.Date;
import java.util.List;

import org.descartes.domain.Location;
import org.descartes.repository.LocationRepository;
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
@RequestMapping(path="/location")
public class LocationController {

	@Autowired 
	private LocationRepository locationRepository;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public @ResponseBody Location createLocation(@RequestParam Date startDate, @RequestParam Date endDate) {
		Location lo = new Location(startDate, endDate);
		locationRepository.save(lo);
		return lo;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public @ResponseBody Location editLocal(@RequestBody Location location) {
		locationRepository.save(location);
		return location;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path="/findAll")
	public @ResponseBody Iterable<Location> findAll() {
		return locationRepository.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/findByEspace")
	public @ResponseBody List<Location> findByEspace(@RequestParam int id) {
		return locationRepository.findByEspace(id);
	}
}
