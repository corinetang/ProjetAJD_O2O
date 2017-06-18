package org.descartes.web;

import org.descartes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.descartes.domain.User;

@Component
@RestController
@RequestMapping(path="/user")
public class UserController {
	@Autowired 
	private UserRepository userRepository;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public @ResponseBody User createUser(@RequestBody User u) {
		return userRepository.save(u);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public @ResponseBody User login(@RequestBody User u) {
		return userRepository.findByEmailAndPassword(u.getEmail(), u.getPassword());
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path="/findAll")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "/edit")
	public @ResponseBody User editUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}
