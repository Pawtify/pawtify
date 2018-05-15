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
    // METHODS FOR TWILIO USED IN THE PAWTIFICATION
    List<Pawtification> findAllByAgeAndSizeAndColorAndGenderAndCatBreed(String age, String size, String color, String gender, CatBreed catBreed);
    List<Pawtification> findAllByAgeAndSizeAndColorAndGenderAndDogBreed(String age, String size, String color, String gender, DogBreed dogBreed);

    //METHODS FOR THE PAWTIFICATION CONTROLLER, USED IN THE GET MAPPING PAWITIFICATION CREATE METHOD
    @Query(nativeQuery = true, value = " SELECT * FROM pawtifications WHERE user_id = ?1")
    List<Pawtification> findPawtificationByUserId(long id);
}
