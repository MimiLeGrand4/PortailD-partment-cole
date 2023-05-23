package com.vincent.projetportailweb.repos;

import com.vincent.projetportailweb.entities.AccountType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<AccountType, Integer> {

}


