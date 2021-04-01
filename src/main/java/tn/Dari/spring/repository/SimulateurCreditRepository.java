package tn.Dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.Dari.spring.entity.SimulateurCredit;

public interface SimulateurCreditRepository extends CrudRepository<SimulateurCredit,Integer > {
	@Query (value= "Select * FROM simulateur_credit rv where rv.user_id= :idusr", nativeQuery =true)
	List<SimulateurCredit> retrieveSimulateurCreditByUser(@Param("idusr")int idusr);
	@Query (value= "Select * FROM simulateur_credit rv where rv.user_Id = ?1 and rv.banque_id= ?2", nativeQuery =true)
	List<SimulateurCredit> retrieveSimulateurCreditByUserBanque(int idusr,int idbnq);
}
