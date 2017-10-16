package com.styleus.backend.dao;

import com.styleus.backend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
     User findByUsername(String username);
     User findByEmail(String email);
}
