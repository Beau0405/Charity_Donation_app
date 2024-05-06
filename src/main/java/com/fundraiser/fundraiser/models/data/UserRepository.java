package com.fundraiser.fundraiser.models.data;

import com.fundraiser.fundraiser.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

}
