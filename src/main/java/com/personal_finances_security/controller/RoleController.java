package com.personal_finances_security.controller;

import com.personal_finances_security.model.Role;
import com.personal_finances_security.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/login/role")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleController {

    private final RoleService roleService;

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> findAllRoles(){
        return ResponseEntity.ok(roleService.findAllRoles());
    }

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok(roleService.save(role));
    }
}
