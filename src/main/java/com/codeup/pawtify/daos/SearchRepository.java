package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends CrudRepository<Animal, Long> {
    Animal findByAge(Animal animal);
    Animal findByName(Animal animal);
    Animal findByGender(Animal animal);
    Animal findByCatBreed(Animal animal);
    Animal findByDogBreed(Animal animal);
    List<Animal> findByDogBreedLike(String dogBreed);
    List<Animal> findByCatBreedLike(String catBreed);
}
