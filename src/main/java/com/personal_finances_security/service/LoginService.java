package com.personal_finances_security.service;

import com.personal_finances_security.model.LoginUser;
import com.personal_finances_security.model.Role;
import com.personal_finances_security.repository.LoginRepository;
import com.personal_finances_security.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService implements UserDetailsService {

    private final LoginRepository loginRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser login = this.findByUsername(username);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        login.getRoles().forEach(
                role-> authorities.add(
                        new SimpleGrantedAuthority(role.getName())
                )
        );

        return new User(login.getUsername(), login.getPassword(), authorities);
    }

    public LoginUser save(LoginUser login){
        log.info("New login {}", login.getUsername());

        login.setPassword(passwordEncoder.encode(login.getPassword()));

        return loginRepository.save(login);
    }

    public LoginUser delete(String username){
        LoginUser login = this.findByUsername(username);
        loginRepository.delete(login);
        return login;
    }

    public LoginUser addRoleToLogin(String username, String roleName){
        LoginUser login = loginRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        login.getRoles().add(role);

        return loginRepository.save(login);
    }

    public LoginUser findByUsername(String username){
        return loginRepository.findByUsername(username);
    }

    public List<LoginUser> findAllLongins(){
        return loginRepository.findAll();
    }


}
