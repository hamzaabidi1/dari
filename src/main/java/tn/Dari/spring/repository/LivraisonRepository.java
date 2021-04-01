package tn.Dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.Livraison;
@Repository
public interface LivraisonRepository extends CrudRepository<Livraison, Integer> {
	

}
