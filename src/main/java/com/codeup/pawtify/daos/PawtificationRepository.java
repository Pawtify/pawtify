package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.Animal;
import com.codeup.pawtify.models.Pawtification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PawtificationRepository extends CrudRepository<Pawtification, Long> {
    @Query(nativeQuery = true, value = " SELECT * FROM pawtifications WHERE user_id = ?1")
    List<Pawtification> findPawtificationByUserId(long id);

//    @Query(nativeQuery = true, value = "SELECT animals.id FROM animals INNER JOIN pawtifications ON pawtifications.size = animals.size AND pawtifications.color = animals.color AND pawtifications.gender = animals.gender AND pawtifications.age = animals.age AND (pawtifications.cat_breed_id = animals.cat_breed_id OR pawtifications.dog_breed_id = animals.dog_breed_id)")
//    List<Animal> fin
//   @Query(nativeQuery = true, value = "SELECT * FROM animals where animals.cat_breed_id IN (SELECT pawtifications.cat_breed_id FROM pawtifications WHERE user_id IN (SELECT id FROM users WHERE id = ?1")
//    List<Animal>
}
