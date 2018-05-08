package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.CatBreed;
import com.codeup.pawtify.models.DogBreed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findAllByAgeAndSizeAndColorAndGenderAndCatBreed(String age, String size, String color, String gender, CatBreed catBreed);
    List<Animal> findAllByAgeAndSizeAndColorAndGenderAndDogBreed(String age, String size, String color, String gender, DogBreed dogBreed);
}
