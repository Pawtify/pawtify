package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.CatBreed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatBreedRepository extends CrudRepository<CatBreed, Long> {
}
