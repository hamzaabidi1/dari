package tn.Dari.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.Dari.spring.entity.Livraison;

public interface LivraisonRepository extends CrudRepository<Livraison, Integer> {
	List<Livraison> findAllByAdresseLike(String Adresse);
	List<Livraison> findAllByMethodePayementLike(String livraison);
	List<Livraison> findAllByLivraisonStatusLike(String status);
	

}
