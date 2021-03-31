package tn.Dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.Recherche;
import tn.Dari.spring.entity.User;
@Repository
public interface rechercheRepository extends CrudRepository<Recherche, Integer> {
	@Query("select r from Recherche r where r.user=?1")
	List<Recherche> findAllPerUser(User user);
	

}
