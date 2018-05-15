package com.codeup.pawtify.daos;
import org.springframework.data.jpa.repository.Query;
import com.codeup.pawtify.models.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Roles extends CrudRepository<UserRole, Long> {
    //Used in the User Controller
    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    List<String> ofUserWith(String username);
}

