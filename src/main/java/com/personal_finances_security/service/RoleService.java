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

import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleService {

    private final RoleRepository roleRepository;

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public Role delete(String name){
        Role role = this.findByName(name);
        roleRepository.delete(role);

        return role;
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }
}
