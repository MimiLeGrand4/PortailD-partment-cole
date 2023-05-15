package org.web2proj.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.web2proj.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}

