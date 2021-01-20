package com.example.todomanagement.jpa.entities;

import com.example.todomanagement.models.TodoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate targetDate;

    @Column(nullable = false)
    private boolean isCompleted;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public TodoModel toModel() {
        TodoModel todoModel = new TodoModel();
        todoModel.setId(this.id);
        todoModel.setDescription(this.description);
        todoModel.setTargetDate(this.targetDate);
        todoModel.setCompleted(this.isCompleted);
        return todoModel;
    }
}
