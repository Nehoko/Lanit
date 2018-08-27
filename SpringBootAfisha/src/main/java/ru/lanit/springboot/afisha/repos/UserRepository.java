package ru.lanit.springboot.afisha.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.lanit.springboot.afisha.entities.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
}