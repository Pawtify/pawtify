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
}
