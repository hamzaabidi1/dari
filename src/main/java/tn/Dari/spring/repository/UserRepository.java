package tn.Dari.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import tn.Dari.spring.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByName(String name);
	
	public Optional<User> findByEmail(String email);

	Boolean existsByName(String name);

	Boolean existsByEmail(String email);

	public Optional<User> findByResetToken(String token);
	
	@Query("SELECT p FROM User p WHERE p.name = ?1")
    //  + " OR p.firstName LIKE %?1%"
    //  + " OR p.email LIKE %?1%")
    //  + " OR CONCAT(p.price, '') LIKE %?1%")
   //public List<User> search(String name);
	
	List<User> findAllByNameLike(String name);
	
	@Modifying
	@Transactional
	@Query(value="delete from user_roles where user_roles.user_id=:id ", nativeQuery =true)
	public int deleteRole(@Param("id")long id);
	
	

}
