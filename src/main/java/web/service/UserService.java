package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    public User showUser(Long id);
    public void saveUser(User user);
    public void updateUser(Long id,User user);
    public void deleteUser(Long id);
}
