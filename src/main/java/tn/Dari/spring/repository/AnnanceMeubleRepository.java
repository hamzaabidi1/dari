package tn.Dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.AnnanceMeuble;



@Repository
public interface AnnanceMeubleRepository extends CrudRepository<AnnanceMeuble,Integer> {
	@Query("FROM AnnanceMeuble ORDER BY prix ASC")
	List<AnnanceMeuble> findAllOrderByPrixAsc();
	@Query("FROM AnnanceMeuble ORDER BY prix DESC")
	List<AnnanceMeuble> findAllOrderByPrixDesc();
	List<AnnanceMeuble> findAllByAdresseLike(String Adresse);
	List<AnnanceMeuble> findAllByRegionLike(String region);
	List<AnnanceMeuble> findAllByVilleLike(String ville);

}
