package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.CatBreed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatBreedRepository extends CrudRepository<CatBreed, Long> {
    List<CatBreed> findByBreedIsLike(String str);
}
