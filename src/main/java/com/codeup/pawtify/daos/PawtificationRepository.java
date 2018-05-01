package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.Pawtification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PawtificationRepository extends CrudRepository<Pawtification, Long> {

}
