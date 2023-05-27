package com.example.controlWorkMay.repositorys;

import com.example.controlWorkMay.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

}
