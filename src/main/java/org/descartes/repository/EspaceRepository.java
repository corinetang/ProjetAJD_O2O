package org.descartes.repository;

import java.util.List;

import org.descartes.domain.Espace;
import org.descartes.domain.TypeEspace;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EspaceRepository extends CrudRepository<Espace, Long>  {
	
	@Query("SELECT e FROM Espace e WHERE e.superficie >= :minimum AND e.superficie <= :maximum")
	List<Espace> findBySuperficie(@Param("minimum") int minimum, @Param("maximum") int maximum);
	
	@Query("SELECT e FROM Espace e WHERE e.prix >= :minimum AND e.prix <= :maximum")
	List<Espace> findByPrice(@Param("minimum") int minimum, @Param("maximum") int maximum);
	
	@Query("SELECT e FROM Espace e INNER JOIN e.local l WHERE l.ville = :ville")
	List<Espace> findByVille(@Param("ville") String ville);
	
	List<Espace> findByType(TypeEspace type);
	
	@Query("SELECT e FROM Espace e INNER JOIN e.local l WHERE l.id = :id")
	List<Espace> findByLocal(@Param("id") int id);
	
	@Query ("SELECT e FROM Espace e INNER JOIN e.local l WHERE e.superficie >= :minsup AND e.superficie <= :maxsup AND e.prix >= :minprix AND e.prix <= :maxprix AND l.ville = :ville")
	List<Espace> findAllWithVille(@Param("minsup") int minsup, @Param("maxsup") int maxsup, @Param("minprix") int minprix, @Param("maxprix") int maxprix, @Param("ville") String ville);

	@Query ("SELECT e FROM Espace e INNER JOIN e.local l WHERE e.superficie >= :minsup AND e.superficie <= :maxsup AND e.prix >= :minprix AND e.prix <= :maxprix  AND e.type = :type")
	List<Espace> findAllWithType(@Param("minsup") int minsup, @Param("maxsup") int maxsup, @Param("minprix") int minprix, @Param("maxprix") int maxprix, @Param("type") TypeEspace type);
	
	@Query ("SELECT e FROM Espace e INNER JOIN e.local l WHERE e.superficie >= :minsup AND e.superficie <= :maxsup AND e.prix >= :minprix AND e.prix <= :maxprix AND l.ville = :ville AND e.type = :type")
	List<Espace> findAllWithVilleType(@Param("minsup") int minsup, @Param("maxsup") int maxsup, @Param("minprix") int minprix, @Param("maxprix") int maxprix, @Param("ville") String ville, @Param("type") TypeEspace type);
}
