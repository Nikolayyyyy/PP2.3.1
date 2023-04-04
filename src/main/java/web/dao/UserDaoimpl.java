package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoimpl implements UserDao {

    private EntityManagerFactory entityManagerFactory;

    public UserDaoimpl() {

    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> listUsers() {
        return null;
    }
}
