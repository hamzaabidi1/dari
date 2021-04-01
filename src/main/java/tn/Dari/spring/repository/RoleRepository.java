package tn.Dari.spring.repository;


import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.spring.entity.Role;
import tn.Dari.spring.entity.Roles;
import tn.Dari.spring.entity.User;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByName(Role name);

	}
