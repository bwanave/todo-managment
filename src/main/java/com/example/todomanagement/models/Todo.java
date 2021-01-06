package com.example.todomanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private long id;
    private String description;
    private LocalDate targetDate;
}
