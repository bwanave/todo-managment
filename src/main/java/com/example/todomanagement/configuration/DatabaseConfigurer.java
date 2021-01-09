package com.example.todomanagement.configuration;

import com.example.todomanagement.jpa.entities.Todo;
import com.example.todomanagement.jpa.entities.User;
import com.example.todomanagement.jpa.repositories.TodoRepository;
import com.example.todomanagement.jpa.repositories.UserRepository;
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
        balaji.setRole(User.Role.ADMIN);
        balaji.setFullName("Balaji Wanave");
        balaji.setActive(true);
        balaji.setCreationTime(ZonedDateTime.now());
        balaji.setLastModifiedTime(ZonedDateTime.now());
        balaji.setCreatedBy("auto");
        balaji.setModifiedBy("auto");
        userRepository.save(balaji);

        Todo todo = new Todo();
        todo.setDescription("Learn SpringBoot technology");
        todo.setTargetDate(LocalDate.now().plusDays(5));
        todo.setUser(balaji);
        todoRepository.save(todo);
    }
}