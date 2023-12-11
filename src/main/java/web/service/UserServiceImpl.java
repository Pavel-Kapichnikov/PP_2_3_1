package web.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers(){return userDao.getAllUsers();}
    @Override
    @Transactional
    public void createUser(User user) {userDao.createUser(user);}
    @Override
    public User getUserById(Long id) {return userDao.getUserById(id);}
    @Override
    @Transactional
    public void editUser(Long id, User user) {userDao.editUser(id, user);}
    @Override
    @Transactional
    public void deleteUser(long id) {userDao.deleteUser(id);}
}
