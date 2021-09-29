package com.personal_finances_security.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(fetch = EAGER)
    private List<Role> roles = new ArrayList<>();
}
