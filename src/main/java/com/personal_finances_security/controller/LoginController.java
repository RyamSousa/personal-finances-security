package com.personal_finances_security.controller;

import com.personal_finances_security.model.FormRoleToLogin;
import com.personal_finances_security.model.Login;
import com.personal_finances_security.model.Role;
import com.personal_finances_security.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private final LoginService loginService;

    @GetMapping(value = "/logins", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Login>> findAllLogins(){
        return ResponseEntity.ok(loginService.findAllLongins());
    }

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Login> save(@RequestBody Login login){
        return ResponseEntity.ok(loginService.save(login));
    }

    @PostMapping(value = "/roletologin", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Login> addRoleToLogin(@RequestBody FormRoleToLogin form){
        return ResponseEntity.ok(loginService.addRoleToLogin(form.getUsername(), form.getRoleName()));
    }
/*
    @GetMapping(value = "/login/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Login> findByUsername(@PathVariable Long id){
        return ResponseEntity.ok(loginService.findByUsername());
    }*/

}
