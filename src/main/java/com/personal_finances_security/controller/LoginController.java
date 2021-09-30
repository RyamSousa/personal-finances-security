package com.personal_finances_security.controller;

import com.personal_finances_security.model.FormRoleToLogin;
import com.personal_finances_security.model.LoginUser;
import com.personal_finances_security.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/api/login/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private final LoginService loginService;

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LoginUser>> findAllLogins(){
        return ResponseEntity.ok(loginService.findAllLongins());
    }

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginUser> saveLogin(@RequestBody LoginUser loginUser){
        return ResponseEntity.ok(loginService.save(loginUser));
    }

    @PostMapping(value = "/role", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginUser> addRoleToLogin(@RequestBody FormRoleToLogin form){
        return ResponseEntity.ok(loginService.addRoleToLogin(form.getUsername(), form.getRoleName()));
    }
/*
    @GetMapping(value = "/login/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginUser> findByUsername(@PathVariable Long id){
        return ResponseEntity.ok(loginService.findByUsername());
    }*/

}
