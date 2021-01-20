package com.example.todomanagement.configuration;

import com.example.todomanagement.jpa.entities.Todo;
import com.example.todomanagement.jpa.entities.User;
import com.example.todomanagement.jpa.repositories.TodoRepository;
import com.example.todomanagement.jpa.repositories.UserRepository;
import com.example.todomanagement.models.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Slf4j
@Configuration
class DatabaseConfigurer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, TodoRepository todoRepository) {
        return args -> configure(userRepository, todoRepository);
    }

    private void configure(UserRepository userRepository, TodoRepository todoRepository) {

        User balaji = new User();
        balaji.setUsername("Balaji");
        balaji.setPassword("dummy");
        balaji.setRole(UserRole.ADMIN);
        balaji.setFullName("Balaji Wanave");
        balaji.setActive(true);
        balaji.setCreationTime(ZonedDateTime.now());
        balaji.setLastModifiedTime(ZonedDateTime.now());
        balaji.setCreatedBy("auto");
        balaji.setModifiedBy("auto");
        userRepository.save(balaji);

        User rahul = new User();
        rahul.setUsername("Rahul");
        rahul.setPassword("dummy");
        rahul.setRole(UserRole.ADMIN);
        rahul.setFullName("Rahul Patil");
        rahul.setActive(true);
        rahul.setCreationTime(ZonedDateTime.now());
        rahul.setLastModifiedTime(ZonedDateTime.now());
        rahul.setCreatedBy("auto");
        rahul.setModifiedBy("auto");
        userRepository.save(rahul);

        Todo learnSpringBootTodo = new Todo();
        learnSpringBootTodo.setDescription("Learn SpringBoot framework");
        learnSpringBootTodo.setTargetDate(LocalDate.now().plusDays(5));
        learnSpringBootTodo.setCompleted(true);
        learnSpringBootTodo.setUser(balaji);
        todoRepository.save(learnSpringBootTodo);

        Todo learnPythonTodo = new Todo();
        learnPythonTodo.setDescription("Learn Python3 language");
        learnPythonTodo.setTargetDate(LocalDate.now().plusDays(5));
        learnPythonTodo.setCompleted(false);
        learnPythonTodo.setUser(balaji);
        todoRepository.save(learnPythonTodo);
    }
}