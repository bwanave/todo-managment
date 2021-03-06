package com.example.todomanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private long id;
    private String username;
    private String fullName;
    private boolean active;
}
