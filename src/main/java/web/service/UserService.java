package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    public User showUser(int id);
    public void saveUser(User user);
    public void updateUser(int id,User user);
    public void deleteUser(int id);
}
