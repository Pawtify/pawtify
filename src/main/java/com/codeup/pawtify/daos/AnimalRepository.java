package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    @Query(nativeQuery =  true, value = "SELECT * from animals where rescueshelter_id = ?1")
    List<Animal> findAnimalsByRescueshelterId(long id);
}
