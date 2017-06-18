package org.descartes.repository;

import java.util.List;

import org.descartes.domain.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LocationRepository  extends CrudRepository<Location, Long>{

	@Query("SELECT l FROM Location l INNER JOIN l.espace e WHERE e.id = :id")
	List<Location> findByEspace(@Param("id") int id);
}
