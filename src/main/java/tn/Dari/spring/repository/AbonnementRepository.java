package tn.Dari.spring.repository;
<<<<<<< HEAD

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.Dari.spring.entity.Abonnement;
import tn.Dari.spring.entity.Annonce;

@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement,Integer > {

=======
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.Abonnement ;
import tn.Dari.spring.entity.AbonnementType;
import tn.Dari.spring.entity.User;


@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement,Integer>{
	@Query("FROM Abonnement a where a.user=?1 ")
	List<Abonnement> retrieveAbonnementPerUser (User user);
	@Query(value= "SELECT count(a) FROM Abonnement a WHERE a.nom= ?1 and a.type = ?2 AND a.user=?3 ")
	int findAbonnementByTypesAndName(String nom, AbonnementType type , User user ); 
	@Query("SELECT count (a) FROM Abonnement a")
	int totalAbonnement();	
	@Query("SELECT a.nom,count  (a) FROM Abonnement a group by a.nom ")
	Map<String,Integer> totalAbonnementPerName();
>>>>>>> master
}
