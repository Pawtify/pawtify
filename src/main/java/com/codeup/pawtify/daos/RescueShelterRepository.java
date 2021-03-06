package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.RescueShelter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RescueShelterRepository extends CrudRepository<RescueShelter, Long> {
}
