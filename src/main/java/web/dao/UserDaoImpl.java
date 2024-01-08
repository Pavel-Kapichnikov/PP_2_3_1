package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        String jpql = "SELECT u FROM User u";
        return em.createQuery(jpql, User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        User user = em.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        return user;
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
