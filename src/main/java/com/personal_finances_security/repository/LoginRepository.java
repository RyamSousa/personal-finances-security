package com.personal_finances_security.repository;

import com.personal_finances_security.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginUser, Long> {

    LoginUser findByUsername(String username);

}
