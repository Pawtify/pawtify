package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RescueShelterRepository extends CrudRepository<User, Long> {

}
