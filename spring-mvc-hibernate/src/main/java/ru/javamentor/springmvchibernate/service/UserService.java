package ru.javamentor.springmvchibernate.service;

import ru.javamentor.springmvchibernate.model.User;

import java.util.List;

public interface UserService {
    User findById (Long id);
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
}
