package tn.Dari.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.AnnanceMeuble;



@Repository
public interface AnnanceMeubleReopsitory extends CrudRepository<AnnanceMeuble,Integer > {
	//List<AnnanceMeuble> findByOrderByprixAsc();

}
