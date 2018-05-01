package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.DogBreed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogBreedRepository extends CrudRepository<DogBreed, Long> {

}
