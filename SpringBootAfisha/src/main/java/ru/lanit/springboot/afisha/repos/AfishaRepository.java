package ru.lanit.springboot.afisha.repos;

import org.springframework.data.repository.CrudRepository;
import ru.lanit.springboot.afisha.entities.Afisha;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AfishaRepository extends CrudRepository<Afisha, Long> {
    List<Afisha> findByName(String name);
}
