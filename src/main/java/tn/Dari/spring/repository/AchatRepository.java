package tn.Dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.Annonce;
import tn.Dari.spring.entity.User;

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
	@Query("select a FROM Annonce a where a.date = (select Max(a1.date) from Announce a1) and a.status=vendu")
	Annonce findLastAnnounce();
	@Query("select a FROM Annonce a where a.categorie=?1 or a.region=?2 or a.ville=?3 or a.nbreChambre=?4 or a.prix betwwen ?6 and ?7 or a.surface betwwen ?8 and ?9  and a.user=5 and type=location ")
	public List<Annonce> findForUser(String categorie,String region,String ville,int nbreChambre,User user,float prixMin,float prixfMax,int surfMin, int surfMax);

}
