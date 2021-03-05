package tn.Dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.Dari.spring.entity.Annonce;
@Repository
public interface AnnonceRepository extends CrudRepository<Annonce,Integer > {

}
