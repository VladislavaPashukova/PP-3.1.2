package ru.javamentor.springmvchibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.springmvchibernate.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}
