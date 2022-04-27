package com.example.Spring.Security.Repositories;

import com.example.Spring.Security.UsersEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer > {

    @Query(value = "select * from user where user.name = ?1", nativeQuery = true)
    User loadUserByUserName(@Param("name") String name);


}
