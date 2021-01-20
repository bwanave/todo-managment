package com.example.todomanagement.jpa.entities;

import com.example.todomanagement.models.UserModel;
import com.example.todomanagement.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private UserRole role;

    @Column
    private boolean active;

    @Column(nullable = false)
    private ZonedDateTime creationTime;

    @Column(nullable = false)
    private ZonedDateTime lastModifiedTime;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String modifiedBy;

    public UserModel toModel() {
        UserModel userModel = new UserModel();
        userModel.setId(this.id);
        userModel.setUsername(this.username);
        userModel.setFullName(this.fullName);
        return userModel;
    }

    public User() {
        this.active = true;
    }
}
