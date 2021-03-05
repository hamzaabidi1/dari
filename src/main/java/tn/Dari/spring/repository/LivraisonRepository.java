package tn.Dari.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.Livraison;
@Repository
public interface LivraisonRepository extends CrudRepository<Livraison, Integer> {
	List<Livraison> findAllByAdresseLike(String Adresse);
	List<Livraison> findAllByMethodePayementLike(String methode);
	List<Livraison> findAllByLivraisonStatusLike(String status);
	

}
