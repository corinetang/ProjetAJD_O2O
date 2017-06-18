package org.descartes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.descartes.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmailAndPassword(String email, String password);
}
