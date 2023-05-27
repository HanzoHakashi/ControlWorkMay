package com.example.controlWorkMay.repositories;

import com.example.controlWorkMay.entity.User;
import com.example.controlWorkMay.entity.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
    List<User> findAllByRole(UserRole role);
}
