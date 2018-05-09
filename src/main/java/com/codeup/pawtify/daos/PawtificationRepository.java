package com.codeup.pawtify.daos;

import com.codeup.pawtify.models.Pawtification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PawtificationRepository extends CrudRepository<Pawtification, Long> {
    @Query(nativeQuery = true, value = " SELECT * FROM pawtifications WHERE user_id = ?1")
    List<Pawtification> findPawtificationByUserId(long id);

    @Query(nativeQuery = true, value = "SELECT pawtification.id, animals.name FROM animals INNER JOIN pawtifications ON pawtifications.size = animals.size ");

    @Query(nativeQuery = true, value = " select * from animal where cat_breed_id in (select cat_breed_id from pawtification where user_id in (select id from user where user = ?1")
}
