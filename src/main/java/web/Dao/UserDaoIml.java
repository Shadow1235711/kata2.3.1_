package web.Dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoIml implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User showUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        entityManager.merge(user);

    }

    @Override
    public void deleteUser(Long id) {
        if (entityManager.find(User.class, id) != null) {
            entityManager.remove(entityManager.find(User.class, id));
        }
    }


}
