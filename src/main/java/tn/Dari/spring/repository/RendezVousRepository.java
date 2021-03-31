package tn.Dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.Dari.spring.entity.RendezVous;

public interface RendezVousRepository extends CrudRepository<RendezVous,Integer >{


}
