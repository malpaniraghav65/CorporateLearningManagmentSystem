package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;
    private String roleName;

//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users = new HashSet<>();

    public Role(Long id, String roleName) {
        this.rid = rid;
        this.roleName = roleName;
    }

    public Long getId() {
        return rid;
    }

    public void setId(Long id) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }
}
