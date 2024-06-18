package com.swe1qq.stationery.ServiceLayer;

import com.swe1qq.stationery.DataAccessLayer.DAO.UserDAO;
import com.swe1qq.stationery.DataAccessLayer.Entity.User;
import java.util.List;

/**
 * Сервісний клас для роботи з користувачами.
 */
public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Додає нового користувача.
     *
     * @param user Об'єкт користувача для додавання.
     */
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    /**
     * Повертає список усіх користувачів.
     *
     * @return Список користувачів.
     */
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
