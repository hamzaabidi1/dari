package tn.Dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.Recherche;
@Repository
public interface rechercheRepository extends CrudRepository<Recherche, Integer> {

}
