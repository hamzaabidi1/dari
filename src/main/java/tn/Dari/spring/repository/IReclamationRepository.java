package tn.Dari.spring.repository;


import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.Dari.spring.entity.Reclamation;
import tn.Dari.spring.entity.User;

@Repository
public interface IReclamationRepository extends CrudRepository<Reclamation, Integer> {

	@Query("SELECT a.user, COUNT (r) FROM  Reclamation r Join r.annonce a Group By a.user")
	 Map<User,Integer> nombre();
	
	@Query("SELECT  COUNT (r) FROM  Reclamation r Join r.annonce a where a.user=?1")
	 int nombrerec(User user);

	
	@Transactional
	@Modifying
	@Query("update Reclamation  r set r.reponse= :reponse where r.id= :id")
	public int respondtoreclamation(@Param("id") int id, @Param("reponse") String reponse);

	
	
}
