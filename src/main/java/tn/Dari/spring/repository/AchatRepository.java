package tn.Dari.spring.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
	@Query("select a FROM Annonce a where a.date = (select Max(a1.date) from Annonce a1) and a.status='vendu'")
	Annonce findLastAnnounce();
	@Query("select a FROM Annonce a where a.categorie=?1 or a.region=?2 or a.ville=?3 or a.nbreChambre=?4 or a.prix between ?6 and ?7 or a.surface between ?8 and ?9  and a.user=?5 and type='vente' ")
    List<Annonce> findForUser(String categorie,String region,String ville,int nbreChambre,User user,float prixMin,float prixfMax,int surfMin, int surfMax);
	@Query("select a.region,count(a) from Annonce a group by a.region")
	Map<String,Integer> nbrAnnouncePerRegion();
	@Query("select count(a) from Annonce a")
	int nbreAnnounce();
}
