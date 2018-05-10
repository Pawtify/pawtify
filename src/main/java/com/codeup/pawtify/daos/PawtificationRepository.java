package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.CatBreed;
import com.codeup.pawtify.models.DogBreed;
import com.codeup.pawtify.models.Pawtification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PawtificationRepository extends CrudRepository<Pawtification, Long> {

    List<Pawtification> findAllByAgeAndSizeAndColorAndGenderAndCatBreed(String age, String size, String color, String gender, CatBreed catBreed);
    List<Pawtification> findAllByAgeAndSizeAndColorAndGenderAndDogBreed(String age, String size, String color, String gender, DogBreed dogBreed);

    @Query(nativeQuery = true, value = " SELECT * FROM pawtifications WHERE user_id = ?1")
    List<Pawtification> findPawtificationByUserId(long id);

//    @Query(nativeQuery = true, value = "SELECT animals.id FROM animals INNER JOIN pawtifications ON pawtifications.age = animals.age AND pawtifications.size = animals.size AND pawtifications.color = animals.color AND pawtifications.gender = animals.gender AND (pawtifications.cat_breed_id = animals.cat_breed_id OR pawtifications.dog_breed_id = animals.dog_breed_id)")
//    List<Animal> findAnimalsByPawtificationAndUser(long id);
//   @Query(nativeQuery = true, value = "SELECT * FROM animals where animals.cat_breed_id IN (SELECT pawtifications.cat_breed_id FROM pawtifications WHERE user_id IN (SELECT id FROM users WHERE id = ?1")
//    List<Animal>
}
