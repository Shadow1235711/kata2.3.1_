package web.Dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    public User showUser(int id);
    public void saveUser(User user);
    public void updateUser(int id,User user);
    public void deleteUser(int id);
}
