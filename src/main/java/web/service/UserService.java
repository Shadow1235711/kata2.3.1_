package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User showUser(Long id);

    void saveUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
