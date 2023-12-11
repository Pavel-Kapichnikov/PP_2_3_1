package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext()
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        String jpql = "SELECT u FROM User u";
        return em.createQuery(jpql).getResultList();
    }

    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void editUser(Long id, User user) {
        User userToBeEdit = getUserById(id);
        userToBeEdit.setName(user.getName());
        userToBeEdit.setLastName(user.getLastName());
        userToBeEdit.setAge(user.getAge());
        em.merge(userToBeEdit);
    }

    @Override
    public void deleteUser(long id) {
        em.remove(getUserById(id));
    }

}
