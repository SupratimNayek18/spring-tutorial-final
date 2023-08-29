package com.spring.springsecurity2.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    private String userName;
    private String password;
    public String role;
    private Boolean enabled;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
