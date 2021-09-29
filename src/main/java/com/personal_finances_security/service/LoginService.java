package com.personal_finances_security.service;

import com.personal_finances_security.model.Login;
import com.personal_finances_security.model.Role;
import com.personal_finances_security.repository.LoginRepository;
import com.personal_finances_security.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService {

    private final LoginRepository loginRepository;
    private final RoleRepository roleRepository;

    public Login save(Login login){
        return loginRepository.save(login);
    }

    public Login addRoleToLogin(String username, String roleName){
        Login login = loginRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        login.getRoles().add(role);

        return loginRepository.save(login);
    }
}
