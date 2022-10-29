package ru.javamentor.springmvchibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.springmvchibernate.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
