
package com.quick.response.application.global.repositories;


import com.quick.response.application.global.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByUsername(String username);

    List<User> findAllByRoleTypeNot(String roleType);

    List<User> findUserByFirstNameContaining(String firstName);

}

