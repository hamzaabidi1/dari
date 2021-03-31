package tn.Dari.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.Dari.spring.entity.Annonce;
@Repository
public interface AnnonceRepository extends CrudRepository<Annonce,Integer > {
	@Query("FROM Annonce ORDER BY prix ASC")
	List<Annonce> findAllOrderByPrixAsc();
	@Query("FROM Annonce ORDER BY prix DESC")
	List<Annonce> findAllOrderByPrixDesc();
	List<Annonce> findAllByAdresseLike(String Adresse);
	List<Annonce> findAllByRegionLike(String region);
	List<Annonce> findAllByVilleLike(String ville);
	
}
