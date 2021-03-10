package tn.Dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.Annonce;

@Repository
public interface AchatRepository extends CrudRepository<Annonce,Integer >{
	@Query("FROM Annonce ORDER BY prix ASC")
	List<Annonce> findAllOrderByAscPrice();
	@Query("FROM Annonce ORDER BY prix DESC")
	List<Annonce> findAllOrderByDescPrice();
	List<Annonce> findAllByCategorieLike(String categorie);
	List<Annonce> findAllByTypeLike(String type);
	List<Annonce> findBySurfaceBetween(int surfMin,int surfMax);
	List<Annonce> findAllByRegionLike(String region);
	List<Annonce> findAllByVilleLike(String ville);
	List<Annonce> findAllBynbreChambreLike(int nbreChambre);

}
