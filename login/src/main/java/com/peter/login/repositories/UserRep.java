

package com.peter.login.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.peter.login.models.User;

@Repository
public interface UserRep extends CrudRepository<User, Long> {
    User findByEmail(String email);
}