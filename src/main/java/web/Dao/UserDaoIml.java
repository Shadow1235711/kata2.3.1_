package web.Dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoIml  implements UserDao {
    private static int UsersCount;
    private final List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++UsersCount,"Tom","Tom@mail.com"));
        users.add(new User(++UsersCount,"Bob","Bob@mail.com"));
        users.add(new User(++UsersCount,"Jack","Jack@mail.com"));
        users.add(new User(++UsersCount,"Jane","Jane@mail.com"));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User showUser(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null) ;
    }

    @Override
    public void saveUser(User user) {
        user.setId(++UsersCount);
        users.add(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User userToBeUpdated = showUser(id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setEmail(user.getEmail());

    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }


}
