package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.CatBreed;
import com.codeup.pawtify.models.DogBreed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;


import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    List<Animal> findAllByAgeAndSizeAndColorAndGenderAndCatBreed(String age, String size, String color, String gender, CatBreed catBreed);
    List<Animal> findAllByAgeAndSizeAndColorAndGenderAndDogBreed(String age, String size, String color, String gender, DogBreed dogBreed);

    @Query(nativeQuery =  true, value = "SELECT * from animals where rescueshelter_id = ?1")
    List<Animal> findAnimalsByRescueshelterId(long id);

//    @Query(nativeQuery = true, value = "SELECT * FROM animals where cat_breed_id = ?1")
    List<Animal> findByCatBreed_BreedIsLike(String str);
    List<Animal> findByDogBreed_BreedIsLike(String str);
//    List<Animal> findByDogBreed_BreedIsLikeOrCatBreed_BreedIsLike(String str);
//    @Query(nativeQuery = true, value = "SELECT * FROM animals WHERE dog_breed_id = ?1")
//    List<Animal> findByCatBreed_BreedIsLikeOrDogBreed_BreedIsLike(String str);

//    List<Animal> findByDogBreed_Breed IsLikeOrCatBreedIsLike(String str);
}
